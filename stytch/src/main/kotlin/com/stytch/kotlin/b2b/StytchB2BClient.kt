package com.stytch.kotlin.b2b

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!
import com.stytch.kotlin.b2b.api.discovery.Discovery
import com.stytch.kotlin.b2b.api.discovery.DiscoveryImpl
import com.stytch.kotlin.b2b.api.magiclinks.MagicLinks
import com.stytch.kotlin.b2b.api.magiclinks.MagicLinksImpl
import com.stytch.kotlin.b2b.api.oauth.OAuth
import com.stytch.kotlin.b2b.api.oauth.OAuthImpl
import com.stytch.kotlin.b2b.api.organizations.Organizations
import com.stytch.kotlin.b2b.api.organizations.OrganizationsImpl
import com.stytch.kotlin.b2b.api.passwords.Passwords
import com.stytch.kotlin.b2b.api.passwords.PasswordsImpl
import com.stytch.kotlin.b2b.api.sessions.Sessions
import com.stytch.kotlin.b2b.api.sessions.SessionsImpl
import com.stytch.kotlin.b2b.api.sso.SSO
import com.stytch.kotlin.b2b.api.sso.SSOImpl
import com.stytch.kotlin.common.BASE_LIVE_URL
import com.stytch.kotlin.common.BASE_TEST_URL
import com.stytch.kotlin.common.JwtOptions
import com.stytch.kotlin.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.jose4j.jwk.HttpsJwks
public object StytchB2BClient {
    private lateinit var httpClient: HttpClient
    private lateinit var httpsJwks: HttpsJwks
    private lateinit var jwtOptions: JwtOptions
    public lateinit var discovery: Discovery
    public lateinit var magicLinks: MagicLinks
    public lateinit var oauth: OAuth
    public lateinit var organizations: Organizations
    public lateinit var passwords: Passwords
    public lateinit var sso: SSO
    public lateinit var sessions: Sessions

    public fun configure(projectId: String, secret: String) {
        val baseUrl = getBaseUrl(projectId)
        httpClient = HttpClient(
            baseUrl = baseUrl,
            projectId = projectId,
            secret = secret,
        )
        jwtOptions = JwtOptions(
            audience = projectId,
            issuer = "stytch.com/$projectId",
            type = "JWT",
        )
        val coroutineScope = CoroutineScope(SupervisorJob())
        httpsJwks = HttpsJwks("$baseUrl/v1/sessions/jwks/$projectId")
        discovery = DiscoveryImpl(httpClient, coroutineScope)
        magicLinks = MagicLinksImpl(httpClient, coroutineScope)
        oauth = OAuthImpl(httpClient, coroutineScope)
        organizations = OrganizationsImpl(httpClient, coroutineScope)
        passwords = PasswordsImpl(httpClient, coroutineScope)
        sso = SSOImpl(httpClient, coroutineScope)
        sessions = SessionsImpl(httpClient, coroutineScope)
    }

    /**
     * Resolve the base URL for the Stytch API environment.
     */
    private fun getBaseUrl(projectId: String): String = when (projectId.startsWith("project-test")) {
        true -> BASE_TEST_URL
        false -> BASE_LIVE_URL
    }
}
