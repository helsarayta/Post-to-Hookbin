package com.heydie.userapi.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDto<T> {
    private Boolean success;
    private List<String> message = new ArrayList<>();
}
