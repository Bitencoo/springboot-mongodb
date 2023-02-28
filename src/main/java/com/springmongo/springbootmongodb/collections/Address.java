package com.springmongo.springbootmongodb.collections;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class Address {
    private String street;
    private String cityState;
    private String city;
}
