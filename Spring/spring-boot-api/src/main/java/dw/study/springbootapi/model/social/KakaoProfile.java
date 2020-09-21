package dw.study.springbootapi.model.social;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoProfile {
    private String nickname;
    private String thumbnail_img;
    private String profile_img;
}
