package com.sinelnikov.mapper;

import com.sinelnikov.dto.UserDto;
import com.sinelnikov.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUtils {
    private interface Mapper<I, O> {
        O map(I input);
    }

    private static <I, O> List<O> convert(List<I> input, Mapper<I, O> mapper) {
        return input.stream().map(mapper::map).collect(Collectors.toList());
    }

    public static List<UserDto> userEntitiesToUserDtos(List<UserEntity> userEntities) {
        return convert(userEntities, MapperUtils::userEntityToUserDto);
    }

    public static List<UserEntity> userDtosToUserEntities(List<UserDto> userDtos) {
        return convert(userDtos, MapperUtils::userDtoToUserEntity);
    }

    public static UserDto userEntityToUserDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSecondName(),
                userEntity.getBirthdayDate(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getAboutUser(),
                userEntity.getAddress()
        );
    }

    public static UserEntity userDtoToUserEntity(UserDto userDto) {
        return new UserEntity(
                userDto.getId(),
                userDto.getName(),
                userDto.getSecondName(),
                userDto.getBirthdayDate(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getAboutUser(),
                userDto.getAddress()
        );
    }
}
