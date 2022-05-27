package com.book.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookVO {
    private long bookId;
    private String bookName;
    private String publisher;
    private Integer price;
}
