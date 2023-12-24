/**
 * Author : Komilov Doniyor
 * Date : 12/22/2023
 * Project Name : online-library
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private Integer floorId;

    private Integer shelfId; // Javon
    private List<Book> books;

    private List<User> users = new ArrayList<>();

    private LocalDateTime createdAt; // Qo'shilgan vaqti

    public Library(Integer floorId, Integer shelfId, List<Book> books, LocalDateTime createdAt) {
        this.floorId = floorId;
        this.shelfId = shelfId;
        this.books = books;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getShelfId() {
        return shelfId;
    }

    public void setShelfId(Integer shelfId) {
        this.shelfId = shelfId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
