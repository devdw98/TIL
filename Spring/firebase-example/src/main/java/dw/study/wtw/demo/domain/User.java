package dw.study.wtw.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable = false, length = 10)
    private String name;

//    @Column
//    @Enumerated(EnumType.STRING)
//    private Type type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessTime;
}