import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    private static String myexpense = "./expenses.txt";
    private static File file = new File(myexpense);

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter ouput = null;

        if(file.exists()){
            ouput = new PrintWriter(new FileOutputStream(new File("expenses.txt"), true));
        }
        else{
            ouput = new PrintWriter(file);
        }
        for(Transaction tran : transactions){
            ouput.print(tran.getDate() + " ");
            ouput.print(tran.getDescription() + " ");
            ouput.println(tran.getAmount());
        }
        ouput.close();
    }

    public static ArrayList<Transaction> findAll() throws IOException{

        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            String info = input.nextLine();
            Transaction tran = prase(info);
            transactions.add(tran);
        }
        input.close();
        return transactions;
    }
    private static Transaction prase(String line) {
        String[] parts = line.split(" ");
        Transaction tran = new Transaction();
        // Assuming the format is date description amount
        tran.setDate(parts[0]);
        tran.setDescription(parts[1]);
        tran.setAmount(Double.parseDouble(parts[2]));
        return tran;
    }
}
