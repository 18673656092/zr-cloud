package com.zr.cloud.cloudclient.controller;

import com.zr.cloud.cloudclient.service.BookService;
import com.zr.cloud.cloudclient.vo.BookVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class BookClientController {
    @Resource
    private BookService bookService;

    @PostMapping("/addBook")
    @ResponseBody
    public String addBook(@RequestBody BookVO bookVO) {
        return bookService.addBookClent(bookVO);
    }
}
