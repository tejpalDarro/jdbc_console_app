import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc;
        while (true) {
            out.println("\n ------CRUD CONSOLE APPLICATION------");
            out.println("""
                ---------------------------------------------------
                | 1. Create                                       |
                | 2. Read                                         |
                | 3. Update (Update user name with id)            |
                | 4. Delete (Delete entire row with user id)      |
                ---------------------------------------------------
                """);
            //1: Create, 2: Read, 3: Update, 4: Delete
            sc = new Scanner(System.in);
            int n = sc.nextInt();

            if (n<1 || n>5) break;
            switch(n) {
                case 1 -> {
                    sc.nextLine();
                    out.println("-----Enter user_name-----");
                    String name = sc.nextLine();
                    out.println("-----Enter user_email-----");
                    String email = sc.nextLine();
                    out.println("-----Enter user_pass-----");
                    String pass = sc.nextLine();
                    out.println(name + " " +  email + " " + pass);
                    UserDetails ud = new UserDetails(name, email, pass);
                    UserDetailsDao.createUser(ud);
                    break;
                }
                case 2 -> {
                    ArrayList<UserDetails> list = UserDetailsDao.printUser();
                    out.println("-----------UserDetails Table--------------");
                    list.forEach(out::println);
                    break;
                }

                case 3 -> {
                    out.println("-----Enter Id and Name-----");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    UserDetailsDao.update(id, name);
                    break;
                } 
                case 4 -> {
                    out.println("-----Enter Id to Delete-----");
                    int id = sc.nextInt();
                    UserDetailsDao.delete(id);
                    break;
                }
                default -> out.println("-----------Choose options from 1 to 4-----------");
            }
        }
        sc.close();
    }
}
