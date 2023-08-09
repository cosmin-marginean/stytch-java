package com.stytch.java.b2b.api.otpsms

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.b2b.models.otpsms.AuthenticateRequest
import com.stytch.java.b2b.models.otpsms.AuthenticateResponse
import com.stytch.java.b2b.models.otpsms.SendRequest
import com.stytch.java.b2b.models.otpsms.SendResponse
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
public interface Sms {
    /**
     * Send a one-time passcode (OTP) to a Member's phone number. If the Member already has a phone number, this will send an
     * OTP to the number associated with their `member_id`. If not, then this will send an OTP to the `mfa_phone_number`
     * provided and link the `mfa_phone_number` with the Member.
     * An error will be thrown if the Member already has a phone number and the provided `mfa_phone_number` does not match the
     * existing one.
     *
     * Note that sending another OTP code before the first has expired will invalidate the first code.
     *
     * If a Member has a phone number and is enrolled in MFA, then after a successful primary authentication event (e.g.
     * [email magic link](https://stytch.com/docs/b2b/api/authenticate-magic-link) or
     * [SSO](https://stytch.com/docs/b2b/api/sso-authenticate) login is complete), an SMS OTP will automatically be sent to
     * their phone number. In that case, this endpoint should only be used for subsequent authentication events, such as
     * prompting a Member for an OTP again after a period of inactivity.
     */
    public suspend fun send(data: SendRequest): StytchResult<SendResponse>

    /**
     * Send a one-time passcode (OTP) to a Member's phone number. If the Member already has a phone number, this will send an
     * OTP to the number associated with their `member_id`. If not, then this will send an OTP to the `mfa_phone_number`
     * provided and link the `mfa_phone_number` with the Member.
     * An error will be thrown if the Member already has a phone number and the provided `mfa_phone_number` does not match the
     * existing one.
     *
     * Note that sending another OTP code before the first has expired will invalidate the first code.
     *
     * If a Member has a phone number and is enrolled in MFA, then after a successful primary authentication event (e.g.
     * [email magic link](https://stytch.com/docs/b2b/api/authenticate-magic-link) or
     * [SSO](https://stytch.com/docs/b2b/api/sso-authenticate) login is complete), an SMS OTP will automatically be sent to
     * their phone number. In that case, this endpoint should only be used for subsequent authentication events, such as
     * prompting a Member for an OTP again after a period of inactivity.
     */
    public fun send(data: SendRequest, callback: (StytchResult<SendResponse>) -> Unit)

    /**
     * Send a one-time passcode (OTP) to a Member's phone number. If the Member already has a phone number, this will send an
     * OTP to the number associated with their `member_id`. If not, then this will send an OTP to the `mfa_phone_number`
     * provided and link the `mfa_phone_number` with the Member.
     * An error will be thrown if the Member already has a phone number and the provided `mfa_phone_number` does not match the
     * existing one.
     *
     * Note that sending another OTP code before the first has expired will invalidate the first code.
     *
     * If a Member has a phone number and is enrolled in MFA, then after a successful primary authentication event (e.g.
     * [email magic link](https://stytch.com/docs/b2b/api/authenticate-magic-link) or
     * [SSO](https://stytch.com/docs/b2b/api/sso-authenticate) login is complete), an SMS OTP will automatically be sent to
     * their phone number. In that case, this endpoint should only be used for subsequent authentication events, such as
     * prompting a Member for an OTP again after a period of inactivity.
     */
    public fun sendCompletable(data: SendRequest): CompletableFuture<StytchResult<SendResponse>>

    /**
     * Authenticates a Member's OTP code. This endpoint verifies that the code is valid and hasn't expired or been previously
     * used. A given Member may only have a single active OTP code at any given time. If a Member requests another OTP code
     * before the first one has expired, the first one will be invalidated.
     *
     * Exactly one of `intermediate_session_token`, `session_token`, or `session_jwt` must be provided in the request.
     * If an intermediate session token is provided, this operation will consume it.
     *
     * If the Organization's MFA policy is `REQUIRED_FOR_ALL`, a successful OTP authentication will change the Member's
     * `mfa_enrolled` status to `true` if it is not already `true`.
     * If the Organization's MFA policy is `OPTIONAL`, the Member's MFA enrollment can be toggled by passing in a value for
     * the `set_mfa_enrollment` field.
     *
     * Provide the `session_duration_minutes` parameter to set the lifetime of the session. If the `session_duration_minutes`
     * parameter is not specified, a Stytch session will be created with a duration of 60 minutes.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Authenticates a Member's OTP code. This endpoint verifies that the code is valid and hasn't expired or been previously
     * used. A given Member may only have a single active OTP code at any given time. If a Member requests another OTP code
     * before the first one has expired, the first one will be invalidated.
     *
     * Exactly one of `intermediate_session_token`, `session_token`, or `session_jwt` must be provided in the request.
     * If an intermediate session token is provided, this operation will consume it.
     *
     * If the Organization's MFA policy is `REQUIRED_FOR_ALL`, a successful OTP authentication will change the Member's
     * `mfa_enrolled` status to `true` if it is not already `true`.
     * If the Organization's MFA policy is `OPTIONAL`, the Member's MFA enrollment can be toggled by passing in a value for
     * the `set_mfa_enrollment` field.
     *
     * Provide the `session_duration_minutes` parameter to set the lifetime of the session. If the `session_duration_minutes`
     * parameter is not specified, a Stytch session will be created with a duration of 60 minutes.
     */
    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)

    /**
     * Authenticates a Member's OTP code. This endpoint verifies that the code is valid and hasn't expired or been previously
     * used. A given Member may only have a single active OTP code at any given time. If a Member requests another OTP code
     * before the first one has expired, the first one will be invalidated.
     *
     * Exactly one of `intermediate_session_token`, `session_token`, or `session_jwt` must be provided in the request.
     * If an intermediate session token is provided, this operation will consume it.
     *
     * If the Organization's MFA policy is `REQUIRED_FOR_ALL`, a successful OTP authentication will change the Member's
     * `mfa_enrolled` status to `true` if it is not already `true`.
     * If the Organization's MFA policy is `OPTIONAL`, the Member's MFA enrollment can be toggled by passing in a value for
     * the `set_mfa_enrollment` field.
     *
     * Provide the `session_duration_minutes` parameter to set the lifetime of the session. If the `session_duration_minutes`
     * parameter is not specified, a Stytch session will be created with a duration of 60 minutes.
     */
    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>
}

internal class SmsImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Sms {

    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun send(data: SendRequest): StytchResult<SendResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(SendRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/otps/sms/send", asJson)
    }

    override fun send(data: SendRequest, callback: (StytchResult<SendResponse>) -> Unit) {
        coroutineScope.launch {
            callback(send(data))
        }
    }

    override fun sendCompletable(data: SendRequest): CompletableFuture<StytchResult<SendResponse>> =
        coroutineScope.async {
            send(data)
        }.asCompletableFuture()
    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/otps/sms/authenticate", asJson)
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
