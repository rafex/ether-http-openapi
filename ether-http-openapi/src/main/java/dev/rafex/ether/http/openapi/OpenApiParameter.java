package dev.rafex.ether.http.openapi;

public record OpenApiParameter(
		String name,
		String in,
		String description,
		boolean required,
		OpenApiSchema schema) {
}
