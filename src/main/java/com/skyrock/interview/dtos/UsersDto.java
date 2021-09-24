package com.skyrock.interview.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UsersDto implements Serializable {

    private Long id;

    private String title;

    private String firstName;

    private String surname;

    private String dob;

    private String jobTitle;

    private Date createdAt;
}
