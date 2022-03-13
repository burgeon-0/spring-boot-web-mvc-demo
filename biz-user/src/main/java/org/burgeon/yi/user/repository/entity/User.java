package org.burgeon.yi.user.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id", columnDefinition = "bigint(32) unsigned NOT NULL COMMENT '用户ID'")
    private Long id;

    @Column(name = "c_mobile", columnDefinition = "varchar(20) NULL COMMENT '用户手机'")
    private String mobile;

    @Column(name = "c_email", columnDefinition = "varchar(50) NULL COMMENT '用户邮箱'")
    private String email;

    @Column(name = "c_nickname", columnDefinition = "varchar(30) NULL COMMENT '用户昵称'")
    private String nickname;

}
