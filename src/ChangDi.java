import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChangDi extends Frame {

    ArrayList<CheChe> cheku = new ArrayList<>();
    MaNong mn = new MaNong(this);
    CheChe cc = null;
//            new CheChe(200,30,this,this.mn);
    Image offScreenImage = null;
    Boolean ifHit = false;
    int defen ;
    static int jishi = 1;

    public static void main(String[] args) {
        new ChangDi().lunch();
    }


    public void lunch(){
        setBounds(200,100,800,600);
        setTitle("码农躲车车");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });
        new Thread(new Show(this)).start();
        new Thread(new PaintThread()).start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Add()).start();
        new Thread(new AddMN()).start();
        addKeyListener(new YiDong());
    }

    @Override
    public void paint(Graphics g) {
        if(jishi != 3){
            switch (jishi) {
                case 1:
                    g.drawString("码农躲车车，看你能坚持多久", 300, 300);
                    break;
                case 2:
                    g.drawString("加油！", 300, 300);
                    break;
            }
            return;
        }
        if(ifHit){
            g.drawString("游戏结束，得分"+(defen-80),370,260);
            return;
        }
        for(int i=0;i<cheku.size();i++){
            cc = cheku.get(i);
            cc.draw(g);
        }
        mn.draw(g);
        for(int i=0;i<cheku.size();i++){
            cc = cheku.get(i);
        if(cc.hitMaNong()){
            if(cc.name == "cheche") ifHit = true;
        }
        }
        if(defen-80<0) g.drawString("分数:"+0,20,50);
        else g.drawString("分数:"+defen,20,50);
    }

    private class PaintThread implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    }

    private class YiDong extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            mn.keyPressed(e);
        }
    }

    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(800, 600);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.CYAN);
        gOffScreen.fillRect(0, 0, 800, 600);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    class Add implements Runnable{
        @Override
        public void run() {
            while (mn.live){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            defen+=10;
            addCheChe();
        }
        }
    }
    class AddMN implements Runnable{
        @Override
        public void run() {
            while (mn.live){
                addMeiNv();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void addCheChe(){
        int r;
        for(int i=0;i<8;i++){
            r = (int)(Math.random()*32);
            cheku.add(new CheChe(25*r,30,this,this.mn));
        }
    }
    public void addMeiNv(){
            int r = (int)(Math.random()*26);
            cheku.add(new MeiNv(25*r,30,this,this.mn));
        }
    }



