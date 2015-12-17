import java.util.regex.Pattern;

import org.elasticsearch.common.regex.Regex;


public class TestRegex {

	public static void main(String[] args){
//		Pattern p = Pattern.compile("(?sm)(\"(\"))");
		String str = "aasma\"b\"";
		System.out.println("before:"+str);
		System.out.println("after:"+str.replaceAll("(?:sm)(a\"(b\"))", "2$12"));
		System.out.println("after:"+str.replaceAll("(?sm)(a\"b\")", "2$12"));
		System.out.println("after:"+str.replaceAll("(?sm)(a\"(b\"))", "2$22"));
	}
}
