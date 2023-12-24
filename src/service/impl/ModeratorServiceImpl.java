/**
 * Author : Komilov Doniyor
 * Date : 12/24/2023
 * Project Name : online-library
 */
package service.impl;

import realization.Main;
import service.LibraryService;
import service.ModeratorService;

import java.util.Scanner;

public class ModeratorServiceImpl implements ModeratorService {
    public static Scanner scanner;
    static LibraryService libraryService;

    @Override
    public void showModeratorMenu() {
        boolean isSuccess = true;
        while (isSuccess) {
            scanner = new Scanner(System.in);
            libraryService = new LibraryServiceImpl();
            moderatorMenu();
            System.out.print("Select the option: = > ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> libraryService.addBook();
                case 2 -> libraryService.searchBook();
                case 3 -> libraryService.viewBronBook();
                case 4 -> libraryService.takenBook();
                case 5 -> libraryService.broughtBook();
                case 0 -> {
                    boolean exit = Main.exit();
                    if (exit) {
                        isSuccess = false;
                    }
                }
                default -> System.out.println("Bunday operatsiya yo'q");
            }
        }
    }

    private void moderatorMenu() {
        System.out.println("1. Kitob qo'shish");
        System.out.println("2. Kitob qidirish");
        System.out.println("3. Bron qilingan kitoblarni ko'rish");
        System.out.println("4. Olib ketilgan kitoblarni ko'rish");
        System.out.println("5. Olib kelingan kitoblarni ko'rish");
        System.out.println("0. Chiqish");
    }
}
