package com.synth.password.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.synth.password.R
import com.synth.password.data.local.Account
import com.synth.password.navigation.PassWordDestinations
import com.synth.password.ui.components.CustomTextField
import com.synth.password.ui.viewmodel.AccountViewModel

@Composable
fun AddScreen(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var account by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(24.dp)
            ) {
                Icon(ImageVector.vectorResource(R.drawable.close), null)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                CustomTextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    label = { Text("Tiêu đề") },
                )
                Spacer(Modifier.height(32.dp))
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {}) {
                    Text(text = "Hoàn thành")
                }

            }
        }
    }
}

@Preview
@Composable
private fun AddScreenPreview() {
    AddScreen()
}