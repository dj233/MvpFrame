package com.nabt.cartoon.entity;

import java.util.List;

public class BookListResult {

    /**
     * total : 4226
     * limit : 20
     * bookList : []
     */

    private int total;
    private int limit;
    private List<Book> bookList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
