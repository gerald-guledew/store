package com.gguledew.store.mappers;

import com.gguledew.store.dtos.RegisterUserRequest;
import com.gguledew.store.dtos.UpdateUserRequest;
import com.gguledew.store.dtos.UserDto;
import com.gguledew.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest registerUserRequest);
    void updateUser(UpdateUserRequest updateUser, @MappingTarget User user);
}
