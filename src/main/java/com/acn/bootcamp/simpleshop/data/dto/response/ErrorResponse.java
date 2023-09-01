package com.acn.bootcamp.simpleshop.data.dto.response;

import com.acn.bootcamp.simpleshop.data.enums.ErrorCode;

public record ErrorResponse(ErrorCode code, String message) {
}
