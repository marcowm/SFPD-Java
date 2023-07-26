package sfpd.service;

import sfpd.enums.FlagChave;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Converter
public class StringToListFlagConverter implements AttributeConverter<List<FlagChave>, String> {

    @Override
    public String convertToDatabaseColumn(List<FlagChave> flagChaves) {
        if (!Optional.ofNullable(flagChaves).isPresent()) return "";
        return flagChaves.stream().map(FlagChave::toString).collect(Collectors.joining(","));
    }

    @Override
    public List<FlagChave> convertToEntityAttribute(String joined) {
        if (!Optional.ofNullable(joined).filter(s -> !s.isEmpty()).isPresent()) return new ArrayList<>();
        return
                Arrays.asList(
                        joined.split(","))
                        .stream()
                        .map(FlagChave::valueOf).collect(toCollection(ArrayList::new)
                );
    }
}