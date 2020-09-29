package com.lumendata.model;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private List<Source> source;
    private String guid;
    private List<Email> emails;
}
