package com.skyrock.interview.components;

import com.skyrock.interview.dtos.UsersDto;
import com.skyrock.interview.models.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterComponent {

    @Autowired
   private ModelMapper modelMapper;

    public Users convertToUsersDto(UsersDto usersDto){
        return modelMapper.map(usersDto, Users.class);
    }

}
