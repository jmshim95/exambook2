package com.book.service;

import com.book.vo.BookVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    int insertBook(BookVO bookVO);
    int deleteBook(long bookId);
    BookVO selectBook(long bookId);
    List<BookVO> selectBookList();
}
