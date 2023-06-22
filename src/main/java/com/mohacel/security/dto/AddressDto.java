package com.mohacel.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String streetAddress;
    private String city;
    private String State;
    private String postalCode;
    private String country;
}
