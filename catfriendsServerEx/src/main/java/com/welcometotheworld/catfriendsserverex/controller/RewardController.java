package com.welcometotheworld.catfriendsserverex.controller;

import com.welcometotheworld.catfriendsserverex.domain.Reward;
import com.welcometotheworld.catfriendsserverex.dto.RewardDto;
import com.welcometotheworld.catfriendsserverex.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reward")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RewardDto req){
        return new ResponseEntity<>(rewardService.save(req), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(rewardService.getList(), HttpStatus.OK);
    }

}
