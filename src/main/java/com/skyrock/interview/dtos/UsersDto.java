package com.skyrock.interview.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsersDto implements Serializable {

    private Long id;

    private String title;

    private String firstName;

    private String surname;

    private String dob;

    private String jobTitle;

    private Date createdAt;
}
