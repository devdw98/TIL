package dw.study.wtw.demo.controller;

import com.google.firebase.auth.FirebaseAuthException;
import dw.study.wtw.demo.service.FirebaseAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FirebaseAuthController {
    private final FirebaseAuthService authService;

    @GetMapping("/create")
    public ResponseEntity<?> createUser() throws FirebaseAuthException {
        Map<String, Boolean> json = new HashMap<>();
        json.put("success",authService.create());
        if(json.get("success"))
            return new ResponseEntity<>(json, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteUser () throws FirebaseAuthException {
        Map<String, Boolean> json = new HashMap<>();
        json.put("success",authService.delete());
        if(json.get("success"))
            return new ResponseEntity<>(json, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }
}
