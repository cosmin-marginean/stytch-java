package com.stytch.java.consumer.models.magiclinksemail

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.consumer.models.attribute.Attributes
import com.stytch.java.consumer.models.users.Name

@JsonClass(generateAdapter = false)
public enum class InviteRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

@JsonClass(generateAdapter = false)
public enum class LoginOrCreateRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

@JsonClass(generateAdapter = false)
public enum class SendRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

/**
* Request type for `Email.invite`.
*/
@JsonClass(generateAdapter = true)
public data class InviteRequest
    @JvmOverloads
    constructor(
        /**
         * The email address of the User to send the invite Magic Link to.
         */
        @Json(name = "email")
        val email: String,
        /**
         * Use a custom template for invite emails. By default, it will use your default email template. The template must be a
         * template using our built-in customizations or a custom HTML email for Magic links - Invite.
         */
        @Json(name = "invite_template_id")
        val inviteTemplateId: String? = null,
        /**
         * Provided attributes help with fraud detection.
         */
        @Json(name = "attributes")
        val attributes: Attributes? = null,
        /**
         * The name of the user. Each field in the name object is optional.
         */
        @Json(name = "name")
        val name: Name? = null,
        /**
         * The URL the end user clicks from the Email Magic Link. This should be a URL that your app receives and parses and
         * subsequently sends an API request to authenticate the Magic Link and log in the User. If this value is not passed, the
         * default invite redirect URL that you set in your Dashboard is used. If you have not set a default sign-up redirect URL,
         * an error is returned.
         */
        @Json(name = "invite_magic_link_url")
        val inviteMagicLinkURL: String? = null,
        /**
         * Set the expiration for the email magic link, in minutes. By default, it expires in 1 hour. The minimum expiration is 5
         * minutes and the maximum is 7 days (10080 mins).
         */
        @Json(name = "invite_expiration_minutes")
        val inviteExpirationMinutes: Int? = null,
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
        val locale: InviteRequestLocale? = null,
    )

/**
* Response type for `Email.invite`.
*/
@JsonClass(generateAdapter = true)
public data class InviteResponse
    @JvmOverloads
    constructor(
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

/**
* Request type for `Email.loginOrCreate`.
*/
@JsonClass(generateAdapter = true)
public data class LoginOrCreateRequest
    @JvmOverloads
    constructor(
        /**
         * The email address of the end user.
         */
        @Json(name = "email")
        val email: String,
        /**
         * The URL the end user clicks from the login Email Magic Link. This should be a URL that your app receives and parses and
         * subsequently send an API request to authenticate the Magic Link and log in the User. If this value is not passed, the
         * default login redirect URL that you set in your Dashboard is used. If you have not set a default login redirect URL, an
         * error is returned.
         */
        @Json(name = "login_magic_link_url")
        val loginMagicLinkURL: String? = null,
        /**
         * The URL the end user clicks from the sign-up Email Magic Link. This should be a URL that your app receives and parses
         * and subsequently send an API request to authenticate the Magic Link and sign-up the User. If this value is not passed,
         * the default sign-up redirect URL that you set in your Dashboard is used. If you have not set a default sign-up redirect
         * URL, an error is returned.
         */
        @Json(name = "signup_magic_link_url")
        val signupMagicLinkURL: String? = null,
        /**
         * Set the expiration for the login email magic link, in minutes. By default, it expires in 1 hour. The minimum expiration
         * is 5 minutes and the maximum is 7 days (10080 mins).
         */
        @Json(name = "login_expiration_minutes")
        val loginExpirationMinutes: Int? = null,
        /**
         * Set the expiration for the sign-up email magic link, in minutes. By default, it expires in 1 week. The minimum
         * expiration is 5 minutes and the maximum is 7 days (10080 mins).
         */
        @Json(name = "signup_expiration_minutes")
        val signupExpirationMinutes: Int? = null,
        /**
         * Use a custom template for login emails. By default, it will use your default email template. The template must be a
         * template using our built-in customizations or a custom HTML email for Magic links - Login.
         */
        @Json(name = "login_template_id")
        val loginTemplateId: String? = null,
        /**
         * Use a custom template for sign-up emails. By default, it will use your default email template. The template must be a
         * template using our built-in customizations or a custom HTML email for Magic links - Sign-up.
         */
        @Json(name = "signup_template_id")
        val signupTemplateId: String? = null,
        /**
         * Provided attributes help with fraud detection.
         */
        @Json(name = "attributes")
        val attributes: Attributes? = null,
        /**
         * Flag for whether or not to save a user as pending vs active in Stytch. Defaults to false.
         *         If true, users will be saved with status pending in Stytch's backend until authenticated.
         *         If false, users will be created as active. An example usage of
         *         a true flag would be to require users to verify their phone by entering the OTP code before creating
         *         an account for them.
         */
        @Json(name = "create_user_as_pending")
        val createUserAsPending: Boolean? = null,
        /**
         * A base64url encoded SHA256 hash of a one time secret used to validate that the request starts and ends on the same
         * device.
         */
        @Json(name = "code_challenge")
        val codeChallenge: String? = null,
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
        val locale: LoginOrCreateRequestLocale? = null,
    )

/**
* Response type for `Email.loginOrCreate`.
*/
@JsonClass(generateAdapter = true)
public data class LoginOrCreateResponse
    @JvmOverloads
    constructor(
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
         * In `login_or_create` endpoints, this field indicates whether or not a User was just created.
         */
        @Json(name = "user_created")
        val userCreated: Boolean,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
    )

/**
* Request type for `Email.revokeInvite`.
*/
@JsonClass(generateAdapter = true)
public data class RevokeInviteRequest
    @JvmOverloads
    constructor(
        /**
         * The email of the user.
         */
        @Json(name = "email")
        val email: String,
    )

/**
* Response type for `Email.revokeInvite`.
*/
@JsonClass(generateAdapter = true)
public data class RevokeInviteResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
    )

