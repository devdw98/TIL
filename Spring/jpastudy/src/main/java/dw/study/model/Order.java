package dw.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Setter
@Getter
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member; //주문 회원

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVARY_ID")
    private Delivary delivary; //배송정보

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문 상태

    public void setMember(Member member) {
        if(this.member != null){
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem item){
        orders.add(item);
        item.setOrder(this);
    }

    public void setDelivary(Delivary delivary){
        this.delivary = delivary;
        delivary.setOrder(this);
    }

    /* 생성 메소드 */
    public static Order createOrder(Member member, Delivary delivary, List<OrderItem> orderItems){
        Order order = new Order();
        order.setMember(member);
        order.setDelivary(delivary);
        for(OrderItem item : orderItems){
            order.addOrderItem(item);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(new Date());
        return order;
    }

    /* 비즈니스 로직 */
    //주문 취소
    public void cancel(){
        if(delivary.getStatus() == DelivaryStatus.COMP)
            throw new RuntimeException("이미 배송완료된 상품은 취소가 불가능합니다.");
        this.setStatus(OrderStatus.CANCEL);
        for(OrderItem item : this.orders){
            item.cancel();
        }
    }
    //전체 주문 가격 조회
    public int getTotalPrice(){
        int totalPrice = 0;
        for(OrderItem item:orders){
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
