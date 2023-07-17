package com.stytch.kotlin.b2b.models.passwordssession

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.kotlin.b2b.models.organizations.Member
import com.stytch.kotlin.b2b.models.organizations.Organization
import com.stytch.kotlin.b2b.models.sessions.MemberSession

/**
* Request type for `Sessions.reset`.
*/
@JsonClass(generateAdapter = true)
public data class ResetRequest(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * The password to authenticate.
     */
    @Json(name = "password")
    val password: String,
    /**
     * A secret token for a given Stytch Session.
     */
    @Json(name = "session_token")
    val sessionToken: String? = null,
    /**
     * The JSON Web Token (JWT) for a given Stytch Session.
     */
    @Json(name = "session_jwt")
    val sessionJwt: String? = null,
)

/**
* Response type for `Sessions.reset`.
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
     * Globally unique UUID that identifies a specific Member.
     */
    @Json(name = "member_id")
    val memberId: String,
    /**
     * The [Member object](https://stytch.com/docs/b2b/api/member-object).
     */
    @Json(name = "member")
    val member: Member,
    /**
     * The [Organization object](https://stytch.com/docs/b2b/api/organization-object).
     */
    @Json(name = "organization")
    val organization: Organization,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
    /**
     * The [Session object](https://stytch.com/docs/b2b/api/session-object).
     */
    @Json(name = "member_session")
    val memberSession: MemberSession? = null,
)