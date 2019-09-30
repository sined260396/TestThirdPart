package com.sinelnikov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String secondName;

    private Date birthdayDate;

    private String username;

    private String password;

    private String aboutUser;

    private String address;

}
