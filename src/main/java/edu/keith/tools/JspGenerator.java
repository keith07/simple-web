package edu.keith.tools;

import com.sun.org.apache.bcel.internal.classfile.Field;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QiGuanYi on 2016/5/17.
 */
public class JspGenerator {
	private static final String classDir = "C:\\tmpClasses";

	/**
	 * 根据路径得到要处理的类及其字段
	 * @param path
	 * @return
	 * entityName:[{name:xxx,type:xxx}]
	 */
	private static Map<String,List<Map<String,String>>> getTaskMap(String path) throws Exception {
		Map<String, List<Map<String, String>>> result = new HashMap<>();
		String filePath = path;
		String sourceDir = path;
		File root = new File(classDir);
		root.mkdirs();
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		boolean compilerResult = DynamicCompilerUtil.compiler(filePath, sourceDir, classDir, diagnostics);
		java.lang.ClassLoader classLoader = dynamicLoad(classDir);
		List<File> classFiles = new ArrayList<>();
		findFilesWithNameFilter(root, classFiles, (FilenameFilter) new SuffixFileFilter("class"));
		for (File file : classFiles) {
			String className =file.toString();
			className = className.substring(0, className.length() - 6);;
			className = className.replace(File.separatorChar, '.');
			className = className.substring(className.lastIndexOf("edu.keith"));
			String entityName = className.substring(className.lastIndexOf(".")+1);
			Class c = Class.forName(className);
			java.lang.reflect.Field[] fields = c.getDeclaredFields();
			List<Map<String, String>> fieldList = new ArrayList<>(fields.length);
			for (java.lang.reflect.Field field : fields) {
				Map<String, String> fieldMap = new HashMap<>(2);
				fieldMap.put("name", field.getName());
				fieldMap.put("type", field.getAnnotatedType().getType().getTypeName());
				fieldList.add(fieldMap);
			}
			result.put(entityName, fieldList);
		}
		return result;
	}

	private static void findFiles(File file, List<File> fileList) {
		if (fileList == null) {
			fileList = new ArrayList<>();
		}
		if (!file.isDirectory()) {
			fileList.add(file);
			return;
		}
		for(File subFile : file.listFiles())
			findFiles(subFile,fileList);
	}
	private static void findFilesWithNameFilter(File rootPath,List<File> fileList,FilenameFilter filter) {
		if (!rootPath.isDirectory()) {
			return;
		}
		for (File file : rootPath.listFiles(filter)) {
			fileList.add(file);
		}
		for (File subDir : rootPath.listFiles()) {
			findFilesWithNameFilter(subDir,fileList,filter);
		}
	}

	private static java.lang.ClassLoader dynamicLoad(String path) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		File file = new File(path);
		URLClassLoader classloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
		add.setAccessible(true);
		add.invoke(classloader, new Object[]{file.toURI().toURL()});
		return classloader;
	}

	private static String pickEntityName(String fileName) {
		return fileName.replaceAll(".class", "");
	}

	/**
	 * 得到模板类
	 * @param type
	 * @return
	 */
	private static String genTemplateJsp(String type) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/webapp/static/"+type+"Template.jsp")));
//		FileReader fileReader = new FileReader("src/main/webapp/static/"+type+"Template.jsp");
//		CharBuffer charBuffer = CharBuffer.allocate(1024);
//		char[] chars = new char[1024];
//		fileReader.read(chars);
//		StringBuffer stringBuffer = new StringBuffer(charBuffer);
//		while (charBuffer.hasRemaining()) {
//			stringBuffer.append(charBuffer);
//		}
		StringBuffer stringBuffer = new StringBuffer();
		String data;
		while ((data = br.readLine()) != null) {
			stringBuffer.append(data).append("\r\n");
		}
		return stringBuffer.toString();
	}

	/**
	 * 具体化
	 * @param entityName
	 * @param type
	 * @return
	 */
	private static String specializeJsp(String entityName, List<Map<String, String>> fields,String type) throws IOException {
		entityName = toFirstLower(entityName);
		String template = genTemplateJsp(type);
		if(type.toLowerCase().equals("list"))
			return new ListContentResolver().resolve(template, entityName, fields);
		//TODO
		return null;
	}

	private static String toFirstLower(String string) {
		return string.substring(0,1).toLowerCase()+string.substring(1);
	}

	/**
	 * 存文件
	 * @param entityName
	 * @param value
	 * @param destPath
	 */
	private static void writeFile(String entityName, String value,String destPath){
		File file = new File(destPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(destPath + "/" + entityName + ".jsp");
			fw.write(value);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
				fw = null;
			}
		}
	}

	public static void genJsp(String entityPath, String destPath) throws Exception {
		Map<String, List<Map<String, String>>> entities = getTaskMap(entityPath);
		for (String entityName : entities.keySet()) {
//			writeFile(entityName,specializeJsp(entityName,entities.get(entityName),"view"),destPath);
//			writeFile(entityName,specializeJsp(entityName,entities.get(entityName),"update"),destPath);
			writeFile(entityName,specializeJsp(entityName,entities.get(entityName),"list"),destPath);
		}
	}

	public static void main(String[] args) throws Exception {
		String entityPath = "src/main/java/edu/keith/mvc/bean";
		String destPath = "gen";
		genJsp(entityPath,destPath);
	}
}

interface IContentResolver {
	String resolve(String template, String entityName, List<Map<String, String>> fields);
}

class ListContentResolver implements IContentResolver {
	@Override
	public String resolve(String template, String entityName, List<Map<String, String>> fields) {
		StringBuffer thBuffer = new StringBuffer();
		StringBuffer tdBuffer = new StringBuffer();
		for (Map<String, String> field : fields) {
			thBuffer.append("<th>"+field.get("name")+"</th>\r\n");
			tdBuffer.append("<td>{{"+entityName+"."+field.get("name")+"}}</th>\r\n");
		}
		template = template.replaceAll("#\\{\\{entityName\\}\\}#",entityName);
		template = template.replaceAll("#\\{\\{fieldThs\\}\\}#",thBuffer.toString());
		template = template.replaceAll("#\\{\\{fieldTds\\}\\}#",tdBuffer.toString());
		return template;
	}
}
