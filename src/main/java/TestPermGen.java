import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/19.
 */
public class TestPermGen {
	public static List<String> strs = new ArrayList<>();

	public static void main(String[] args) {
		while (true) {
			strs.add(new String(System.nanoTime() + "xxxxxxxxxxxxx"));
		}
	}
}
