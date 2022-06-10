package org.burgeon.aero.as.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author Sam Lu
 * @date 2021/11/23
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "c_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "c_realm_id")
    private Long realmId;

    @Column(name = "c_nickname", nullable = false, length = 30)
    private String nickname;

    @Column(name = "c_avatar", length = 2048)
    private String avatar;

    @Column(name = "c_password", length = 64)
    private String password;

    @Column(name = "c_salt", length = 16)
    private String salt;

    @Column(name = "c_gender")
    private Byte gender;

    @Column(name = "c_birth_year")
    private Short birthYear;

    @Column(name = "c_birth_month")
    private Short birthMonth;

    @Column(name = "c_birth_day")
    private Short birthDay;

    @Column(name = "c_country", length = 30)
    private String country;

    @Column(name = "c_province", length = 30)
    private String province;

    @Column(name = "c_city", length = 30)
    private String city;

    @Column(name = "c_address", length = 120)
    private String address;

    @Column(name = "c_create_time", updatable = false, nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "c_update_time", nullable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
