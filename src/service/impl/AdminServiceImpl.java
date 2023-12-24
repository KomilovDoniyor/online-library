/**
 * Author : Komilov Doniyor
 * Date : 12/24/2023
 * Project Name : online-library
 */
package service.impl;

import enums.Role;
import model.User;
import realization.Main;
import service.AdminService;

import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    public static Scanner scanner;
    @Override
    public void showAdminMenu() {

        boolean isSuccess = true;
        while (isSuccess) {
            scanner = new Scanner(System.in);
            adminMenu();
            System.out.print("Select the option: = > ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> libraryViewWorkers();
                case 2 -> libraryViewUsers();
                case 3 -> libraryDeleteWorker();
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

    private void libraryViewWorkers() {
        if (Main.users != null) {
            for (User user : Main.users) {
                if (user != null) {
                    if (user.getRole().equals(Role.MODERATOR)) {
                        System.out.println(user.toStringUser());
                    }
                }
            }
        } else {
            System.out.println("Sizda ishchilar qolmagan!!!");
        }

    }

    private void libraryViewUsers() {
        if (Main.users != null) {
            for (User user : Main.users) {
                if (user != null) {
                    if (user.getRole().equals(Role.USER)) {
                        System.out.println(user.toStringUser());
                    }
                }
            }
        } else {
            System.out.println("Sizda foydalanuvchilar yo'q!!!");
        }
    }

    private void libraryDeleteWorker() {
        boolean isSuccess = true;
        while (isSuccess) {
            scanner = new Scanner(System.in);
            if (Main.users != null) {
                for (User user : Main.users) {
                    if (user != null) {
                        if (user.getRole().equals(Role.MODERATOR)) {
                            System.out.println(user.toStringUser());
                        }
                    }
                }
            } else {
                System.out.println("Sizda ishchilar qolmagan!!!");
            }
            System.out.println("O'chirmoqchi(Ishdan haydamoqchi) bo'lgan ishchini ko'rsating:");
            int removeWorkerId = scanner.nextInt();
            for (User user : Main.users) {
                if (user != null) {
                    if (user.getRole().equals(Role.MODERATOR)) {
                        if (user.getId() == removeWorkerId) {
                            Main.users.remove(user);
                        }
                    }
                }
            }
            System.out.println("Muvaffaqiyatli o'chirildi!!!");
            System.out.println("Yana ishchi o'chirmoqchimisz?(yes/no)");
            String next = scanner.next();
            if (!next.equals("yes")) {
                isSuccess = false;
            }
        }
    }

    /**
     * Faqat shu 3 ta operatsiya kiritilda(Default holat uchun)
     */
    private void adminMenu() {
        System.out.println("1.Kutubxona ishchilarini ko'rish");
        System.out.println("2.Kutubxona foydalanuvchilarini ko'rish");
        System.out.println("3.Kutubxona ishchilarini ishdan bo'shatish");
        System.out.println("0.Chiqish");
    }
}
