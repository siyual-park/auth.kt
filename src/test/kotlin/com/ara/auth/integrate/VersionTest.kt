package com.ara.auth.integrate

import com.ara.auth.body
import com.ara.auth.testModule
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class VersionTest {
    @Test
    fun testGetSuccess() {
        withTestApplication(testModule) {
            handleRequest(HttpMethod.Get, "/version").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                val packageVersion: Map<String, String> = response.body()

                assert(packageVersion.contains("major"))
                assert(packageVersion.contains("minor"))
                assert(packageVersion.contains("patch"))
                assert(packageVersion.contains("commit"))
            }
        }
    }
}
