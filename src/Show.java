import java.awt.*;

public class Show implements Runnable {
    ChangDi cd;

    public Show(ChangDi cd) {
        this.cd = cd;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cd.jishi = 2;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cd.jishi = 3;
    }

}
