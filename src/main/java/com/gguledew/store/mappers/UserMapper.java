package com.gguledew.store.mappers;

import com.gguledew.store.dtos.RegisterUserRequest;
import com.gguledew.store.dtos.UserDto;
import com.gguledew.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest registerUserRequest);
}
