package com.stytch.java.b2b.api.sso

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.b2b.api.ssooidc.OIDC
import com.stytch.java.b2b.api.ssooidc.OIDCImpl
import com.stytch.java.b2b.api.ssosaml.SAML
import com.stytch.java.b2b.api.ssosaml.SAMLImpl
import com.stytch.java.b2b.models.sso.AuthenticateRequest
import com.stytch.java.b2b.models.sso.AuthenticateResponse
import com.stytch.java.b2b.models.sso.DeleteConnectionRequest
import com.stytch.java.b2b.models.sso.DeleteConnectionResponse
import com.stytch.java.b2b.models.sso.GetConnectionsRequest
import com.stytch.java.b2b.models.sso.GetConnectionsResponse
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.StytchResult
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
public interface SSO {
    public val oidc: OIDC

    public val saml: SAML

    /**
     * Get all SSO Connections owned by the organization.
     */
    public suspend fun getConnections(data: GetConnectionsRequest): StytchResult<GetConnectionsResponse>

    /**
     * Get all SSO Connections owned by the organization.
     */
    public fun getConnections(data: GetConnectionsRequest, callback: (StytchResult<GetConnectionsResponse>) -> Unit)

    /**
     * Get all SSO Connections owned by the organization.
     */
    public fun getConnectionsCompletable(data: GetConnectionsRequest): CompletableFuture<StytchResult<GetConnectionsResponse>>

    /**
     * Delete an existing SSO connection.
     */
    public suspend fun deleteConnection(data: DeleteConnectionRequest): StytchResult<DeleteConnectionResponse>

    /**
     * Delete an existing SSO connection.
     */
    public fun deleteConnection(data: DeleteConnectionRequest, callback: (StytchResult<DeleteConnectionResponse>) -> Unit)

    /**
     * Delete an existing SSO connection.
     */
    public fun deleteConnectionCompletable(data: DeleteConnectionRequest): CompletableFuture<StytchResult<DeleteConnectionResponse>>

    /**
     * Authenticate a user given a token.
     * This endpoint verifies that the user completed the SSO Authentication flow by verifying that the token is valid and
     * hasn't expired.
     * Provide the `session_duration_minutes` parameter to set the lifetime of the session.
     * If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60 minute
     * duration.
     * To link this authentication event to an existing Stytch session, include either the `session_token` or `session_jwt`
     * param.
     *
     * (Coming Soon) If the Member is required to complete MFA to log in to the Organization, the returned value of
     * `member_authenticated` will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Authenticate a user given a token.
     * This endpoint verifies that the user completed the SSO Authentication flow by verifying that the token is valid and
     * hasn't expired.
     * Provide the `session_duration_minutes` parameter to set the lifetime of the session.
     * If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60 minute
     * duration.
     * To link this authentication event to an existing Stytch session, include either the `session_token` or `session_jwt`
     * param.
     *
     * (Coming Soon) If the Member is required to complete MFA to log in to the Organization, the returned value of
     * `member_authenticated` will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     */
    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)

    /**
     * Authenticate a user given a token.
     * This endpoint verifies that the user completed the SSO Authentication flow by verifying that the token is valid and
     * hasn't expired.
     * Provide the `session_duration_minutes` parameter to set the lifetime of the session.
     * If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60 minute
     * duration.
     * To link this authentication event to an existing Stytch session, include either the `session_token` or `session_jwt`
     * param.
     *
     * (Coming Soon) If the Member is required to complete MFA to log in to the Organization, the returned value of
     * `member_authenticated` will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     */
    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>
}

internal class SSOImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : SSO {

    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override val oidc: OIDC = OIDCImpl(httpClient, coroutineScope)
    override val saml: SAML = SAMLImpl(httpClient, coroutineScope)

    override suspend fun getConnections(data: GetConnectionsRequest): StytchResult<GetConnectionsResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(GetConnectionsRequest::class.java).toJson(data)
        val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
        val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
        val asMap = adapter.fromJson(asJson) ?: emptyMap()
        httpClient.get("/v1/b2b/sso/${data.organizationId}", asMap)
    }

    override fun getConnections(data: GetConnectionsRequest, callback: (StytchResult<GetConnectionsResponse>) -> Unit) {
        coroutineScope.launch {
            callback(getConnections(data))
        }
    }

    override fun getConnectionsCompletable(data: GetConnectionsRequest): CompletableFuture<StytchResult<GetConnectionsResponse>> =
        coroutineScope.async {
            getConnections(data)
        }.asCompletableFuture()
    override suspend fun deleteConnection(data: DeleteConnectionRequest): StytchResult<DeleteConnectionResponse> = withContext(Dispatchers.IO) {
        httpClient.delete("/v1/b2b/sso/${data.organizationId}/connections/${data.connectionId}")
    }

    override fun deleteConnection(data: DeleteConnectionRequest, callback: (StytchResult<DeleteConnectionResponse>) -> Unit) {
        coroutineScope.launch {
            callback(deleteConnection(data))
        }
    }

    override fun deleteConnectionCompletable(data: DeleteConnectionRequest): CompletableFuture<StytchResult<DeleteConnectionResponse>> =
        coroutineScope.async {
            deleteConnection(data)
        }.asCompletableFuture()
    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/sso/authenticate", asJson)
    }

    override fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(authenticate(data))
        }
    }

    override fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>> =
        coroutineScope.async {
            authenticate(data)
        }.asCompletableFuture()
}