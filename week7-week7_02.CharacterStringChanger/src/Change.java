
public class Change {

	private char from;
	private char to;

	public Change(char from, char to) {
		this.from = from;
		this.to = to;
	}

	public String change(String word) {
		String result = "";

		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);

			if (current == this.from) {
				result += this.to;
			} else {
				result += current;
			}
		}

		return result;
	}
}
