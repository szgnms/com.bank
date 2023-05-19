package bank;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import static bank.Database.st;
import static bank.SemClass.rs;


public class Methods {
    static Scanner scan = new Scanner(System.in);
   static Semaphore smp= new Semaphore(3);
    static List<String> nameList = new ArrayList<>();

    static SemClass sem;
    public static void createAccount() {



        System.out.println("Please enter name");
        String name = scan.next();
        System.out.println("Please enter surname");
        String surname = scan.next();
        System.out.println("Please enter id");
        int id = scan.nextInt();

        Account account = new Account(name, surname, id);
        sem=new SemClass(smp,2000,account.getName());
        nameList.add(sem.getName());


        try {
            st.execute("INSERT INTO bank  values ("+"'"+account.getName()+"'"+", "+"'"+account.getSurname()+"'"+", "+account.getId()+ ")");
        st.execute("INSERT INTO samTable Values("+"'"+sem.getSemaphore()+"'"+", "+sem.getDuration()+", "+"'"+sem.getThreadName()+"'"+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bankRun();
    }

public static void bankRun()  {
    System.out.println("Hosgeldiniz \n" +
            "yapmak istediginiz islemi seciniz 1- kullanici kaydi 2- thread calistir");
    String secim=scan.next();
    switch(secim) {
        case "1" : createAccount();

        case "2" : runThread();

        default:
            System.out.println("yanlis giris");
            bankRun();

            }



}

    private synchronized static void runThread() {
         String thName="Select name from samtable";

        try {
          rs= st.executeQuery(thName);
           while (rs.next()) {

               sem=new SemClass(smp,2000, rs.getString("name"));
               sem.start();
           }



            Methods.bankRun();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
