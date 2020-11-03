package com.welcometotheworld.catfriendsserverex.dto;

import com.welcometotheworld.catfriendsserverex.domain.RewardType;
import lombok.Data;

@Data
public class RewardDto {

    private int type;
    private Long degree;

    public RewardType toType(int type){
        return toType(type);
    }
}
