package realization;

import enums.Role;
import model.Book;
import model.Library;
import model.User;
import service.AdminService;
import service.ModeratorService;
import service.RegistrationService;
import service.impl.AdminServiceImpl;
import service.impl.ModeratorServiceImpl;
import service.impl.RegistrationServiceImpl;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static Scanner scanner;
    public static Set<User> users = new HashSet<>();
    public static List<Book> books = new ArrayList<>();

    public static Library library;


    static RegistrationService registrationService;
    static ModeratorService moderatorService;
    static AdminService adminService;

    public static User currentUser;

    public static void main(String[] args) {

        users.add(new User(1, "aaa", "aaa", "aaa@gmail.com", "123", Role.MODERATOR, true));
        users.add(new User(2, "ddd", "ddd", "ddd@gmail.com", "123", Role.MODERATOR, true));
        users.add(new User(3, "bbb", "bbb", "bbb@gmail.com", "123", Role.USER, true));
        users.add(new User(4, "ccc", "ccc", "ccc@gmail.com", "123", Role.ADMIN, true));
        library = new Library(1, 5, List.of(new Book(1, "Xamsa", "Alisher Navoiy", 500, true),
                new Book(2, "Atom habits", "James Clear", 462, true)), LocalDateTime.now());


        boolean isSuccess = true;
        while (isSuccess) {
            scanner = new Scanner(System.in);
            showMainMenu();
            System.out.print("Select the option: = > ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    signUp();
                    break;

                case 2:
                    signIn();
                    break;
                default:
                    System.out.println("Incorrect option!");
                    isSuccess = false;
            }
        }


    }

    private static void signUp() {
        registrationService = new RegistrationServiceImpl();
        boolean isSuccess = registrationService.signUp();
        if (isSuccess) {
            System.out.println("Siz muvaffaqiyatli ro'yhatdan o'tdingiz :)");
        } else
            System.out.println("Siz muvaffaqiyatli ro'yhatdan o'tdingiz :(");
    }

    private static void signIn() {
        registrationService = new RegistrationServiceImpl();
        moderatorService = new ModeratorServiceImpl();
        adminService = new AdminServiceImpl();
        boolean isSuccess = registrationService.signIn();
        if (isSuccess) {
            switch (currentUser.getRole()) {
                case USER -> registrationService.showUserMenu();
                case MODERATOR -> moderatorService.showModeratorMenu();
                case ADMIN -> adminService.showAdminMenu();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("1. Ro'yhatdan o'tish ");
        System.out.println("2. Login ");
        System.out.println("0. Exit ");
    }

    public static boolean exit() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Haqiqatdan chiqib ketmoqchimisz? (yes/no):");
            String exitText = scanner.nextLine();
            if (exitText.equals("yes")) {
                User currentUser = Main.currentUser;
                currentUser.setSignIn(false);
                return true;
            } else if (exitText.equals("no")) {
                return false;
            } else {
                System.out.println("Bunday so'z kiritish mumkin emas!!!");
            }
        }
    }
}