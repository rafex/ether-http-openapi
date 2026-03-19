package dev.rafex.ether.http.openapi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class OpenApiDocumentBuilder {

	private String openapi = "3.1.0";
	private OpenApiInfo info = new OpenApiInfo("ether-api", "0.0.0", null, null, null);
	private final List<OpenApiServer> servers = new ArrayList<>();
	private final Map<String, OpenApiPathItem> paths = new LinkedHashMap<>();
	private final Map<String, OpenApiSchema> schemas = new LinkedHashMap<>();
	private final Map<String, OpenApiResponse> responses = new LinkedHashMap<>();

	public static OpenApiDocumentBuilder create() {
		return new OpenApiDocumentBuilder();
	}

	public OpenApiDocumentBuilder openapi(final String openapi) {
		this.openapi = Objects.requireNonNull(openapi, "openapi");
		return this;
	}

	public OpenApiDocumentBuilder info(final OpenApiInfo info) {
		this.info = Objects.requireNonNull(info, "info");
		return this;
	}

	public OpenApiDocumentBuilder addServer(final OpenApiServer server) {
		servers.add(Objects.requireNonNull(server, "server"));
		return this;
	}

	public OpenApiDocumentBuilder addSchema(final String name, final OpenApiSchema schema) {
		schemas.put(Objects.requireNonNull(name, "name"), Objects.requireNonNull(schema, "schema"));
		return this;
	}

	public OpenApiDocumentBuilder addResponse(final String name, final OpenApiResponse response) {
		responses.put(Objects.requireNonNull(name, "name"), Objects.requireNonNull(response, "response"));
		return this;
	}

	public OpenApiDocumentBuilder addOperation(final String path, final String method, final OpenApiOperation operation) {
		Objects.requireNonNull(path, "path");
		Objects.requireNonNull(method, "method");
		Objects.requireNonNull(operation, "operation");
		paths.compute(path, (k, current) -> (current == null ? OpenApiPathItem.empty() : current)
				.withOperation(method, operation));
		return this;
	}

	public OpenApiDocument build() {
		return new OpenApiDocument(openapi, info, servers, paths, new OpenApiComponents(schemas, responses));
	}
}
