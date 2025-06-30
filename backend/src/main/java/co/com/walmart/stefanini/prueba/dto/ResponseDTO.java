package co.com.walmart.stefanini.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO<T> {

    private boolean status;

    private String msg;

    private T data;
    
}
