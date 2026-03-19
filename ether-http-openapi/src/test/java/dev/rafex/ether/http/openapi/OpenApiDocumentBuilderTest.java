package dev.rafex.ether.http.openapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OpenApiDocumentBuilderTest {

	@Test
	void builderShouldAccumulateOperationsAndRenderJson() {
		final var doc = OpenApiDocumentBuilder.create()
				.info(new OpenApiInfo("Ether API", "1.0.0", "Demo", null, null))
				.addServer(new OpenApiServer("https://api.example.com", "production"))
				.addSchema("User", OpenApiSchema.stringSchema())
				.addResponse("Ok", OpenApiResponse.ok("success", OpenApiSchema.stringSchema()))
				.addOperation("/users", "get", OpenApiOperation.of("listUsers", "List users"))
				.build();

		assertEquals("3.1.0", doc.openapi());
		assertTrue(doc.paths().containsKey("/users"));
		assertEquals("List users", doc.paths().get("/users").operations().get("get").summary());
		assertTrue(doc.toJson().contains("\"openapi\":\"3.1.0\""));
	}

	@Test
	void schemaShouldPreserveRequiredAndPropertiesCopies() {
		final var schema = new OpenApiSchema("object", null, null, false, null, null,
				java.util.Map.of("id", OpenApiSchema.integerSchema()), java.util.List.of("id"), null);

		assertEquals(1, schema.properties().size());
		assertEquals(1, schema.required().size());
	}
}
