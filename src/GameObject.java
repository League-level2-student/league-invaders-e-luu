import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		if (up == true) {
			y -= 5;
		}
		if (down == true) {
			y += 5;
		}
		if (left == true) {
			x -= 5;
		}
		if (right == true) {
			x += 5;
		}
	}

	void draw(Graphics graphics) {
		graphics.fillRect(x, y, 100, 100);
	}
}
