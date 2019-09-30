package com.sinelnikov.resource;

import com.sinelnikov.dto.Response;
import com.sinelnikov.dto.UserDto;
import com.sinelnikov.entity.UserEntity;
import com.sinelnikov.exception.ResourceNotFoundException;
import com.sinelnikov.mapper.MapperUtils;
import com.sinelnikov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@SuppressWarnings("unused")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<List<UserDto>> getAllUsers() {
        return new Response<>(MapperUtils.userEntitiesToUserDtos(this.userService.getAllUsers()));
    }

    @GetMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<UserDto> getUserById(@PathVariable final Integer id) {
        UserEntity user = this.userService.getUserById(id);
        if (user == null) {
            throw new ResourceNotFoundException("No user found for id " + id);
        }
        return new Response<>(MapperUtils.userEntityToUserDto(user));
    }

    @PutMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Response<UserDto> addUser(@RequestBody final UserDto user) {
        UserEntity userEntity = this.userService.addUser(MapperUtils.userDtoToUserEntity(user));
        return new Response<>(MapperUtils.userEntityToUserDto(userEntity));
    }

    @PostMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Response<UserDto> updateUser(@RequestBody final UserDto user) {
        UserEntity userEntity = this.userService.updateUser(MapperUtils.userDtoToUserEntity(user));
        return new Response<>(MapperUtils.userEntityToUserDto(userEntity));
    }

    @DeleteMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity deleteUser(@PathVariable final Integer id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
