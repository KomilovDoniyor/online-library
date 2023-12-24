/**
 * Author : Komilov Doniyor
 * Date : 12/24/2023
 * Project Name : online-library
 */
package service.impl;

import model.Book;
import model.Library;
import model.User;
import realization.Main;
import service.LibraryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryService {
    public static Scanner scanner;

    @Override
    public void addBook() {
        boolean isFail = true;
        while (isFail) {
            scanner = new Scanner(System.in);
            System.out.print("Kitob nomi: ");
            String bookName = scanner.nextLine();

            System.out.print("Kitob authori: ");
            String author = scanner.nextLine();

            System.out.print("Kitob sahifasi(Bet):");
            int page = scanner.nextInt();

            int floor;
            while (true) {
                System.out.print("Nechinchi qavatga qoshmoqchiligizni ko'rsating: ");
                floor = scanner.nextInt();
                if (floor > 0 && floor <= 4) {
                    break;
                } else {
                    System.out.println("Kutubxonamiz faqat 4 qavatli!!! Qaytadan kiriting!");
                }
            }

            int shelf;
            while (true) {
                System.out.print("Nechinchi javonga joylamoqchiligizni ko'rsating!");
                shelf = scanner.nextInt();
                if (shelf > 0 && shelf <= 80) {
                    break;
                } else {
                    System.out.println("Bunday raqamli javonimiz yo'q qaytadan urinib koring: (Javonlar soni(80)): ");
                }
            }

            int bookId = Main.books.size();
            Book book = new Book(
                    bookId + 1,
                    bookName,
                    author,
                    page,
                    true
            );
            List<Book> books = new ArrayList<>();
            books.add(book);
            Main.library = new Library(
                    floor,
                    shelf,
                    books,
                    LocalDateTime.now()
            );
            System.out.println("Kitob muvaffaqiyatli saqlandi!!!");
            boolean isSuccess = true;
            while (isSuccess) {
                scanner = new Scanner(System.in);
                System.out.println("Yana kitob qo'shmoqchimisz? (yes/no): ");
                String choice = scanner.nextLine();
                if (choice.equals("yes")) {
                    isSuccess = false;
                } else {
                    isSuccess = false;
                    isFail = false;
                }
            }
        }
    }

    @Override
    public void searchBook() {
        boolean isSuccess = true;
        while (isSuccess) {
            scanner = new Scanner(System.in);
            System.out.print("Qidirmoqchi bo'lgan kitob nomini kiriting: ");
            String searchBookName = scanner.nextLine();
            List<Book> books = Main.library.getBooks();
            for (Book book : books) {
                if (searchBookName.equals(book.getName())) {
                    System.out.println(book.toString0());
                } else {
                    return;
                }
            }
            System.out.println("Yana kitob qidirmoqchimisz?(yes/no)");
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                break;
            } else {
                isSuccess = false;
            }
        }
    }

    @Override
    public void viewBronBook() {
        List<Book> books = Main.library.getBooks();
        for (Book book : books) {
            if (book.getBorrowedBy() != null) {
                System.out.println(book.toString1());
            } else {
                System.out.println("Bron qilingan kitob topilmadi!!!");
            }
        }

    }

    /**
     * Olingan kitoblar ro'yhati uchun
     */

    @Override
    public void takenBook() {
        List<Book> books = Main.library.getBooks();
        boolean isSuccess = true;
        while (isSuccess) {
            for (Book book : books) {
                if (book.isTakeSuccess()) {
                    System.out.println(book.toString0());
                }
            }
            isSuccess = false;
        }
    }

    /**
     * Olingan lekin qaytarilmagan kitoblar ro'yhati
     */
    @Override
    public void broughtBook() {
        List<Book> books = Main.library.getBooks();
        boolean isSuccess = true;
        while (isSuccess) {
            for (Book book : books) {
                if (book.isReturnSuccess()) {
                    System.out.println(book.toString2());
                }
            }
           isSuccess = false;
        }
    }
}
