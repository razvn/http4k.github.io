package blog.self_documenting_apis

import org.http4k.contract.contract
import org.http4k.contract.openapi.ApiInfo
import org.http4k.contract.openapi.v3.OpenApi3
import org.http4k.contract.security.BasicAuthSecurity
import org.http4k.core.Credentials
import org.http4k.core.HttpHandler
import org.http4k.format.Jackson

val http: HttpHandler = contract {
    renderer = OpenApi3(ApiInfo("my great api", "v1.0"), Jackson)
    descriptionPath = "/api/swagger.json"
    security = BasicAuthSecurity("realm", Credentials("user", "password"))
}