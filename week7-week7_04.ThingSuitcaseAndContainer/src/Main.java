
public class Main {

	public static void main(String[] args) {
		Container container = new Container(1000);
		addSuitcasesFullOfBricks(container);
		System.out.println(container);

	}

	public static void addSuitcasesFullOfBricks(Container container) {
		for (int i = 0; i < 100; i++) {
			Suitcase s = new Suitcase(i + 1);
			s.addThing(new Thing("Brick", i + 1));
			container.addSuitcase(s);
		}
	}

}
