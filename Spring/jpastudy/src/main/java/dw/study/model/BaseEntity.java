package dw.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    private Date createDate;
    private Date lastModifiedDate;
}
