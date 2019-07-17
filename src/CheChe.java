import java.awt.*;
import java.lang.management.ManagementFactory;

public class CheChe {
    int x;
    int y;
    ChangDi cd;
    MaNong mn;
    boolean live = true;
    public String name = "cheche";
    public CheChe(int x, int y, ChangDi cd,MaNong mn) {
        this.x = x;
        this.y = y;
        this.cd = cd;
        this.mn = mn;
    }

    public void draw(Graphics g){
        if(live == false)return;
        Color c = g.getColor();
        g.setColor(Color.BLACK);
        g.drawString("车车",x,y);
        y+=4;
        g.setColor(c);
        if(y>620){
            live = false;
            cd.cheku.remove(this);
        }
    }
    public Rectangle getRect() {
        return new Rectangle(x+2, y, 18, 5);
    }

    public boolean hitMaNong(){
        if(this.getRect().intersects(mn.getRect())){
            mn.live = false;
            return true;
        }
        return false;
    }
}
