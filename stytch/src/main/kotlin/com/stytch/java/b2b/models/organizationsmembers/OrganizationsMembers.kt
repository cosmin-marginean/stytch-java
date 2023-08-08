package com.stytch.java.b2b.models.organizationsmembers

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.b2b.models.organizations.Member
import com.stytch.java.b2b.models.organizations.Organization
import com.stytch.java.b2b.models.organizations.ResultsMetadata
import com.stytch.java.b2b.models.organizations.SearchQuery

/**
* Request type for `Members.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateRequest @JvmOverloads constructor(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * The email address of the Member.
     */
    @Json(name = "email_address")
    val emailAddress: String,
    /**
     * The name of the Member.
     */
    @Json(name = "name")
    val name: String? = null,
    /**
     * An arbitrary JSON object for storing application-specific data or identity-provider-specific data.
     */
    @Json(name = "trusted_metadata")
    val trustedMetadata: Map<String, Any>? = null,
    /**
     * An arbitrary JSON object of application-specific data. These fields can be edited directly by the
     *   frontend SDK, and should not be used to store critical information. See the
     * [Metadata resource](https://stytch.com/docs/b2b/api/metadata)
     *   for complete field behavior details.
     */
    @Json(name = "untrusted_metadata")
    val untrustedMetadata: Map<String, Any>? = null,
    /**
     * Flag for whether or not to save a Member as `pending` or `active` in Stytch. It defaults to false. If true, new Members
     * will be created with status `pending` in Stytch's backend. Their status will remain `pending` and they will continue to
     * receive signup email templates for every Email Magic Link until that Member authenticates and becomes `active`. If
     * false, new Members will be created with status `active`.
     */
    @Json(name = "create_member_as_pending")
    val createMemberAsPending: Boolean? = null,
    /**
     * Identifies the Member as a break glass user - someone who has permissions to authenticate into an Organization by
     * bypassing the Organization's settings. A break glass account is typically used for emergency purposes to gain access
     * outside of normal authentication procedures. Refer to the [Organization object](organization-object) and its
     * `auth_methods` and `allowed_auth_methods` fields for more details.
     */
    @Json(name = "is_breakglass")
    val isBreakglass: Boolean? = null,
    /**
     * (Coming Soon) The Member's phone number. A Member may only have one phone number.
     */
    @Json(name = "mfa_phone_number")
    val mfaPhoneNumber: String? = null,
    /**
     * (Coming Soon) Sets whether the Member is enrolled in MFA. If true, the Member must complete an MFA step whenever they
     * wish to log in to their Organization. If false, the Member only needs to complete an MFA step if the Organization's MFA
     * policy is set to `REQUIRED_FOR_ALL`.
     */
    @Json(name = "mfa_enrolled")
    val mfaEnrolled: Boolean? = null,
)

/**
* Response type for `Members.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateResponse @JvmOverloads constructor(
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
)

/**
* Request type for `Members.deleteMFAPhoneNumber`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteMFAPhoneNumberRequest @JvmOverloads constructor(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * Globally unique UUID that identifies a specific Member. The `member_id` is critical to perform operations on a Member,
     * so be sure to preserve this value.
     */
    @Json(name = "member_id")
    val memberId: String,
)

/**
* Response type for `Members.deleteMFAPhoneNumber`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteMFAPhoneNumberResponse @JvmOverloads constructor(
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
)

/**
* Request type for `Members.deletePassword`.
*/
@JsonClass(generateAdapter = true)
public data class DeletePasswordRequest @JvmOverloads constructor(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * Globally unique UUID that identifies a Member's password.
     */
    @Json(name = "member_password_id")
    val memberPasswordId: String,
)

/**
* Response type for `Members.deletePassword`.
*/
@JsonClass(generateAdapter = true)
public data class DeletePasswordResponse @JvmOverloads constructor(
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
)

/**
* Request type for `Members.delete`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteRequest @JvmOverloads constructor(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * Globally unique UUID that identifies a specific Member. The `member_id` is critical to perform operations on a Member,
     * so be sure to preserve this value.
     */
    @Json(name = "member_id")
    val memberId: String,
)

/**
* Response type for `Members.delete`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteResponse @JvmOverloads constructor(
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
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Members.get`.
*/
@JsonClass(generateAdapter = true)
public data class GetRequest @JvmOverloads constructor(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * Globally unique UUID that identifies a specific Member. The `member_id` is critical to perform operations on a Member,
     * so be sure to preserve this value.
     */
    @Json(name = "member_id")
    val memberId: String? = null,
    /**
     * The email address of the Member.
     */
    @Json(name = "email_address")
    val emailAddress: String? = null,
)

