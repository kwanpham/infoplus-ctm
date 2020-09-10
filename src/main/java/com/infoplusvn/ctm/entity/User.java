package com.infoplusvn.ctm.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "ip_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false , unique = true)
    private String username;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "status" , nullable = false)
    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ip_user_role" ,
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roleList = new HashSet<>();




}
