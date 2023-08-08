package com.stytch.java.consumer.api.passwords

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.common.StytchResult
import com.stytch.java.consumer.api.passwordsemail.Email
import com.stytch.java.consumer.api.passwordsemail.EmailImpl
import com.stytch.java.consumer.api.passwordsexistingpassword.ExistingPassword
import com.stytch.java.consumer.api.passwordsexistingpassword.ExistingPasswordImpl
import com.stytch.java.consumer.api.passwordssession.Sessions
import com.stytch.java.consumer.api.passwordssession.SessionsImpl
import com.stytch.java.consumer.models.passwords.AuthenticateRequest
import com.stytch.java.consumer.models.passwords.AuthenticateResponse
import com.stytch.java.consumer.models.passwords.CreateRequest
import com.stytch.java.consumer.models.passwords.CreateResponse
import com.stytch.java.consumer.models.passwords.MigrateRequest
import com.stytch.java.consumer.models.passwords.MigrateResponse
import com.stytch.java.consumer.models.passwords.StrengthCheckRequest
import com.stytch.java.consumer.models.passwords.StrengthCheckResponse
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
public interface Passwords {
    public val email: Email

    public val existingPassword: ExistingPassword

    public val sessions: Sessions

    /**
     * Create a new user with a password and an authenticated session for the user if requested. If a user with this email
     * already exists in the project, this API will return an error.
     *
     * Existing passwordless users who wish to create a password need to go through the reset password flow.
     *
     * This endpoint will return an error if the password provided does not meet our strength requirements, which you can
     * check beforehand with the password strength endpoint.
     */
    public suspend fun create(data: CreateRequest): StytchResult<CreateResponse>

    /**
     * Create a new user with a password and an authenticated session for the user if requested. If a user with this email
     * already exists in the project, this API will return an error.
     *
     * Existing passwordless users who wish to create a password need to go through the reset password flow.
     *
     * This endpoint will return an error if the password provided does not meet our strength requirements, which you can
     * check beforehand with the password strength endpoint.
     */
    public fun create(data: CreateRequest, callback: (StytchResult<CreateResponse>) -> Unit)

    /**
     * Create a new user with a password and an authenticated session for the user if requested. If a user with this email
     * already exists in the project, this API will return an error.
     *
     * Existing passwordless users who wish to create a password need to go through the reset password flow.
     *
     * This endpoint will return an error if the password provided does not meet our strength requirements, which you can
     * check beforehand with the password strength endpoint.
     */
    public fun createCompletable(data: CreateRequest): CompletableFuture<StytchResult<CreateResponse>>

