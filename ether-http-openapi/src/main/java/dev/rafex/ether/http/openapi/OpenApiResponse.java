package dev.rafex.ether.http.openapi;

import java.util.Map;

public record OpenApiResponse(String description, Map<String, OpenApiMediaType> content) {

	public OpenApiResponse {
		content = content == null ? Map.of() : Map.copyOf(content);
	}

	public static OpenApiResponse ok(final String description, final OpenApiSchema schema) {
		return new OpenApiResponse(description, Map.of("application/json", new OpenApiMediaType(schema, null)));
	}
}
