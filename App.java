import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc;
        while (true) {
            out.println("\n CRUD Console Aplication");
            out.println("1: Create, 2: Read, 3: Update, 4: Delete");
            sc = new Scanner(System.in);
            int n = sc.nextInt();

            if (n<1 || n>5) break;
            switch(n) {
                case 1 -> {
                    sc.nextLine();
                    out.println("enter user name");
                    String name = sc.nextLine();
                    out.println("enter user email");
                    String email = sc.nextLine();
                    out.println("enter user pass");
                    String pass = sc.nextLine();
                    out.println(name + " " +  email + " " + pass);
                    UserDetails ud = new UserDetails(name, email, pass);
                    UserDetailsDao.createUser(ud);
                    break;
                }
                case 2 -> {
                    ArrayList<UserDetails> list = UserDetailsDao.printUser();
                    out.println("-----------user_details Table--------------");
                    list.forEach(out::println);
                    break;
                }

                case 3 -> {
                    out.println("enter id and name");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    UserDetailsDao.update(id, name);
                    break;
                } 
                case 4 -> out.println("4");
                default -> out.println("-----------Choose options from 1 to 4-----------");
            }
        }
        sc.close();
    }
}
