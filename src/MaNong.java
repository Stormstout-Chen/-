import java.awt.*;
import java.awt.event.KeyEvent;

public class MaNong {
    ChangDi cd;
    int x = 400;
    int y = 560;
    boolean live = true;

    public MaNong(ChangDi cd) {
        this.cd = cd;
    }
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.black);
        g.drawString("码农",x,y);
        g.setColor(c);
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT :
                x -= 10;
                break;
            case KeyEvent.VK_RIGHT :
                x += 10;
                break;
        }

    }
    public Rectangle getRect() {
        return new Rectangle(x+1, y, 18, 5);
    }


}
