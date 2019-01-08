package de.ngxa.restaurant.utils;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ConverterModelMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private ConverterModelMapper() {}

    public static <S, T> T map(S object, Class<T> clazz) {
        return modelMapper.map(object, clazz);
    }

    public static <S, T> List<T> map(List<S> objectList, Class<T> clazz) {
        final List<T> targetList = new ArrayList<>();

        for(S s: objectList) {
            targetList.add(modelMapper.map(s, clazz));
        }
        return targetList;
    }
}
