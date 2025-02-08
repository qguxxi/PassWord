package com.synth.password.until

import android.content.Context
import android.content.SharedPreferences
import java.util.UUID

object AccountIdManager {
    private const val PREFS_NAME = "account_prefs"
    private const val KEY_ACCOUNT_ID = "account_id"

    fun getAccountId(context: Context): String {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        var accountId = prefs.getString(KEY_ACCOUNT_ID, null)
        if (accountId == null) {
            accountId = UUID.randomUUID().toString()
            prefs.edit().putString(KEY_ACCOUNT_ID, accountId).apply()
        }
        return accountId
    }
}