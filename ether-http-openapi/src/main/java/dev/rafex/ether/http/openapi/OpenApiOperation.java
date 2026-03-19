package dev.rafex.ether.http.openapi;

import java.util.List;
import java.util.Map;

public record OpenApiOperation(
		String operationId,
		String summary,
		String description,
		List<String> tags,
		List<OpenApiParameter> parameters,
		Map<String, OpenApiResponse> responses,
		OpenApiRequestBody requestBody) {

	public OpenApiOperation {
		tags = tags == null ? List.of() : List.copyOf(tags);
		parameters = parameters == null ? List.of() : List.copyOf(parameters);
		responses = responses == null ? Map.of() : Map.copyOf(responses);
	}

	public static OpenApiOperation of(final String operationId, final String summary) {
		return new OpenApiOperation(operationId, summary, null, List.of(), List.of(), Map.of(), null);
	}
}