/**
* Response type for `Members.get`.
*/
@JsonClass(generateAdapter = true)
public data class GetResponse @JvmOverloads constructor(
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
)

/**
* Request type for `Members.search`.
*/
@JsonClass(generateAdapter = true)
public data class SearchRequest @JvmOverloads constructor(
    /**
     * An array of organization_ids. At least one value is required.
     */
    @Json(name = "organization_ids")
    val organizationIds: List<String>,
    /**
     * The `cursor` field allows you to paginate through your results. Each result array is limited to 1000 results. If your
     * query returns more than 1000 results, you will need to paginate the responses using the `cursor`. If you receive a
     * response that includes a non-null `next_cursor` in the `results_metadata` object, repeat the search call with the
     * `next_cursor` value set to the `cursor` field to retrieve the next page of results. Continue to make search calls until
     * the `next_cursor` in the response is null.
     */
    @Json(name = "cursor")
    val cursor: String? = null,
    /**
     * The number of search results to return per page. The default limit is 100. A maximum of 1000 results can be returned by
     * a single search request. If the total size of your result set is greater than one page size, you must paginate the
     * response. See the `cursor` field.
     */
    @Json(name = "limit")
    val limit: Long? = null,
    /**
     * The optional query object contains the operator, i.e. `AND` or `OR`, and the operands that will filter your results.
     * Only an operator is required. If you include no operands, no filtering will be applied. If you include no query object,
     * it will return all Members with no filtering applied.
     */
    @Json(name = "query")
    val query: SearchQuery? = null,
)

/**
* Response type for `Members.search`.
*/
@JsonClass(generateAdapter = true)
public data class SearchResponse @JvmOverloads constructor(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * An array of [Member objects](member-object).
     */
    @Json(name = "members")
    val members: List<Member>,
    /**
     * The search `results_metadata` object contains metadata relevant to your specific query like `total` and `next_cursor`.
     */
    @Json(name = "results_metadata")
    val resultsMetadata: ResultsMetadata,
    /**
     * A map from `organization_id` to [Organization object](https://stytch.com/docs/b2b/api/organization-object). The map
     * only contains the Organizations that the Members belongs to.
     */
    @Json(name = "organizations")
    val organizations: Map<String, Organization>,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Members.update`.
*/
@JsonClass(generateAdapter = true)
public data class UpdateRequest @JvmOverloads constructor(
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * Globally unique UUID that identifies a specific Member. The `member_id` is critical to perform operations on a Member,
     * so be sure to preserve this value.
     */
    @Json(name = "member_id")
    val memberId: String,
    /**
     * The name of the Member.
     */
    @Json(name = "name")
    val name: String? = null,
    /**
     * An arbitrary JSON object for storing application-specific data or identity-provider-specific data.
     */
    @Json(name = "trusted_metadata")
    val trustedMetadata: Map<String, Any>? = null,
    /**
     * An arbitrary JSON object of application-specific data. These fields can be edited directly by the
     *   frontend SDK, and should not be used to store critical information. See the
     * [Metadata resource](https://stytch.com/docs/b2b/api/metadata)
     *   for complete field behavior details.
     */
    @Json(name = "untrusted_metadata")
    val untrustedMetadata: Map<String, Any>? = null,
    /**
     * Identifies the Member as a break glass user - someone who has permissions to authenticate into an Organization by
     * bypassing the Organization's settings. A break glass account is typically used for emergency purposes to gain access
     * outside of normal authentication procedures. Refer to the [Organization object](organization-object) and its
     * `auth_methods` and `allowed_auth_methods` fields for more details.
     */
    @Json(name = "is_breakglass")
    val isBreakglass: Boolean? = null,
    /**
     * (Coming Soon) Sets the Member's phone number. Throws an error if the Member already has a phone number. To change the
     * Member's phone number, use the
     * [Delete member phone number endpoint](https://stytch.com/docs/b2b/api/delete-member-mfa-phone-number) to delete the
     * Member's existing phone number first.
     */
    @Json(name = "mfa_phone_number")
    val mfaPhoneNumber: String? = null,
    /**
     * (Coming Soon) Sets whether the Member is enrolled in MFA. If true, the Member must complete an MFA step whenever they
     * wish to log in to their Organization. If false, the Member only needs to complete an MFA step if the Organization's MFA
     * policy is set to `REQUIRED_FOR_ALL`.
     */
    @Json(name = "mfa_enrolled")
    val mfaEnrolled: Boolean? = null,
)

/**
* Response type for `Members.update`.
*/
@JsonClass(generateAdapter = true)
public data class UpdateResponse @JvmOverloads constructor(
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
)
