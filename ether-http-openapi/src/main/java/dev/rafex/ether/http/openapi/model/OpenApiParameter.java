package dev.rafex.ether.http.openapi.model;

public record OpenApiParameter(String name, String in, String description, boolean required, OpenApiSchema schema) {
}
