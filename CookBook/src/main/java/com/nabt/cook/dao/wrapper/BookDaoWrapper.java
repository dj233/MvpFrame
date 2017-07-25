package com.nabt.cook.dao.wrapper;

import com.nabt.cook.dao.db.BookDao;
import com.nabt.cook.dao.entity.Book;

import java.util.List;

/**
 * Created by 14K on 2017/7/25.
 */

public class BookDaoWrapper {
    private BookDao bookDao;

    public BookDaoWrapper(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public boolean add(Book book){
        Book dbook = bookDao.load(book.getId());
        if(dbook == null){
            bookDao.insert(book);
            return true;
        }else {
            return false;
        }
    }

    public List<Book> list(){
        return bookDao.loadAll();
    }
}
