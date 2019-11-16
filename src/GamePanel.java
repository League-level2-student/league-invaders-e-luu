import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font Subtext;
	Timer frameDraw;
	
	void Font() {
		titleFont = new Font("Arial", Font.PLAIN,48);
		Subtext = new Font("Arial", Font.PLAIN, 30);
	}
	void Timer() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	GamePanel(){
		Font();
		Timer();
	}

	void updateMenuState() {

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
		g.drawString("League Invaders", 100,100);
		g.setFont(Subtext);
		g.setColor(Color.YELLOW);
		g.drawString("press ENTER to start", 190,300);
		g.drawString("press SPACE for instructions",175,400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
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
		if(currentState == MENU){
		    updateMenuState();
		    System.out.println("action");
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
	}
}
