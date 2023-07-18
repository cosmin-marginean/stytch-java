package com.stytch.kotlin.consumer.api.passwordsexistingpassword

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.kotlin.common.StytchResult
import com.stytch.kotlin.consumer.models.passwordsexistingpassword.ResetRequest
import com.stytch.kotlin.consumer.models.passwordsexistingpassword.ResetResponse
import com.stytch.kotlin.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
public interface ExistingPassword {
    /**
     * Reset the User’s password using their existing password.
     */
    public suspend fun reset(data: ResetRequest): StytchResult<ResetResponse>

    /**
     * Reset the User’s password using their existing password.
     */
    public fun reset(data: ResetRequest, callback: (StytchResult<ResetResponse>) -> Unit)

    /**
     * Reset the User’s password using their existing password.
     */
    public fun resetCompletable(data: ResetRequest): CompletableFuture<StytchResult<ResetResponse>>
}

internal class ExistingPasswordImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : ExistingPassword {

    private val moshi = Moshi.Builder().build()

    override suspend fun reset(data: ResetRequest): StytchResult<ResetResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(ResetRequest::class.java).toJson(data)
        httpClient.post("/v1/passwords/existing_password/reset", asJson)
    }

    override fun reset(data: ResetRequest, callback: (StytchResult<ResetResponse>) -> Unit) {
        coroutineScope.launch {
            callback(reset(data))
        }
    }

    override fun resetCompletable(data: ResetRequest): CompletableFuture<StytchResult<ResetResponse>> =
        coroutineScope.async {
            reset(data)
        }.asCompletableFuture()
}
