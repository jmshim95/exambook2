package com.book.controller;

import com.book.service.BookService;
import com.book.vo.BookVO;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("")
@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public String list(Model model){
        List<BookVO> bookList = bookService.selectBookList();

        model.addAttribute("bookList", bookList);

        return "list";
    }

    @GetMapping("/book/{bookId}")
    @ResponseBody
    public ResponseEntity<BookVO> book(@PathVariable("bookId") long bookId){

        BookVO bookVO = bookService.selectBook(bookId);

        if(bookVO == null) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(null);
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookVO);
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

    @DeleteMapping("/book/{bookId}")
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
