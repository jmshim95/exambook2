package com.book.controller;

import com.book.service.BookService;
import com.book.vo.BookVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * list.jsp, register.jsp 는 controller, model
 * 삭제 및 조회는 REST 방식으로 구현 할 것
 * book 테이블은 화면참고
 */
@RequiredArgsConstructor
@Controller
@Log4j
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public String list(Model model){
        List<BookVO> bookList = bookService.selectBookList();
        System.out.println("bookList = " + bookList);
        log.info(bookList);

        model.addAttribute("bookList", bookList);

        return "list";
    }

    @GetMapping("/{bookId}")
    @ResponseBody
    public ResponseEntity<String> book(@PathVariable("bookId") long bookId){

        BookVO bookVO = bookService.selectBook(bookId);
        
        System.out.println("bookVO = " + bookVO);
        
        ObjectMapper mapper = new ObjectMapper();

        if(bookVO == null) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(null);
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookVO.toJson());
        }
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @PostMapping("/book")
    public ResponseEntity<BookVO> registerAction(BookVO bookVO) {
        int i = bookService.insertBook(bookVO);

        if(i < 1) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(null);
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(null);
        }

    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<BookVO> delete(@PathVariable("bookId") long bookId){

        int i = bookService.deleteBook(bookId);

        if(i < 1) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(null);
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(null);
        }
    }

}
