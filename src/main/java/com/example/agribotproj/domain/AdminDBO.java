package com.example.agribotproj.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "admin")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class AdminDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long adminID;
    @Column(name = "username" , nullable = false, unique = true)
    private String username;
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "admin_name")
    private String AdminName;
}
