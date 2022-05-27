package com.book.service;

import com.book.mapper.BookMapper;
import com.book.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    public final BookMapper mapper;

    @Override
    public int insertBook(BookVO bookVO) {
        return mapper.insertBook(bookVO);
    }

    @Override
    public int deleteBook(long bookId) {
        return mapper.deleteBook(bookId);
    }

    @Override
    public BookVO selectBook(long bookId) {
        return mapper.selectBook(bookId);
    }

    @Override
    public List<BookVO> selectBookList() {
        return mapper.selectBookList();
    }
}
