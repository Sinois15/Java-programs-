import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class Ship {
 private int x;
 private int dx = 0;
 private int y;
 private int dy = 0;
 private int speed;
 private Random rdm = new Random();

 public Ship(int sx, int sy, int s) {
 x = sx;
 y = sy;
 speed = s;
 }

 public void drawPlayerShip(Graphics g) {
 g.setColor(Color.YELLOW);
 g.fillRect(x, y, 30, 30);
 }
 public void drawVaderShip(Graphics g) {
 g.setColor(Color.RED);
 g.fillRect(x, y, 30, 30);
 }

 public boolean playerCollideBorder() {
 boolean collide = false;
 if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570))
 collide = true;
 return collide;
 }
 public void handleVaderCollideBorder() {
 if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
 dx = -dx;
 dy = -dy;
 }
 updatePosition();
 }

 public void updatePosition() {
 x = x + dx;
 y = y + dy;
 }

 public void moveVader() {
 int dir = rdm.nextInt(4);
 if (dir == 0) moveLeft();
 else if (dir == 1) moveUp();
 else if (dir == 2) moveRight();
 else if (dir == 3) moveDown();
 }

 public void moveLeft() {
 dx = -speed;
 dy = 0;
 }
 public void moveRight() {
 dx = speed;
 dy = 0;
 }
 
 public void moveUp() {
 dx = 0;
 dy = -speed;
 }
 public void moveDown() {
 dx = 0;
 dy = speed;
 }
}

