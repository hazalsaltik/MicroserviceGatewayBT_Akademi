package com.bt_akademi.user_management.model.entity;


import lombok.Data;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@SequenceGenerator(name = "USERS_SEQUENCE", sequenceName = "BT_AKADEMI_USERS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Entity
@Table(name= "USERS")
public class User
{
    @GeneratedValue(strategy = SEQUENCE , generator ="USERS_SEQUENCE")
    @Column(name = "USER_ID", nullable = false)
    @Id
    private Integer userID;

    @Column(nullable = false)
    private String  username;

    @Column(nullable = false)
    private String password;

    private Date created;
}
