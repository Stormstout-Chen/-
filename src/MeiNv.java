import java.awt.*;

public class MeiNv extends CheChe{
    int x,y;
    boolean live = true;
    ChangDi cd;
    MaNong mn;
    public String name = "meinv";

    public MeiNv(int x, int y,ChangDi cd, MaNong mn) {
        super(x,y,cd,mn);
        this.x = x;
        this.y = y;
        this.cd = cd;
        this.mn = mn;
    }
    public void draw(Graphics g){
        if(live == false)return;
        Color c = g.getColor();
        g.setColor(Color.red);
        g.drawString("美女",x,y);
        y+=3;
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
            cd.defen+=100;
            cd.cheku.remove(this);
            return false;
        }
        return false;
    }
}
