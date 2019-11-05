
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

	public static void main(String[] args) {
		HashMap<String, String> persons = new HashMap<String, String>();

		persons.put("matti", "mage");
		persons.put("mikael", "mixu");
		persons.put("arto", "arppa");

		System.out.println(persons.get("mikael"));
	}

}
