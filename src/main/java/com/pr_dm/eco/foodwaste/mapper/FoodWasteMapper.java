package com.pr_dm.eco.foodwaste.mapper;


import com.pr_dm.eco.foodwaste.dto.FoodWasteResponseDto;
import com.pr_dm.eco.foodwaste.entity.FoodWaste;

public class FoodWasteMapper {
    public static FoodWasteResponseDto toFoodWasteResponseDto(FoodWaste entity) {
        return FoodWasteResponseDto.builder()
                .wasteId(entity.getWasteId())
                .location(entity.getLocation())
                .amount(entity.getAmount())
                .date(entity.getDate())
                .build();
    }
}
