package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class SemClass extends Thread {
    static ResultSet rs;
    private Semaphore semaphore;
    private int duration;
    private String threadName;

    public SemClass(Semaphore semaphore, int duration, String threadName) {
        this.semaphore = semaphore;
        this.duration = duration;
        this.threadName = threadName;
    }


    @Override
    public void run() {

        try {
           rs = Database.st.executeQuery("SELECT * FROM samTable WHERE name ='" + threadName + "'");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                semaphore.acquire();
                System.out.println(threadName + "  Siraniz Geldi");
                waiter(1);
                System.out.println(threadName + "  islemler yapiliyor");
                waiterDot(1);
                System.out.println(threadName + "  islem tamamlandi");
                semaphore.release();
                System.out.println("test-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("------");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println();

    }

    public void waiter(int timeout) {

        try {
            Thread.sleep(timeout * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waiterDot(int timeout) {
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(timeout * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
        System.out.println();
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
