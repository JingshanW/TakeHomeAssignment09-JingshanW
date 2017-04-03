package com.example.android.takehomeassignment09_jingshanw;

/**
 * Created by Jing on 4/3/17.
 */

public class Book
{
    private String name;
    private int yearOfPublish;
    private boolean inStock;

    public Book(String name, boolean inStock, int yearOfPublish) {
        this.name = name;
        this.inStock = inStock;
        this.yearOfPublish = yearOfPublish;
    }

    public Book(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return name +" "+yearOfPublish+" "+inStock;
    }
}
