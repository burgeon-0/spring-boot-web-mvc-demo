package org.burgeon.aero.as.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author Sam Lu
 * @date 2021/11/26
 */
@Data
@Entity
@Table(name = "t_authorization_code")
public class AuthorizationCode {

    @Id
    @Column(name = "c_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "c_client_id", columnDefinition = "BINARY(16)")
    private UUID clientId;

    @Column(name = "c_user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "c_response_type")
    private String responseType;

    @Column(name = "c_redirect_uri", length = 2048)
    private String redirectUri;

    @Column(name = "c_scope")
    private String scope;

    @Column(name = "c_state")
    private String state;

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
