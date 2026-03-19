package dev.rafex.ether.http.openapi;

import java.util.LinkedHashMap;
import java.util.Map;

public record OpenApiPathItem(Map<String, OpenApiOperation> operations) {

	public OpenApiPathItem {
		operations = operations == null ? Map.of() : Map.copyOf(operations);
	}

	public static OpenApiPathItem empty() {
		return new OpenApiPathItem(Map.of());
	}

	public OpenApiPathItem withOperation(final String method, final OpenApiOperation operation) {
		final var next = new LinkedHashMap<String, OpenApiOperation>(operations);
		next.put(method.toLowerCase(), operation);
		return new OpenApiPathItem(next);
	}
}
