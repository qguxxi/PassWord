package com.synth.password.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardTextField() {
    var text by remember { mutableStateOf("") }

    Row {

        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .width(366.dp)
                .height(70.dp)
                .background(
                    color = Color(0xFFE9E9E9), // Màu nền
                    shape = RoundedCornerShape(0.dp) // Shape của nền (có thể điều chỉnh)
                )
                .border(
                    width = 1.dp,
                    color = Color(0x4D000000), // Màu viền (4D = 30% opacity)
                    shape = RoundedCornerShape(0.dp) // Shape của viền
                )
                .padding(start = 31.dp, end = 217.dp), // Padding trái/phải
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Màu nền khi focus
                unfocusedContainerColor = Color.Transparent, // Màu nền mặc định
                focusedIndicatorColor = Color.Transparent, // Ẩn indicator mặc định
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = "Số tài khoản",
                    color = Color.Gray, // Màu placeholder

                )
            },
            singleLine = true, // Chỉ cho phép 1 dòng
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // Hiển thị nút "Done" trên bàn phím
            )
        )
    }
}

@Preview
@Composable
private fun BasicTextFieldPreview() {
    CardTextField()
}