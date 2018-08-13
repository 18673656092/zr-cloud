package com.zr.cloud.cloudserver.service;

import com.zr.cloud.cloudserver.DAO.BookDAO;
import com.zr.cloud.cloudserver.DO.BookDO;
import com.zr.cloud.cloudserver.utils.SHA256;
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
        bookDO.setNo(SHA256.getSHA256String(bookDO.getTitle() + bookDO.getAddress()));
        if(selectBook(bookDO.getNo())==null) {
            return bookDAO.addBook(bookDO);
        }else {
            return false;
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

    public BookDO selectBook(String NO){
        return bookDAO.selectBook(NO);
    }

    public boolean delBook(String NO){
        return bookDAO.delBook(NO);
    }
}
