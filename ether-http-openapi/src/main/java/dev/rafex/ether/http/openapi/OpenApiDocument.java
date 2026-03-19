package dev.rafex.ether.http.openapi;

import java.util.List;
import java.util.Map;

import dev.rafex.ether.json.JsonUtils;

public record OpenApiDocument(
		String openapi,
		OpenApiInfo info,
		List<OpenApiServer> servers,
		Map<String, OpenApiPathItem> paths,
		OpenApiComponents components) {

	public OpenApiDocument {
		servers = servers == null ? List.of() : List.copyOf(servers);
		paths = paths == null ? Map.of() : Map.copyOf(paths);
	}

	public String toJson() {
		return JsonUtils.toJson(this);
	}

	public String toPrettyJson() {
		return JsonUtils.toPrettyJson(this);
	}
}
