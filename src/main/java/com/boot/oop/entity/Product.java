package com.boot.oop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Entity  JPA Entity Class Mapping
 * @RequiredArgsConstructor  초기화 되지 않은 final Field Or @NonNull 사용 Field 없기때문에 이번에는 사용 X
 * @NoArgsConstructor Parameter 받지 않는 Default Constructor <br/> 왜 필요할지 의구심이 들지만, JPA는 기본생성자를 사용하여 Entity 객체를<br/>
 * 인스턴스화 하기 때문에, @Entity == @NoArgsConstructor 꼭 필요하다!
 * @AllArgsConstructor All Fields Parameter들을 받는 Constructor
 * */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    /**
     * @implNote 기본 키 생성 전략은 DB, 성능 요구, 팀 성향에 따라 달라진다.<br/> 전략을 명시하지 않으면, JPA 구현체가 기본전략인 @GenerationType.Auto를 사용하여 구현한다.
     * @Id == PrimaryKey
     * @GeneratedValue JPA에서 Primary Key 생성 전략을 정의하는데 사용
     * @GenerationType.AUTO JPA에게 모든걸 위임한다.
     * @GenerationType.IDENTITY DB 자동증가 기능을 사용하여 기본키를 생성. 대표적으로 MySQL, PostgresQL 등
     * @GenerationType.SEQUENCE DB 시퀀스 기능을 사용하여 기본키를 생성. 대표적으로 Oracle, PostgresQL 등에서 사용되는 전통적인 방법이다.<br/>
     * @SequenceGenerator @SequenceGenerator과 함께 사용하여 시퀀스를 더 새밀하게 제어가 가능하다.
     * @GenerationType.TABLE 별도의 DB TABLE 사용하여 기본 키 값을 생성한다.<br/> 모든 DB에서 동작 but, 성능 Issue가 있으므로 다른 방법을 더 선호한다.
     * @TableGeneration 을 함께 사용하여, Table을 더 세밀하게 제어가 가능해진다.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(length = 50)
    @NotEmpty
    private String itemName;

    @Column(length = 30)
    @NotEmpty
    private Integer price;

    @Column
    @NotEmpty
    private String itemDetail;

    @Column(updatable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void time() {
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return getProductID() != null && Objects.equals(getProductID(), product.getProductID());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
