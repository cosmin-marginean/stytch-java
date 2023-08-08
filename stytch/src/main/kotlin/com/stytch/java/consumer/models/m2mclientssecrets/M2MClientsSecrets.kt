package com.stytch.java.consumer.models.m2mclientssecrets

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.consumer.models.m2m.M2MClient
import com.stytch.java.consumer.models.m2m.M2MClientWithNextClientSecret

/**
* Request type for `Secrets.rotateCancel`.
*/
@JsonClass(generateAdapter = true)
public data class RotateCancelRequest @JvmOverloads constructor(
    /**
     * The ID of the client.
     */
    @Json(name = "client_id")
    val clientId: String,
)

/**
* Response type for `Secrets.rotateCancel`.
*/
@JsonClass(generateAdapter = true)
public data class RotateCancelResponse @JvmOverloads constructor(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The M2M Client affected by this operation.
     */
    @Json(name = "m2m_client")
    val m2mClient: M2MClient,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Secrets.rotate`.
*/
@JsonClass(generateAdapter = true)
public data class RotateRequest @JvmOverloads constructor(
    /**
     * The ID of the client.
     */
    @Json(name = "client_id")
    val clientId: String,
)

/**
* Response type for `Secrets.rotate`.
*/
@JsonClass(generateAdapter = true)
public data class RotateResponse @JvmOverloads constructor(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The M2M Client affected by this operation.
     */
    @Json(name = "m2m_client")
    val m2mClient: M2MClient,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Secrets.rotateStart`.
*/
@JsonClass(generateAdapter = true)
public data class RotateStartRequest @JvmOverloads constructor(
    /**
     * The ID of the client.
     */
    @Json(name = "client_id")
    val clientId: String,
)

/**
* Response type for `Secrets.rotateStart`.
*/
@JsonClass(generateAdapter = true)
public data class RotateStartResponse @JvmOverloads constructor(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The M2M Client affected by this operation.
     */
    @Json(name = "m2m_client")
    val m2mClient: M2MClientWithNextClientSecret,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)