    /**
     * Authenticate a user with their email address and password. This endpoint verifies that the user has a password
     * currently set, and that the entered password is correct. There are two instances where the endpoint will return a
     * `reset_password` error even if they enter their previous password:
     *
     * **One:** The user’s credentials appeared in the HaveIBeenPwned dataset. We force a password reset to ensure that the
     * user is the legitimate owner of the email address, and not a malicious actor abusing the compromised credentials.
     *
     * **Two:** A user that has previously authenticated with email/password uses a passwordless authentication method tied to
     * the same email address (e.g. Magic Links, Google OAuth) for the first time. Any subsequent email/password
     * authentication attempt will result in this error. We force a password reset in this instance in order to safely
     * deduplicate the account by email address, without introducing the risk of a pre-hijack account takeover attack.
     *
     * Imagine a bad actor creates many accounts using passwords and the known email addresses of their victims. If a victim
     * comes to the site and logs in for the first time with an email-based passwordless authentication method then both the
     * victim and the bad actor have credentials to access to the same account. To prevent this, any further email/password
     * login attempts first require a password reset which can only be accomplished by someone with access to the underlying
     * email address.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Authenticate a user with their email address and password. This endpoint verifies that the user has a password
     * currently set, and that the entered password is correct. There are two instances where the endpoint will return a
     * `reset_password` error even if they enter their previous password:
     *
     * **One:** The user’s credentials appeared in the HaveIBeenPwned dataset. We force a password reset to ensure that the
     * user is the legitimate owner of the email address, and not a malicious actor abusing the compromised credentials.
     *
     * **Two:** A user that has previously authenticated with email/password uses a passwordless authentication method tied to
     * the same email address (e.g. Magic Links, Google OAuth) for the first time. Any subsequent email/password
     * authentication attempt will result in this error. We force a password reset in this instance in order to safely
     * deduplicate the account by email address, without introducing the risk of a pre-hijack account takeover attack.
     *
     * Imagine a bad actor creates many accounts using passwords and the known email addresses of their victims. If a victim
     * comes to the site and logs in for the first time with an email-based passwordless authentication method then both the
     * victim and the bad actor have credentials to access to the same account. To prevent this, any further email/password
     * login attempts first require a password reset which can only be accomplished by someone with access to the underlying
     * email address.
     */
    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)

    /**
     * Authenticate a user with their email address and password. This endpoint verifies that the user has a password
     * currently set, and that the entered password is correct. There are two instances where the endpoint will return a
     * `reset_password` error even if they enter their previous password:
     *
     * **One:** The user’s credentials appeared in the HaveIBeenPwned dataset. We force a password reset to ensure that the
     * user is the legitimate owner of the email address, and not a malicious actor abusing the compromised credentials.
     *
     * **Two:** A user that has previously authenticated with email/password uses a passwordless authentication method tied to
     * the same email address (e.g. Magic Links, Google OAuth) for the first time. Any subsequent email/password
     * authentication attempt will result in this error. We force a password reset in this instance in order to safely
     * deduplicate the account by email address, without introducing the risk of a pre-hijack account takeover attack.
     *
     * Imagine a bad actor creates many accounts using passwords and the known email addresses of their victims. If a victim
     * comes to the site and logs in for the first time with an email-based passwordless authentication method then both the
     * victim and the bad actor have credentials to access to the same account. To prevent this, any further email/password
     * login attempts first require a password reset which can only be accomplished by someone with access to the underlying
     * email address.
     */
    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>

    /**
     * This API allows you to check whether or not the user’s provided password is valid, and to provide feedback to the user
     * on how to increase the strength of their password.
     *
     * This endpoint adapts to your Project's password strength configuration. If you're using
     * [zxcvbn](https://stytch.com/docs/guides/passwords/strength-policy), the default, your passwords are considered valid if
     * the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/guides/passwords/strength-policy), your
     * passwords are considered valid if they meet the requirements that you've set with Stytch. You may update your password
     * strength configuration in the [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     *
     *
     * ### Password feedback
     *
     * The `feedback` object contains relevant fields for you to relay feedback to users that failed to create a strong enough
     * password.
     *
     * If you're using zxcvbn, the `feedback` object will contain `warning` and `suggestions` for any password that does not
     * meet the zxcvbn strength requirements. You can return these strings directly to the user to help them craft a strong
     * password.
     *
     * If you're using LUDS, the `feedback` object will contain an object named `luds_requirements` which contain a collection
     * of fields that the user failed or passed. You'll want to prompt the user to create a password that meets all of the
     * requirements that they failed.
     */
    public suspend fun strengthCheck(data: StrengthCheckRequest): StytchResult<StrengthCheckResponse>

    /**
     * This API allows you to check whether or not the user’s provided password is valid, and to provide feedback to the user
     * on how to increase the strength of their password.
     *
     * This endpoint adapts to your Project's password strength configuration. If you're using
     * [zxcvbn](https://stytch.com/docs/guides/passwords/strength-policy), the default, your passwords are considered valid if
     * the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/guides/passwords/strength-policy), your
     * passwords are considered valid if they meet the requirements that you've set with Stytch. You may update your password
     * strength configuration in the [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     *
     *
     * ### Password feedback
     *
     * The `feedback` object contains relevant fields for you to relay feedback to users that failed to create a strong enough
     * password.
     *
     * If you're using zxcvbn, the `feedback` object will contain `warning` and `suggestions` for any password that does not
     * meet the zxcvbn strength requirements. You can return these strings directly to the user to help them craft a strong
     * password.
     *
     * If you're using LUDS, the `feedback` object will contain an object named `luds_requirements` which contain a collection
     * of fields that the user failed or passed. You'll want to prompt the user to create a password that meets all of the
     * requirements that they failed.
     */
    public fun strengthCheck(data: StrengthCheckRequest, callback: (StytchResult<StrengthCheckResponse>) -> Unit)

    /**
     * This API allows you to check whether or not the user’s provided password is valid, and to provide feedback to the user
     * on how to increase the strength of their password.
     *
     * This endpoint adapts to your Project's password strength configuration. If you're using
     * [zxcvbn](https://stytch.com/docs/guides/passwords/strength-policy), the default, your passwords are considered valid if
     * the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/guides/passwords/strength-policy), your
     * passwords are considered valid if they meet the requirements that you've set with Stytch. You may update your password
     * strength configuration in the [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     *
     *
     * ### Password feedback
     *
     * The `feedback` object contains relevant fields for you to relay feedback to users that failed to create a strong enough
     * password.
     *
     * If you're using zxcvbn, the `feedback` object will contain `warning` and `suggestions` for any password that does not
     * meet the zxcvbn strength requirements. You can return these strings directly to the user to help them craft a strong
     * password.
     *
     * If you're using LUDS, the `feedback` object will contain an object named `luds_requirements` which contain a collection
     * of fields that the user failed or passed. You'll want to prompt the user to create a password that meets all of the
     * requirements that they failed.
     */
    public fun strengthCheckCompletable(data: StrengthCheckRequest): CompletableFuture<StytchResult<StrengthCheckResponse>>

    /**
     * Adds an existing password to a User's email that doesn't have a password yet. We support migrating users from passwords
     * stored with `bcrypt`, `scrypt`, `argon2`, `MD-5`, `SHA-1`, or `PBKDF2`. This endpoint has a rate limit of 100 requests
     * per second.
     */
    public suspend fun migrate(data: MigrateRequest): StytchResult<MigrateResponse>

    /**
     * Adds an existing password to a User's email that doesn't have a password yet. We support migrating users from passwords
     * stored with `bcrypt`, `scrypt`, `argon2`, `MD-5`, `SHA-1`, or `PBKDF2`. This endpoint has a rate limit of 100 requests
     * per second.
     */
    public fun migrate(data: MigrateRequest, callback: (StytchResult<MigrateResponse>) -> Unit)

    /**
     * Adds an existing password to a User's email that doesn't have a password yet. We support migrating users from passwords
     * stored with `bcrypt`, `scrypt`, `argon2`, `MD-5`, `SHA-1`, or `PBKDF2`. This endpoint has a rate limit of 100 requests
     * per second.
     */
    public fun migrateCompletable(data: MigrateRequest): CompletableFuture<StytchResult<MigrateResponse>>
}

