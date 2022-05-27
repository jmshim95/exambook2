package com.book.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Data
@AllArgsConstructor
@Alias("BookVO")
public class BookVO {
    private long bookId;
    private String bookName;
    private String publisher;
    private Integer price;
    
    public String toJson() {
    	
    	ObjectMapper mapper = new ObjectMapper();
    	String json = "";
    	
        try {
			json = mapper.writeValueAsString(new BookVO(this.bookId, this.bookName, this.publisher, this.price));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        
        return json;
    }
}
