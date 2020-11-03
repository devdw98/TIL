package com.welcometotheworld.catfriendsserverex.domain;

public enum RewardType {
    NOTICE, DIA, MONEY, HEART, ETC;

    static RewardType toType(int type){
        RewardType result;
        switch (type){
            case 0:
                result = NOTICE;
                break;
            case 1:
                result = DIA;
                break;
            case 2:
                result = MONEY;
                break;
            case 3:
                result = HEART;
                break;
            default:
                result = ETC;
                break;
        }
        return result;
    }
}
