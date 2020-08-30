package dw.study.jpastudy.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToOne
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member) {
        if(this.member != null) //기존 관계 제거
            this.member.getOrders().remove(this);
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem item){
        orderItems.add(item);
        item.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}
