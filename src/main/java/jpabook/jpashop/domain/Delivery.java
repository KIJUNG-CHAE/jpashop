package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL으로 쓰면 나중에 enum이 추가될 경우 문제가 생긴다. 숫자로 저장하기 때문.
    private DeliveryStatus status; //READY, COMP

}
