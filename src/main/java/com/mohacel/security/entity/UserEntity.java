package com.mohacel.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private LocalDate dob;
    private String gender;
    private Double height;
    private Double weight;
    private String userContactNumber;
    private String userNationality;
    private String academicInterests;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_ID")
    private AddressEntity userAddress;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roles;
}
