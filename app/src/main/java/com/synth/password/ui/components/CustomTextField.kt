package com.synth.password.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String,onValueChange: (String) -> Unit,label: @Composable () -> Unit,modifier : Modifier = Modifier) {
        TextField(
            value = value ,
            onValueChange =  { newValue ->
                onValueChange(newValue)}  ,
            singleLine = true ,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // Hiển thị nút "Done" trên bàn phím
            ) ,
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ) ,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,  // Không có gạch chân khi focus
                unfocusedIndicatorColor = Color.Transparent, // Không có gạch chân khi không focus
                disabledIndicatorColor = Color.Transparent // Không có gạch chân khi bị disable
            ),
            shape = RoundedCornerShape(10.dp) ,
            label = label ,
            modifier = Modifier
                .width(366.dp)
                .height(72.dp)
                .background(Color(0xFFE9E9E9), shape = RoundedCornerShape(10.dp)) ,
        )
}

@Preview
@Composable
private fun CustomTextField() {
    CustomTextField(value = "ds", onValueChange = {} , label = { /*TODO*/ })
}