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
@Table(name = "t_refresh_token")
public class RefreshToken {

    @Id
    @Column(name = "c_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "c_access_token")
    private String accessToken;

    @Column(name = "c_token_type")
    private String tokenType;

    @Column(name = "c_expires_in")
    private Integer expiresIn;

    @Column(name = "c_expiration_time")
    private Long expirationTime;

    @Column(name = "c_create_time", updatable = false, nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "c_update_time", nullable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
