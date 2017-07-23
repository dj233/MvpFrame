package com.nabt.db.wrapper;

import com.nabt.cartoon.entity.Book;
import com.nabt.db.bean.DBook;
import com.nabt.db.dao.DBookDao;

import java.util.ArrayList;
import java.util.List;

public class BookWrapper {
    DBookDao dao;

    public BookWrapper(DBookDao dao) {
        this.dao = dao;
    }

    public boolean add(Book book){
        DBook dBook = toDb(book);
        DBook oldBook = dao.load(book.getName());
        if(oldBook == null){
            dao.insert(dBook);
            return true;
        }else{
            return false;
        }
    }

    public List<Book> list(){
        List<Book> books = new ArrayList<>();
        List<DBook> dBooks = dao.loadAll();
        for(DBook dBook : dBooks){
            books.add(toNet(dBook));
        }
        return books;
    }

    private DBook toDb(Book book){
        DBook dBook = new DBook();
        dBook.setArea(book.getArea());
        dBook.setCoverImg(book.getCoverImg());
        dBook.setDes(book.getDes());
        dBook.setFinish(book.isFinish());
        dBook.setLastUpdate(book.getLastUpdate());
        dBook.setName(book.getName());
        dBook.setType(book.getType());
        return dBook;
    }

    private Book toNet(DBook dBook){
        Book book = new Book();
        book.setArea(dBook.getArea());
        book.setCoverImg(dBook.getCoverImg());
        book.setDes(dBook.getDes());
        book.setFinish(dBook.getFinish());
        book.setLastUpdate(dBook.getLastUpdate());
        book.setName(dBook.getName());
        book.setType(dBook.getType());
        return book;
    }
}
