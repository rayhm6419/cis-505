package Module_5;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

public class TransactionIO {
    private static String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {

        PrintWriter output = null;

        if(file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        }
        else {
            output = new PrintWriter(FILE_NAME);
        }

        for(Transaction tran : transactions) {
            output.print(tran.getDate()+" ");
            output.print(tran.getDescription()+" ");
            output.println(tran.getAmount());
        }

        output.close();

    } 

    public static ArrayList<Transaction> findAll() throws IOException {

        Scanner input = new Scanner(file);
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        while(input.hasNext()) {
            transactions.add(new Transaction(input.next(), input.next(), input.nextDouble()));
        }

        input.close();
        return transactions;

    } 
    
}
