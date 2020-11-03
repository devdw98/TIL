package com.welcometotheworld.catfriendsserverex.service.impl;

import com.welcometotheworld.catfriendsserverex.domain.Reward;
import com.welcometotheworld.catfriendsserverex.dto.RewardDto;
import com.welcometotheworld.catfriendsserverex.repository.RewardRepository;
import com.welcometotheworld.catfriendsserverex.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService {

    private final RewardRepository rewardRepository;

    @Override
    public boolean save(RewardDto req) {
//        Reward entity = modelMapper.map(req, Reward.class);
        Reward entity = Reward.builder().type(req.toType(req.getType())).degree(req.getDegree()).build();

        if(rewardRepository.save(entity)!= null)
            return true;
        else
            return false;
    }

    @Override
    public RewardDto get(Long id) {
//        RewardDto dto = modelMapper.map(rewardRepository.getOne(id), RewardDto.class);
        RewardDto dto =
        return dto;
    }

    @Override
    public List<RewardDto> getList() {
        List<RewardDto> list = new ArrayList<>();
        for(Reward r:rewardRepository.findAll()){
//            RewardDto dto = modelMapper.map(r, RewardDto.class);
            list.add(dto);
        }
        return list;
    }
}
