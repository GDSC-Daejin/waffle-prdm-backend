package com.pr_dm.eco.foodwaste.service;

import com.pr_dm.eco.foodwaste.dto.FoodWasteResponseDto;
import com.pr_dm.eco.foodwaste.entity.FoodWaste;
import com.pr_dm.eco.foodwaste.mapper.FoodWasteMapper;
import com.pr_dm.eco.foodwaste.repository.FoodWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodWasteService {
    private final FoodWasteRepository foodWasteRepository;

    public List<FoodWasteResponseDto> getFoodWaste(Date start, Date end, String cityDo) {
        List<FoodWaste> foodWaste = foodWasteRepository.findAllByDateBetweenAndCityDo(start, end, cityDo);
        return foodWaste.stream().map(FoodWasteMapper::toFoodWasteResponseDto).collect(Collectors.toList());
    }

    public List<String> getCity() {
        List<String> foodWaste = foodWasteRepository.getDistinctLocationOrderByCity();
        return foodWaste;
        // return foodWaste.stream().map(FoodWasteMapper::toFoodWasteLocationResponseDto).collect(Collectors.toList());
    }

    public List<String> getGu(String cityDo) {
        List<String> foodWaste = foodWasteRepository.getDistinctLocationOrderByGu(cityDo);
        return foodWaste;
        // return foodWaste.stream().map(FoodWasteMapper::toFoodWasteLocationResponseDto).collect(Collectors.toList());
    }
}
