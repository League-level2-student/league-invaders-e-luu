import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font Subtext;
	Timer frameDraw;
	GameObject object;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);

	void Font() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		Subtext = new Font("Arial", Font.PLAIN, 30);
	}

	void Timer() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	GamePanel() {
		Font();
		Timer();

	}

	void updateMenuState() {
manager.update();
	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 100, 100);
		g.setFont(Subtext);
		g.setColor(Color.YELLOW);
		g.drawString("press ENTER to start", 130, 300);
		g.drawString("press SPACE for instructions", 75, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 100, 100);
		g.setFont(Subtext);
		g.setColor(Color.YELLOW);
		g.drawString("You killed enemies", 130, 300);
		g.drawString("press ENTER to restart", 75, 400);
	}

	@Override
	public void paintComponent(Graphics g) {
		rocket.draw(g);
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key pressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
	}
}
