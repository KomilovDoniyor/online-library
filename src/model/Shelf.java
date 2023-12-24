/**
 * Author : Komilov Doniyor
 * Date : 12/24/2023
 * Project Name : online-library
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private Integer id;

    private Integer polka;

    private List<Book> books;

    public Shelf(Integer id, Integer polka, List<Book> books) {
        this.id = id;
        this.polka = polka;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPolka() {
        return polka;
    }

    public void setPolka(Integer polka) {
        this.polka = polka;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
