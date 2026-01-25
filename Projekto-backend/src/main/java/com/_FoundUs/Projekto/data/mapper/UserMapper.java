package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserModel toUserModel(User user);
    User toUser(UserModel userModel);
}
