package com.example.demo.mapper;

import com.example.demo.dto.request.UserCretionRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCretionRequest request);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
