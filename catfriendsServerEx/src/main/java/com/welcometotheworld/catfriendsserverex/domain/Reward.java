package com.welcometotheworld.catfriendsserverex.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REWARD_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RewardType type;

    @Column
    private Long degree; //보상 정도

//    @Builder
//    public Reward (RewardType type, Long degree){
//        this.type = type;
//        this.degree = degree;
//    }

}
