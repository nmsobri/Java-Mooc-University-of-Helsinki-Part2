
public class Smileys {

	public static void main(String[] args) {
		System.out.println("Hello world");
		printWithSmileys("Method");
		printWithSmileys("Beerbottle");
		printWithSmileys("Interface");
	}

	private static void printWithSmileys(String text) {
		String smiley = ":)";
		int textLength = text.length();

		if (textLength % 2 == 1) {
			text += " ";
			textLength += 1;
		}

		int smileyAmount = (textLength + 6) / 2;

		printSmiley(smiley, smileyAmount);
		System.out.println(smiley + " " + text + " " + smiley);
		printSmiley(smiley, smileyAmount);
	}

	private static void printSmiley(String smiley, int smileyAmount) {
		for (int i = 0; i < smileyAmount; i++) {
			System.out.print(smiley);
		}

		System.out.println();
	}

}
