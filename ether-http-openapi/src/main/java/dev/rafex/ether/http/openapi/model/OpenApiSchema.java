package dev.rafex.ether.http.openapi.model;

import java.util.List;
import java.util.Map;

public record OpenApiSchema(String type, String format, String description, boolean nullable, Object example,
        String ref, Map<String, OpenApiSchema> properties, List<String> required, OpenApiSchema items) {

    public OpenApiSchema {
        properties = properties == null ? Map.of() : Map.copyOf(properties);
        required = required == null ? List.of() : List.copyOf(required);
    }

    public static OpenApiSchema stringSchema() {
        return new OpenApiSchema("string", null, null, false, null, null, Map.of(), List.of(), null);
    }

    public static OpenApiSchema integerSchema() {
        return new OpenApiSchema("integer", "int32", null, false, null, null, Map.of(), List.of(), null);
    }
}
