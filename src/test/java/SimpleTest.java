import com.sun.prism.shader.Solid_ImagePattern_Loader;
import junit.framework.TestCase;

/**
 * Created by keith on 2016/7/23 0023.
 */
public class SimpleTest extends TestCase {
	public void testStrAppend() {
		int maxNum = 1000000;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < maxNum; i++) {
			String str1 = "abc %s";
			String str2 = "123";
			String.format(str1, str2);
		}
		System.out.println("time cost:"+(System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		for(int i = 0; i < maxNum; i++) {
			StringBuffer stringBuffer = new StringBuffer("abc ");
			String str2 = "123";
			stringBuffer.append(str2).toString();
		}
		System.out.println("time cost:"+(System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		for(int i = 0; i < maxNum; i++) {
			StringBuilder stringBuffer = new StringBuilder("abc ");
			String str2 = "123";
			stringBuffer.append(str2).toString();
		}
		System.out.println("time cost:"+(System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		for(int i = 0; i < maxNum; i++) {
			String str1 = "abc ";
			String str2 = "123";
			String str3 = str1 + str2;
		}
		System.out.println("time cost:"+(System.currentTimeMillis() - startTime));
	}
}
