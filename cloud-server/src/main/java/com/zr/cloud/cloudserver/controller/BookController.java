package com.zr.cloud.cloudserver.controller;

import com.alibaba.fastjson.JSON;
import com.zr.cloud.cloudserver.DO.BookDO;
import com.zr.cloud.cloudserver.service.BookService;
import com.zr.cloud.cloudserver.utils.RedisClient;
import com.zr.cloud.cloudserver.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhuran on 2018/8/6 0006
 */
@Controller
public class BookController {

    @Resource
    private BookService bookService;
    @Resource
    private RedisClient redisClient;

    @PostMapping("/addBook")
    @ResponseBody
    public String addBook(@RequestBody BookDO bookDO) {
        if (bookService.addBook(bookDO)) {
            return Result.make(0, bookDO, "add book success");
        } else {
            return Result.make(-1, bookDO, "add book error");
        }
    }

    @PostMapping("/updateBook")
    @ResponseBody
    public String updateBook(@RequestBody BookDO bookDO) {
        if (bookService.updateBook(bookDO)) {
            return Result.make(0, bookDO, "update book success");
        } else {
            return Result.make(-1, bookDO, "update book error");
        }
    }

    @GetMapping("/selectBook")
    @ResponseBody
    public String selectBookTotal() {
        List<BookDO> books = bookService.selectBookTotal();
        if (books != null) {
            return Result.make(0, JSON.toJSONBytes(books), "select success");
        } else {
            return Result.make(-1, null, "select null");
        }
    }

    @PostMapping("/selectBookForNumber")
    @ResponseBody
    public String selectBook(@RequestBody BookDO bookDO) {
        BookDO book = bookService.selectBook(bookDO.getNo());
        if (book != null) {
            return Result.make(0, book, "select success");
        } else {
            return Result.make(-1, null, "select null");
        }
    }

    @PostMapping("/deleteBook")
    @ResponseBody
    public String delBook(@RequestBody BookDO bookDO) {
        if (bookService.delBook(bookDO.getNo())) {
            return Result.make(0, bookDO, "select success");
        } else {
            return Result.make(-1, null, "select null");
        }
    }
}
