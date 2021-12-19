package dw.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;

}
