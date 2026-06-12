package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.presentation.dto.RequestUserDto;
import com._FoundUs.Projekto.presentation.dto.ResponseUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface UserApiMapper {

    @Mapping(target = "id",ignore = true)
    UserModel toUserModel(RequestUserDto requestUserDto);

    default ResponseUserDto toResponseUserdto(UserModel userModel) {
        if (userModel == null) return null;

        return ResponseUserDto.builder()
                .id(userModel.getId())
                .username(userModel.getUsername())
                .email(userModel.getEmail())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .isActive(userModel.getIsActive())
                .build();
    }


}
