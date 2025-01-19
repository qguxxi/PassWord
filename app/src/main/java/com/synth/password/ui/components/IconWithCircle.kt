package com.synth.password.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconWithCircle(iconVector: ImageVector,modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(42.dp) // Kích thước tổng của vòng tròn
            .background(color = Color(0xFFD9D9D9), shape = CircleShape)
    ) {
        Icon(
            imageVector = iconVector, // Thay đổi bằng icon bạn muốn
            contentDescription = "Icon with Circle",
            tint = Color.Unspecified,
            modifier = modifier // Kích thước icon
        )
    }
}
