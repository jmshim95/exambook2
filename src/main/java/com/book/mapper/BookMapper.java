package com.book.mapper;

import com.book.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int insertBook(BookVO bookVO);
    int deleteBook(long bookId);
    BookVO selectBook(long bookId);
    List<BookVO> selectBookList();

}
