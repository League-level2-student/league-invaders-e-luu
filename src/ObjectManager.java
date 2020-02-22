import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectile = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();
	Random random = new Random();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile projectile) {

	}

	void addAlien() {
		alien.add(new Alien(random.nextInt(LeagueInvaders.width), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).update();

			if (alien.get(i).y > LeagueInvaders.height) {
				alien.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).update();
			if(projectile.get(i).y < 0) {
				projectile.get(i).isActive = false;
			}
		}

	}

	void draw(Graphics graphics) {
		rocket.draw(graphics);
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).draw(graphics);
		}
		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).draw(graphics);
		}
	}
	void purgeObjects() {
		for (int i = 0; i < alien.size(); i++) {
			if (alien.get(i).isActive == false) {
				alien.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
