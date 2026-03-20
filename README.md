# ether-http-openapi

OpenAPI 3.1 document models and builders for Ether HTTP.

## Scope

- OpenAPI info/server/schema models
- Operations, parameters, request bodies and responses
- Document builder for routes and components
- JSON rendering via `ether-json`

This module is intentionally small. It provides the vocabulary and document
assembly layer, not a full annotation scanner or code generator yet.

## Notes

- The current scope is description and rendering, not route introspection.
- It is meant to be paired later with adapters that project `ether-http-core` routes into OpenAPI documents.
