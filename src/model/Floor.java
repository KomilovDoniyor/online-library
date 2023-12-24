/**
 * Author : Komilov Doniyor
 * Date : 12/24/2023
 * Project Name : online-library
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private Byte id; // Xotiradan unumli foydalanish uchun byte typeda qo'ydim.Mantiqan o'ylab qaralsa 128 qavatli kutubxona bo'lmasa kerak

    private List<Shelf> shelves = new ArrayList<>();

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }
}
