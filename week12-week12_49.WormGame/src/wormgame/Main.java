package wormgame;

import wormgame.game.WormGame;
import javax.swing.SwingUtilities;
import wormgame.gui.UserInterface;

public class Main {

	public static void main(String[] args) {
		WormGame game = new WormGame(20, 20);

		UserInterface ui = new UserInterface(game, 20);
		SwingUtilities.invokeLater(ui);

		// Waiting for ui readiness
		while (ui.getUpdatable() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				System.out.println("The drawing board hasn't been created yet.");
			}
		}

		// Link ui to game
		game.setFrame(ui.getFrame());
		game.setUpdatable(ui.getUpdatable());
		game.start();
	}
}
