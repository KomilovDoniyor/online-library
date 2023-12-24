/**
 * Author : Komilov Doniyor
 * Date : 12/23/2023
 * Project Name : online-library
 */
package service.impl;

import model.Book;
import realization.Main;
import service.BookService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    public static Scanner scanner;

    @Override
    public void bronBook() {
        boolean issuccess = true;
        while (issuccess) {
            scanner = new Scanner(System.in);
            System.out.print("Bron qilimoqchi bo'lgan kitob nomini kiriting: (Xamsa): ");
            String bronBook = scanner.nextLine();
            List<Book> books = Main.library.getBooks();
            for (Book book : books) {
                if (!book.isAvailable()) {
                    System.out.println("Bunday kitob qolmagan");
                }
                if (Objects.equals(book.getName(), bronBook)) {
                    book.setBorrowedBy(Main.currentUser);
                    book.setBorrowedAt(LocalDate.now());
                    book.setBorrowedSuccess(true);
                    book.setReturnAt(book.getBorrowedAt().plusDays(7));
                    System.out.println(book.getName() + " kitobi bron qilindi.");
                    System.out.println("Kitob bron qilinganidan keyin 3 kun ichida olib ketishingiz kerak." +
                            "Aks holda bron qilinga kitobingiz atkaz qilinadi");
                    break;
                }
            }
            while (true) {
                System.out.println("Yana kitob bron qilmoqchimisz? (yes/no)");
                String alsoBronBook = scanner.nextLine();
                if (alsoBronBook.equals("yes")) {
                    break;
                } else if (alsoBronBook.equals("no")) {
                    issuccess = false;
                    break;
                } else {
                    System.out.println("Bunday soz kiritilishi mumkin emas!!!");
                }
            }
        }
    }

    @Override
    public void returnBook() {
        boolean isSuccess = true;
        while (isSuccess) {
            List<Book> books = Main.library.getBooks();
            scanner = new Scanner(System.in);
            System.out.println("Barcha kitoblarni kutubxonaga topshirmoqchimisz? (yes/no)");
            String next = scanner.next();
            if (next.equals("yes")) {
                for (Book book : books) {
                    if (book.getBorrowedBy().getEmail().equals(Main.currentUser.getEmail()) && book.isTakeSuccess()) {
                        book.setReturnableAt(LocalDate.now());
                        book.setReturnSuccess(true);
                        isSuccess = false;
                    }
                }
            } else {
                //TODO Kerakli kitoblar alohida alohida olib ketiladigan implementatisya yozilmagan
                System.out.println("Iltimos hamma kitoblarni qaytarishingizni soraymiz. Kitoblar birma bir qaytaradigan implementatsiyasi yozilmagan!!!");
            }
        }
    }

    @Override
    public void
    takeTheBook() {
        List<Book> books = Main.library.getBooks();
        boolean isSuccess = true;
        while (isSuccess) {
            for (Book book : books) {
                scanner = new Scanner(System.in);
                if (book.getBorrowedBy() != null) {
                    if (book.getBorrowedBy().getEmail().equals(Main.currentUser.getEmail()) && book.isBorrowedSuccess()) {
                        System.out.println("Siz bron qilingan barcha kitoblarni olib ketasizmi?(yes/no)");
                        String next = scanner.next();
                        if (next.equals("yes")) {
                            System.out.println("Hamma kitoblar olindi.");
                            book.setTakeAt(LocalDate.now());
                            book.setTakeSuccess(true);
                            isSuccess = false;
                            break;
                        } else {
                            //TODO Kerakli kitoblar olib ketiladigan implementatisya yozilmagan
                            System.out.println("Iltimos hamma kitoblarni olib ketishingizni soraymiz. Kerakli kitoblar olib ketiladigan implementatsiyasi yozilmagan!!!");
                        }
                    }
                }else {
                    System.out.println("Siz kitob bron qilmagansiz iltimos kutubxonadan kitob bron qiling!!!");
                    isSuccess = false;
                }
            }

        }
    }
}
