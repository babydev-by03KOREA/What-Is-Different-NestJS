package com.boot.oop.entity;

import com.boot.oop.role.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @NotEmpty
    private String userId;

    @Column
    @NotEmpty
    private String userPassword;

    @Column
    @NotEmpty
    private String userName;

    @Column
    @NotEmpty
    private String userNickName;

    @Column
    @NotEmpty
    private String userEmail;

    /**
     * @Enumerated(EnumType.STRING || ORDINAL)
     * @STRING ENUM Field가 Table 저장 시 숫자형인 1,2,3이 아닌 Enum의 Role이 DB에 저장된다.
     * @ORDINAL default option, 숫자형인 1,2,3으로 DB에 저장된다.
     * */
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    /**
     * @return 두 객체의 내용이 같은지 판단한다.
     * <pre>
     * equals는 <code>Object</code> Class에서 기본 구현이 제공되지만,<br/>
     * 일반적으로 @Override 받아 사용한다.<br/>
     * [equals, hashCode 공통 주의점]<br/>
     * 1. PrimaryKey 기준으로 동일성을 비교하여야 한다. <br/>
     * 2. <code>Hibernate.getClass(this)</code>를 사용하여 <br/>
     * 프록시 객체(대상 객체를 대신하는 객체)와 실제 객체를 비교를 처리해,<br/>
     * 동일성이 올바르게 판별된다.
     * </pre>
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }
    /**
     * @return hashCode() & 객체의 동일성 비교 <br/>
     * <code>hashCode()</code>는 객체의 해시코드를 계산한다.
     * */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
