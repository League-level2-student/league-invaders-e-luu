import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	static final int width = 500;
	static final int height = 800;

	LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}

	public static void main(String[] args) {
		LeagueInvaders l = new LeagueInvaders();
		l.setup();
	}

	void setup() {
		frame.add(panel);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.pack();
	}

}
