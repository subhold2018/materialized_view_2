package com.lumendata.model;

import java.util.List;
import lombok.Data;

@Data
public class Customer {
    private PrimaryData primaryData;
    private List<Name> names;
    private List<Email> emails;
    private List<Phone> phones;
    private List<Address> addresses;
    private List<Affiliation> affiliations;
    private List<Identification> identifications;
    private List<Source> source;
    private String guid;
}