/**
* Request type for `Email.send`.
*/
@JsonClass(generateAdapter = true)
public data class SendRequest
    @JvmOverloads
    constructor(
        /**
         * The email address of the User to send the Magic Link to.
         */
        @Json(name = "email")
        val email: String,
        /**
         * Use a custom template for login emails. By default, it will use your default email template. The template must be a
         * template using our built-in customizations or a custom HTML email for Magic links - Login.
         */
        @Json(name = "login_template_id")
        val loginTemplateId: String? = null,
        /**
         * Provided attributes help with fraud detection.
         */
        @Json(name = "attributes")
        val attributes: Attributes? = null,
        /**
         * The URL the end user clicks from the login Email Magic Link. This should be a URL that your app receives and parses and
         * subsequently send an API request to authenticate the Magic Link and log in the User. If this value is not passed, the
         * default login redirect URL that you set in your Dashboard is used. If you have not set a default login redirect URL, an
         * error is returned.
         */
        @Json(name = "login_magic_link_url")
        val loginMagicLinkURL: String? = null,
        /**
         * The URL the end user clicks from the sign-up Email Magic Link. This should be a URL that your app receives and parses
         * and subsequently send an API request to authenticate the Magic Link and sign-up the User. If this value is not passed,
         * the default sign-up redirect URL that you set in your Dashboard is used. If you have not set a default sign-up redirect
         * URL, an error is returned.
         */
        @Json(name = "signup_magic_link_url")
        val signupMagicLinkURL: String? = null,
        /**
         * Set the expiration for the login email magic link, in minutes. By default, it expires in 1 hour. The minimum expiration
         * is 5 minutes and the maximum is 7 days (10080 mins).
         */
        @Json(name = "login_expiration_minutes")
        val loginExpirationMinutes: Int? = null,
        /**
         * Set the expiration for the sign-up email magic link, in minutes. By default, it expires in 1 week. The minimum
         * expiration is 5 minutes and the maximum is 7 days (10080 mins).
         */
        @Json(name = "signup_expiration_minutes")
        val signupExpirationMinutes: Int? = null,
        /**
         * A base64url encoded SHA256 hash of a one time secret used to validate that the request starts and ends on the same
         * device.
         */
        @Json(name = "code_challenge")
        val codeChallenge: String? = null,
        /**
         * The unique ID of a specific User.
         */
        @Json(name = "user_id")
        val userId: String? = null,
        /**
         * The `session_token` of the user to associate the email with.
         */
        @Json(name = "session_token")
        val sessionToken: String? = null,
        /**
         * The `session_jwt` of the user to associate the email with.
         */
        @Json(name = "session_jwt")
        val sessionJwt: String? = null,
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
        val locale: SendRequestLocale? = null,
        /**
         * Use a custom template for sign-up emails. By default, it will use your default email template. The template must be a
         * template using our built-in customizations or a custom HTML email for Magic links - Sign-up.
         */
        @Json(name = "signup_template_id")
        val signupTemplateId: String? = null,
    )

/**
* Response type for `Email.send`.
*/
@JsonClass(generateAdapter = true)
public data class SendResponse
    @JvmOverloads
    constructor(
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
