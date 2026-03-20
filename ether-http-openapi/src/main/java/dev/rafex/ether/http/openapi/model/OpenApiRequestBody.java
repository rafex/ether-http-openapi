package dev.rafex.ether.http.openapi.model;

import java.util.Map;

public record OpenApiRequestBody(String description, boolean required, Map<String, OpenApiMediaType> content) {

    public OpenApiRequestBody {
        content = content == null ? Map.of() : Map.copyOf(content);
    }
}
