package com.chirchir.rm.api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private int total;
    private List<T> results;
}
