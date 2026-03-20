package dev.rafex.ether.http.openapi.model;

import java.util.Map;

public record OpenApiComponents(Map<String, OpenApiSchema> schemas, Map<String, OpenApiResponse> responses) {

    public OpenApiComponents {
        schemas = schemas == null ? Map.of() : Map.copyOf(schemas);
        responses = responses == null ? Map.of() : Map.copyOf(responses);
    }
}
