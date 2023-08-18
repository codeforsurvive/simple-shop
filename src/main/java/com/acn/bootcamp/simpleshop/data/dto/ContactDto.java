package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.enums.ContactType;
import lombok.Data;

@Data
public class ContactDto {
    public ContactDto(ContactType type, String info, Boolean primary) {
        this.type = type;
        this.info = info;
        this.primary = primary;
    }

    private ContactType type;
    private String info;
    private Boolean primary;
}
