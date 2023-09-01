package com.acn.bootcamp.simpleshop.controllers;

import com.acn.bootcamp.simpleshop.Constants;
import com.acn.bootcamp.simpleshop.data.dto.UserDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping( path = Constants.USER_ENDPOINT, produces = "application/json")
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity getInfo(@AuthenticationPrincipal UserDetail user) {
        return ResponseEntity.ok(user);
    }
}
