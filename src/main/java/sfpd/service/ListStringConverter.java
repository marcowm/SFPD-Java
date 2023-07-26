package sfpd.service;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Converter
public class ListStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> filtroTipo) {
        if (!Optional.ofNullable(filtroTipo).isPresent()) return "";
        return filtroTipo.stream().map(String::toString).collect(Collectors.joining(","));
    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        if (!Optional.ofNullable(joined).filter(s -> !s.isEmpty()).isPresent()) return new ArrayList<>();
        return
                Arrays.asList(
                                joined.split(","))
                        .stream()
                        .map(String::valueOf).collect(toCollection(ArrayList::new)
                        );
    }
}