package com.welcometotheworld.catfriendsserverex.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter //추후에 리펙토링하기
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAIL_ID")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Transient
    private int rewardCount;

    @Column(name = "is_read", nullable = false)
    private boolean isRead;

    @Column(name = "is_reward", nullable = false)
    private boolean isReward;

    @Column(name = "received_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedTime;
//    private String receivedTime;

    @Column(name = "read_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readTime;

    //user 연관관계 추후에 추가

    @Builder
    public Mail(String title, String content, List<Reward> rewards, Date receivedTime){
        this.title = title;
        this.content = content;
//        this.rewards = rewards;
        this.isRead = false;
        this.isReward = false;
        this.receivedTime = receivedTime;
        this.rewardCount = rewards.size();
    }
}
