package com.zr.cloud.cloudclient.service;

import com.zr.cloud.cloudclient.vo.BookVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient("book-server")
public interface BookService {

    @PostMapping("/addBook")
    String addBookClent(@RequestBody BookVO bookVO);
}
