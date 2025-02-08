package com.synth.password.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardTextField(icon: Int,textPlaceHolder: String,text: String,modifier: Modifier,onTextChange: (String) -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Center,
        modifier = modifier.width(366.dp)
            .height(70.dp)
            .background(
                color = Color(0xFFE9E9E9),
                shape = RoundedCornerShape(0.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0x4D000000),
                shape = RoundedCornerShape(0.dp)
            )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(20.dp)
            )   
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .padding(horizontal = 16.dp), // Giảm padding để có đủ không gian
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = textPlaceHolder,
                    color = Color.Gray
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
    }
}


@Preview
@Composable
private fun BasicTextFieldPreview() {

}