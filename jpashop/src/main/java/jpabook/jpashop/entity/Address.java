package jpabook.jpashop.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Address {

  private String city;
  private String street;
  private String zipcode;
}