internal class PasswordsImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Passwords {

    private val moshi = Moshi.Builder().build()

    override val email: Email = EmailImpl(httpClient, coroutineScope)
    override val existingPassword: ExistingPassword = ExistingPasswordImpl(httpClient, coroutineScope)
    override val sessions: Sessions = SessionsImpl(httpClient, coroutineScope)

    override suspend fun create(data: CreateRequest): StytchResult<CreateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(CreateRequest::class.java).toJson(data)
        httpClient.post("/v1/passwords", asJson)
    }

    override fun create(data: CreateRequest, callback: (StytchResult<CreateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(create(data))
        }
    }

    override fun createCompletable(data: CreateRequest): CompletableFuture<StytchResult<CreateResponse>> =
        coroutineScope.async {
            create(data)
        }.asCompletableFuture()
    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/passwords/authenticate", asJson)
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
    override suspend fun strengthCheck(data: StrengthCheckRequest): StytchResult<StrengthCheckResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(StrengthCheckRequest::class.java).toJson(data)
        httpClient.post("/v1/passwords/strength_check", asJson)
    }

    override fun strengthCheck(data: StrengthCheckRequest, callback: (StytchResult<StrengthCheckResponse>) -> Unit) {
        coroutineScope.launch {
            callback(strengthCheck(data))
        }
    }

    override fun strengthCheckCompletable(data: StrengthCheckRequest): CompletableFuture<StytchResult<StrengthCheckResponse>> =
        coroutineScope.async {
            strengthCheck(data)
        }.asCompletableFuture()
    override suspend fun migrate(data: MigrateRequest): StytchResult<MigrateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(MigrateRequest::class.java).toJson(data)
        httpClient.post("/v1/passwords/migrate", asJson)
    }

    override fun migrate(data: MigrateRequest, callback: (StytchResult<MigrateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(migrate(data))
        }
    }

    override fun migrateCompletable(data: MigrateRequest): CompletableFuture<StytchResult<MigrateResponse>> =
        coroutineScope.async {
            migrate(data)
        }.asCompletableFuture()
}
