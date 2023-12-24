/**
 * Author : Komilov Doniyor
 * Date : 12/22/2023
 * Project Name : online-library
 */
package service.impl;

import enums.Role;
import model.User;
import realization.Main;
import service.BookService;
import service.RegistrationService;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationServiceImpl implements RegistrationService {
    public static Scanner scanner;

    static BookService bookService = new BookServiceImpl();

    @Override
    public boolean signUp() {
        scanner = new Scanner(System.in);
        System.out.print("Firstname: ");
        String firstname = scanner.nextLine();

        System.out.print("Lastname: ");
        String lastname = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        while (!validateEmail(email)) {
            System.out.println("Incorrect email format!");
            System.out.print("Email: ");
            email = scanner.nextLine();
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();
        boolean isSuccess = true;
        while (isSuccess) {
            System.out.print("ReturnPassword: ");
            String rePassword = scanner.nextLine();
            if (!password.equals(rePassword)) {
                System.out.println("Parol xato!!!");
            } else {
                isSuccess = false;
            }

        }

        int indexOfRole = 1;
        for (Role value : Role.values()) {
            System.out.println(indexOfRole + " " + value);
            indexOfRole++;
        }
        System.out.print("Choose the role: ");
        int roleIndex = scanner.nextInt();
        while (roleIndex >= indexOfRole || roleIndex < 1) {
            System.out.println("Incorrect input!");
            System.out.print("Choose the role: ");
            roleIndex = scanner.nextInt();
        }
        Role role = Role.values()[roleIndex - 1];

        Set<User> users = Main.users;
        int lastId = users.size() + 1;

        User newUser = new User(
                lastId,
                firstname,
                lastname,
                email,
                password,
                role,
                true
        );
        Main.users.add(newUser);
        return true;
    }

    @Override
    public boolean signIn() {
        scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.next();
        while (!validateEmail(email)) {
            System.out.println("Wrong email format!");
            System.out.print("Email: ");
            email = scanner.next();
        }
        System.out.print("Password: ");
        String password = scanner.next();

        for (User user : Main.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                Main.currentUser = user;
                return true;
            }
        }
        return false;
    }


    @Override
    public void showUserMenu() {
        boolean isSuccess = true;
        while (isSuccess) {
            scanner = new Scanner(System.in);
            bookService = new BookServiceImpl();
            userMenu();
            System.out.print("Select the option: = > ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> bookService.bronBook();
                case 2 -> bookService.returnBook();
                case 3 -> bookService.takeTheBook();
                case 0 -> {
                    boolean exit = Main.exit();
                    if (exit) {
                      isSuccess = false;
                    }
                }
                default -> System.out.println("Bunday operatsiya yo'q qaytadan urinib ko'ring!!!");
            }
        }

    }

    private void userMenu() {
        System.out.println("1.Kitob(lar)ni bron qilish");
        System.out.println("2.Kitobn(lar)ni qaytarib berish");
        System.out.println("3.Kitobni olib ketish");
        System.out.println("0.Chiqish");
        System.out.println("\n");
    }

    private static boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
