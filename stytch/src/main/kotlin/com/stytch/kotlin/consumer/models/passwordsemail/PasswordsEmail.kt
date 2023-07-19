package com.stytch.kotlin.consumer.models.passwordsemail

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.kotlin.consumer.models.attribute.Attributes
import com.stytch.kotlin.consumer.models.magiclinks.Options
import com.stytch.kotlin.consumer.models.sessions.Session
import com.stytch.kotlin.consumer.models.users.User

@JsonClass(generateAdapter = false)
public enum class ResetStartRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

/**
* Request type for `Email.reset`.
*/
@JsonClass(generateAdapter = true)
public data class ResetRequest(
    /**
     * The token to authenticate.
     */
    @Json(name = "token")
    val token: String,
    /**
     * The password of the user
     */
    @Json(name = "password")
    val password: String,
    /**
     * The `session_token` associated with a User's existing Session.
     */
    @Json(name = "session_token")
    val sessionToken: String? = null,
    /**
     * Set the session lifetime to be this many minutes from now. This will start a new session if one doesn't already exist,
     *   returning both an opaque `session_token` and `session_jwt` for this session. Remember that the `session_jwt` will
     * have a fixed lifetime of
     *   five minutes regardless of the underlying session duration, and will need to be refreshed over time.
     *
     *   This value must be a minimum of 5 and a maximum of 527040 minutes (366 days).
     *
     *   If a `session_token` or `session_jwt` is provided then a successful authentication will continue to extend the
     * session this many minutes.
     *
     *   If the `session_duration_minutes` parameter is not specified, a Stytch session will not be created.
     */
    @Json(name = "session_duration_minutes")
    val sessionDurationMinutes: Int? = null,
    /**
     * The `session_jwt` associated with a User's existing Session.
     */
    @Json(name = "session_jwt")
    val sessionJwt: String? = null,
    /**
     * A base64url encoded one time secret used to validate that the request starts and ends on the same device.
     */
    @Json(name = "code_verifier")
    val codeVerifier: String? = null,
    /**
     * Add a custom claims map to the Session being authenticated. Claims are only created if a Session is initialized by
     * providing a value in `session_duration_minutes`. Claims will be included on the Session object and in the JWT. To
     * update a key in an existing Session, supply a new value. To delete a key, supply a null value.
     *
     *   Custom claims made with reserved claims ("iss", "sub", "aud", "exp", "nbf", "iat", "jti") will be ignored. Total
     * custom claims size cannot exceed four kilobytes.
     */
    @Json(name = "session_custom_claims")
    val sessionCustomClaims: Map<String, Any>? = null,
    /**
     * Provided attributes help with fraud detection.
     */
    @Json(name = "attributes")
    val attributes: Attributes? = null,
    /**
     * Specify optional security settings.
     */
    @Json(name = "options")
    val options: Options? = null,
)

/**
* Response type for `Email.reset`.
*/
@JsonClass(generateAdapter = true)
public data class ResetResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The unique ID of the affected User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * A secret token for a given Stytch Session.
     */
    @Json(name = "session_token")
    val sessionToken: String,
    /**
     * The JSON Web Token (JWT) for a given Stytch Session.
     */
    @Json(name = "session_jwt")
    val sessionJwt: String,
    /**
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
    /**
     * If you initiate a Session, by including `session_duration_minutes` in your authenticate call, you'll receive a full
     * Session object in the response.
     *
     *   See [GET sessions](https://stytch.com/docs/api/session-get) for complete response fields.
     *
     */
    @Json(name = "session")
    val session: Session? = null,
)

/**
* Request type for `Email.resetStart`.
*/
@JsonClass(generateAdapter = true)
public data class ResetStartRequest(
    /**
     * The email of the User that requested the password reset.
     */
    @Json(name = "email")
    val email: String,
    /**
     * The url that the user clicks from the password reset email to finish the reset password flow.
     *   This should be a url that your app receives and parses before showing your app's reset password page.
     *   After the user submits a new password to your app, it should send an API request to complete the password reset
     * process.
     *   If this value is not passed, the default reset password redirect URL that you set in your Dashboard is used.
     *   If you have not set a default reset password redirect URL, an error is returned.
     */
    @Json(name = "reset_password_redirect_url")
    val resetPasswordRedirectURL: String? = null,
    /**
     * Set the expiration for the password reset, in minutes. By default, it expires in 30 minutes.
     *   The minimum expiration is 5 minutes and the maximum is 7 days (10080 mins).
     */
    @Json(name = "reset_password_expiration_minutes")
    val resetPasswordExpirationMinutes: Int? = null,
    /**
     * A base64url encoded SHA256 hash of a one time secret used to validate that the request starts and ends on the same
     * device.
     */
    @Json(name = "code_challenge")
    val codeChallenge: String? = null,
    /**
     * Provided attributes help with fraud detection.
     */
    @Json(name = "attributes")
    val attributes: Attributes? = null,
    /**
     * The URL Stytch redirects to after the OAuth flow is completed for a user that already exists. This URL should be a
     * route in your application which will run `oauth.authenticate` (see below) and finish the login.
     *
     *   The URL must be configured as a Login URL in the [Redirect URL page](/dashboard/redirect-urls). If the field is not
     * specified, the default Login URL will be used.
     */
    @Json(name = "login_redirect_url")
    val loginRedirectURL: String? = null,
    /**
     * Used to determine which language to use when sending the user this delivery method. Parameter is a
     * [IETF BCP 47 language tag](https://www.w3.org/International/articles/language-tags/), e.g. `"en"`.
     *
     * Currently supported languages are English (`"en"`), Spanish (`"es"`), and Brazilian Portuguese (`"pt-br"`); if no value
     * is provided, the copy defaults to English.
     *
     * Request support for additional languages
     * [here](https://docs.google.com/forms/d/e/1FAIpQLScZSpAu_m2AmLXRT3F3kap-s_mcV6UTBitYn6CdyWP0-o7YjQ/viewform?usp=sf_link")!
     *
     */
    @Json(name = "locale")
    val locale: ResetStartRequestLocale? = null,
    /**
     * Use a custom template for password reset emails. By default, it will use your default email template.
     *   The template must be a template using our built-in customizations or a custom HTML email for Passwords - Password
     * reset.
     */
    @Json(name = "reset_password_template_id")
    val resetPasswordTemplateId: String? = null,
)

/**
* Response type for `Email.resetStart`.
*/
@JsonClass(generateAdapter = true)
public data class ResetStartResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The unique ID of the affected User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * The unique ID of a specific email address.
     */
    @Json(name = "email_id")
    val emailId: String,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)
