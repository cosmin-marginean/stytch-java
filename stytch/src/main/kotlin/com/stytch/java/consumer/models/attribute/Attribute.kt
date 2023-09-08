package com.stytch.java.consumer.models.attribute

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class Attributes
    @JvmOverloads
    constructor(
        /**
         * The IP address of the user.
         */
        @Json(name = "ip_address")
        val ipAddress: String? = null,
        /**
         * The user agent of the User.
         */
        @Json(name = "user_agent")
        val userAgent: String? = null,
    )
