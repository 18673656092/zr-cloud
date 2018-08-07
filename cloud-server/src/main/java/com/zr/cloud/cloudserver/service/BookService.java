package com.zr.cloud.cloudserver.service;

import com.zr.cloud.cloudserver.DAO.BookDAO;
import com.zr.cloud.cloudserver.DO.BookDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhuran on 2018/8/6 0006
 */
@Service
public class BookService {

    @Resource
    private BookDAO bookDAO;

    public synchronized boolean addBook(BookDO bookDO) {
        if(selectBook(bookDO.getNO())==null) {
            return bookDAO.addBook(bookDO);
        }else {
            bookDO.setNumber(selectBook(bookDO.getNO()).getNumber() + bookDO.getNumber());
            return updateBookNumber(bookDO);
        }
    }

    public synchronized boolean updateBook(BookDO bookDO){
        return bookDAO.updateBook(bookDO);
    }

    public synchronized boolean updateBookNumber(BookDO bookDO){
        return bookDAO.updateBookNumber(bookDO);
    }

    public List<BookDO> selectBookTotal(){
        return bookDAO.selectBookTotal();
    }

    public BookDO selectBook(Integer NO){
        return bookDAO.selectBook(NO);
    }

    public boolean delBook(Integer NO){
        return bookDAO.delBook(NO);
    }
}
