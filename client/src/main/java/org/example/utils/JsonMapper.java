package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.example.domian.ArchState;

public class JsonMapper {

    private final ObjectMapper objectMapper;

    public JsonMapper() {
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        objectMapper = new ObjectMapper()
                .setDefaultPrettyPrinter(prettyPrinter)
                .enable(SerializationFeature.INDENT_OUTPUT);
    }

    public ArchState readState(String json) {
        return parse(json, new TypeReference<ArchState>() {
        });
    }

    @SneakyThrows
    public <T> T parse(String json, TypeReference<T> typeReference) {
        return objectMapper.readValue(json, typeReference);
    }

    @SneakyThrows
    public String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }
}
