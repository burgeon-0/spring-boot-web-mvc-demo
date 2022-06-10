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
@Table(name = "t_client")
public class Client {

    @Id
    @Column(name = "c_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "c_secret", nullable = false, length = 16)
    private String secret;

    @Column(name = "c_name", nullable = false, length = 30)
    private String name;

    @Column(name = "c_create_time", updatable = false, nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "c_update_time", nullable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
