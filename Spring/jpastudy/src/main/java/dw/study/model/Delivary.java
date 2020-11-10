package dw.study.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name = "DELIVARY")
@Setter
@Getter
public class Delivary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVARY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivary")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DelivaryStatus status;
}

