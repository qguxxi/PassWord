package com.synth.password.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.synth.password.R

@Composable
fun CardDecor() {
    Image(painter = painterResource(id = R.drawable.frame_1321318040), contentDescription = "")
}

@Preview
@Composable
private fun CardDecorPreview() {
    CardDecor()
}