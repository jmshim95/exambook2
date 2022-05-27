package com.book.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@Alias("BookVO")
public class BookVO {
    private long bookId;
    private String bookName;
    private String publisher;
    private Integer price;
}
