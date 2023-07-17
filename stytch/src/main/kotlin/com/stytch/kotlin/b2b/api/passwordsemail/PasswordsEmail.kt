package com.stytch.kotlin.b2b.api.passwordsemail

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.kotlin.b2b.models.passwordsemail.ResetRequest
import com.stytch.kotlin.b2b.models.passwordsemail.ResetResponse
import com.stytch.kotlin.b2b.models.passwordsemail.ResetStartRequest
import com.stytch.kotlin.b2b.models.passwordsemail.ResetStartResponse
import com.stytch.kotlin.common.StytchResult
import com.stytch.kotlin.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

public interface Email {
    /**
     * Initiates a password reset for the email address provided. This will trigger an email to be sent to the address,
     * containing a magic link that will allow them to set a new password and authenticate.
     *
     * This endpoint adapts to your Project's password strength configuration.
     * If you're using [zxcvbn](https://stytch.com/docs/passwords#strength-requirements), the default, your passwords are
     * considered valid
     * if the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/passwords#strength-requirements), your
     * passwords are
     * considered valid if they meet the requirements that you've set with Stytch.
     * You may update your password strength configuration in the
     * [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     */
    public suspend fun resetStart(data: ResetStartRequest): StytchResult<ResetStartResponse>

    /**
     * Initiates a password reset for the email address provided. This will trigger an email to be sent to the address,
     * containing a magic link that will allow them to set a new password and authenticate.
     *
     * This endpoint adapts to your Project's password strength configuration.
     * If you're using [zxcvbn](https://stytch.com/docs/passwords#strength-requirements), the default, your passwords are
     * considered valid
     * if the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/passwords#strength-requirements), your
     * passwords are
     * considered valid if they meet the requirements that you've set with Stytch.
     * You may update your password strength configuration in the
     * [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     */
    public fun resetStart(data: ResetStartRequest, callback: (StytchResult<ResetStartResponse>) -> Unit)

    /**
     * Initiates a password reset for the email address provided. This will trigger an email to be sent to the address,
     * containing a magic link that will allow them to set a new password and authenticate.
     *
     * This endpoint adapts to your Project's password strength configuration.
     * If you're using [zxcvbn](https://stytch.com/docs/passwords#strength-requirements), the default, your passwords are
     * considered valid
     * if the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/passwords#strength-requirements), your
     * passwords are
     * considered valid if they meet the requirements that you've set with Stytch.
     * You may update your password strength configuration in the
     * [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     */
    public fun resetStartCompletable(data: ResetStartRequest): CompletableFuture<StytchResult<ResetStartResponse>>

    /**
     * Reset the member's password and authenticate them. This endpoint checks that the password reset token is valid, hasn’t
     * expired, or already been used.
     *
     * The provided password needs to meet our password strength requirements, which can be checked in advance with the
     * password strength endpoint. If the token and password are accepted, the password is securely stored for future
     * authentication and the user is authenticated.
     */
    public suspend fun reset(data: ResetRequest): StytchResult<ResetResponse>

    /**
     * Reset the member's password and authenticate them. This endpoint checks that the password reset token is valid, hasn’t
     * expired, or already been used.
     *
     * The provided password needs to meet our password strength requirements, which can be checked in advance with the
     * password strength endpoint. If the token and password are accepted, the password is securely stored for future
     * authentication and the user is authenticated.
     */
    public fun reset(data: ResetRequest, callback: (StytchResult<ResetResponse>) -> Unit)

    /**
     * Reset the member's password and authenticate them. This endpoint checks that the password reset token is valid, hasn’t
     * expired, or already been used.
     *
     * The provided password needs to meet our password strength requirements, which can be checked in advance with the
     * password strength endpoint. If the token and password are accepted, the password is securely stored for future
     * authentication and the user is authenticated.
     */
    public fun resetCompletable(data: ResetRequest): CompletableFuture<StytchResult<ResetResponse>>
}

internal class EmailImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Email {

    private val moshi = Moshi.Builder().build()

    override suspend fun resetStart(data: ResetStartRequest): StytchResult<ResetStartResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(ResetStartRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/passwords/email/reset/start", asJson)
    }

    override fun resetStart(data: ResetStartRequest, callback: (StytchResult<ResetStartResponse>) -> Unit) {
        coroutineScope.launch {
            callback(resetStart(data))
        }
    }

    override fun resetStartCompletable(data: ResetStartRequest): CompletableFuture<StytchResult<ResetStartResponse>> {
        val executor = Executors.newFixedThreadPool(1)
        return CompletableFuture.supplyAsync({
            val asJson = moshi.adapter(ResetStartRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/passwords/email/reset/start", asJson)
        }, executor)
    }
    override suspend fun reset(data: ResetRequest): StytchResult<ResetResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(ResetRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/passwords/email/reset", asJson)
    }

    override fun reset(data: ResetRequest, callback: (StytchResult<ResetResponse>) -> Unit) {
        coroutineScope.launch {
            callback(reset(data))
        }
    }

    override fun resetCompletable(data: ResetRequest): CompletableFuture<StytchResult<ResetResponse>> {
        val executor = Executors.newFixedThreadPool(1)
        return CompletableFuture.supplyAsync({
            val asJson = moshi.adapter(ResetRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/passwords/email/reset", asJson)
        }, executor)
    }
}