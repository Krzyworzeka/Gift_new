package com.example.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToEntity(UserDto dto);

    UserDto mapToDto(User entity);

    List<UserDto> mapToDto(List<User> entities);
}
