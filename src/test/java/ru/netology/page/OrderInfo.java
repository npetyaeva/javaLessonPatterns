package ru.netology.page;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfo {
    private final String city;
    private final String name;
    private final String phone;
}
