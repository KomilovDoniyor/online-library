/**
 * Author : Komilov Doniyor
 * Date : 12/22/2023
 * Project Name : online-library
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private Integer page;

    private boolean available;

    //Kim tomonida bron qilingani
    private User borrowedBy; //

    //Bron qilingan vaqti
    private LocalDate borrowedAt;

    private boolean borrowedSuccess;

    //Kitobni qaytarish vaqti
    private LocalDate returnAt;

    private LocalDate returnableAt;

    private boolean returnSuccess;

    private LocalDate takeAt;

    private boolean takeSuccess;

    public Book(Integer id, String name, String author, Integer page, boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.page = page;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public boolean isBorrowedSuccess() {
        return borrowedSuccess;
    }

    public void setBorrowedSuccess(boolean borrowedSuccess) {
        this.borrowedSuccess = borrowedSuccess;
    }

    public LocalDate getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDate borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public LocalDate getReturnAt() {
        return returnAt;
    }

    public void setReturnAt(LocalDate returnAt) {
        this.returnAt = returnAt;
    }

    public LocalDate getReturnableAt() {
        return returnableAt;
    }

    public void setReturnableAt(LocalDate returnableAt) {
        this.returnableAt = returnableAt;
    }

    public boolean isReturnSuccess() {
        return returnSuccess;
    }

    public void setReturnSuccess(boolean returnSuccess) {
        this.returnSuccess = returnSuccess;
    }

    public LocalDate getTakeAt() {
        return takeAt;
    }

    public void setTakeAt(LocalDate takeAt) {
        this.takeAt = takeAt;
    }

    public boolean isTakeSuccess() {
        return takeSuccess;
    }

    public void setTakeSuccess(boolean takeSuccess) {
        this.takeSuccess = takeSuccess;
    }

    public String toString0() {
        return String.format("%1$-5s", id)
                + String.format("%1$-15s", name)
                + String.format("%1$-10s", author)
                + String.format("%1$-15s", page)
                + String.format("%1$-5s", available);
    }

    public String toString1() {
        return String.format("%1$-5s", id)
                + String.format("%1$-15s", name)
                + String.format("%1$-10s", author)
                + String.format("%1$-5s", page)
                + String.format("%1$-5s", available)
                + String.format("%1$-15s", borrowedBy.getEmail())
                + String.format("%1$-15s", borrowedAt);
    }

    public String toString2() {
        return String.format("%1$-5s", id)
                + String.format("%1$-15s", name)
                + String.format("%1$-10s", author)
                + String.format("%1$-5s", page)
                + String.format("%1$-5s", available)
                + String.format("%1$-15s", borrowedBy.getEmail())
                + String.format("%1$-15s", borrowedAt)
                + String.format("%1$-20s", returnAt)
                + String.format("%1$-20s", returnableAt)
                + String.format("%1$-20s", returnSuccess);
    }


}
