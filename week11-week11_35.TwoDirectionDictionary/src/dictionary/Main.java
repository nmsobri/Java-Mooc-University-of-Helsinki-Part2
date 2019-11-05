package dictionary;

public class Main {

	public static void main(String[] args) throws Exception{
		MindfulDictionary dict = new MindfulDictionary("src/words.txt");
		dict.load();

		System.out.println(dict.translate("apina"));
		System.out.println(dict.translate("ohjelmointi"));
		System.out.println(dict.translate("alla oleva"));
	}
}
