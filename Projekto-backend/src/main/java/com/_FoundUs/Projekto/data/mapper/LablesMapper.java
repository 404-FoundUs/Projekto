package com._FoundUs.Projekto.data.mapper;


import com._FoundUs.Projekto.data.entity.Labels;
import com._FoundUs.Projekto.domain.model.LablesModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LablesMapper {
    @Mapping(target = "boardId", source = "board.id")
    LablesModel toModel(Labels label);
}
