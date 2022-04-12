package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable // jpa의 내장 타입
@Getter @Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
