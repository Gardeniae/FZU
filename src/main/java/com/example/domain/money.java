package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class money {
    private Integer id;
    private String description;
    private Integer current;
    private Integer target;
}
