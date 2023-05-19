package bank;

import static bank.Methods.bankRun;
import static bank.Methods.nameList;

public class Runner {
    public static void main(String[] args) {

        System.out.println(nameList);
        Sql.createTable();
        Sql.createSamTable();
        bankRun();    }


}
