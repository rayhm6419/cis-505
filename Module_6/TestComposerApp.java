import java.util.List;
import java.util.Scanner;

public class TestComposerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemComposerDAO dao = new MemComposerDAO();
        boolean run = true;

        while (run){
            menu();
            int input = scanner.nextInt();
            System.out.println();
            System.out.println("--DISPALYING COMPOSERS--");
            switch (input){
                case 1:
                    List<Composer> composers = dao.findAll();
                        for (Composer composer : composers){
                            System.out.println(composer.toString());
                        }
                    break;

                case 2:
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    System.out.println(dao.findBy(id).toString());
                    break;

                case 3:
                    System.out.println("Enter ID:");
                    int inputId = scanner.nextInt();
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter genre:");
                    String genre = scanner.next();
                    dao.insert(new Composer(inputId, name, genre));
                    break;

                case 4:
                    run = false;
                    break;
                }
            }
        }

    public static void menu(){
        System.out.println("MENU OPTIONS" + "\n" + " 1.View Composers" + "\n" +
                " 2.Find Composers" + "\n" +
                " 3.Add Composers" + "\n" +
                " 4.Exit" +"\n" + "\n" +
                "Please choose an option: ");
    }
}
