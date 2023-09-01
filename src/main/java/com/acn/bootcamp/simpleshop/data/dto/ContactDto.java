package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.enums.ContactType;

public record ContactDto(ContactType type, String info, Boolean primary) {
}
