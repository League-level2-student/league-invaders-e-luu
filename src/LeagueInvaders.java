import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;
LeagueInvaders(){
	frame = new JFrame();
}
public static void main(String[] args) {
	LeagueInvaders l = new LeagueInvaders();
	l.setup();
}
void setup() {
	frame.setPreferredSize(new Dimension(width,height));
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
}

}
