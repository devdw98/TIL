package com.welcometotheworld.catfriendsserverex.service;

import com.welcometotheworld.catfriendsserverex.domain.Reward;
import com.welcometotheworld.catfriendsserverex.dto.RewardDto;

import java.util.List;

public interface RewardService {
    public boolean save(RewardDto req);
    public RewardDto get(Long id);
    public List<RewardDto> getList();

}
