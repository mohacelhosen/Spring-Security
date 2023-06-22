package com.mohacel.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String fullName;
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
}
