package com.example.onlineshop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class NotificationItem(
    val title: String,
    val message: String,
    val type: NotificationType,
    val timestamp: Date = Date()
) : Parcelable

enum class NotificationType {
    ORDER_SUCCESS, INFO
}