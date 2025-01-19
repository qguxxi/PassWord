package com.synth.password.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun EmailTextField(email: String,onEmailChange:(String)-> Unit,modifier: Modifier = Modifier) {
    Text(text = "Email", style = MaterialTheme.typography.titleMedium)
    BasicTextField(
        value = email,
        onValueChange = { onEmailChange(it) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        singleLine = true,
        textStyle = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    )
    HorizontalDivider(color = MaterialTheme.colorScheme.primary, thickness = 2.dp)
}
