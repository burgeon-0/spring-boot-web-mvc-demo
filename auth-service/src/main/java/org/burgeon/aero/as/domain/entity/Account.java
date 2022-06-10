package org.burgeon.aero.as.domain.entity;

import lombok.Data;
import org.burgeon.aero.as.domain.enums.AccountType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author Sam Lu
 * @date 2021/11/29
 */
@Data
@Entity
@Table(name = "t_account")
public class Account {

    @Id
    @Column(name = "c_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "c_realm_id")
    private Long realmId;

    @Column(name = "c_type")
    private AccountType type;

    @Column(name = "c_username", length = 64)
    private String username;

    @Column(name = "c_user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "c_create_time", updatable = false, nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "c_update_time", nullable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
