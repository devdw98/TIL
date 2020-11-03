package com.welcometotheworld.catfriendsserverex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/test")
    public ResponseEntity<?> testUrl(){
        Map<String, String> json = new HashMap<>();
        json.put("success","test");

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
