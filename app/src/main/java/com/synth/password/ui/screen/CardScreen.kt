package com.synth.password.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.password.R
import com.synth.password.navigation.PassWordDestinations
import com.synth.password.ui.components.CardTextField
import com.synth.password.ui.components.CustomTextField

@Composable
fun CardScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var bankAccountNumber by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var calendar by remember { mutableStateOf("") }
    var secure by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            IconButton(
                onClick = {
                    navController.navigate(PassWordDestinations.Main.route)
                },
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
                CardTextField(
                    R.drawable.user__2__1,
                    "Họ và tên",
                    name,
                    modifier = Modifier
                ) { newNumber ->
                    name = newNumber
                }
                Spacer(modifier = Modifier.height(12.dp))
                CardTextField(
                    R.drawable.key,
                    "Mật khẩu",
                    password,
                    modifier = Modifier
                ) { newPassword ->
                    password = newPassword
                }
                Spacer(modifier = Modifier.height(12.dp))
                CardTextField(
                    R.drawable.card,
                    "Số tài khoản",
                    bankAccountNumber,
                    modifier = Modifier
                ) { newNumber ->
                    bankAccountNumber = newNumber
                }
                Spacer(modifier = Modifier.height(12.dp))
                CardTextField(
                    R.drawable.calendar,
                    "Ngày hết hạn",
                    calendar,
                    modifier = Modifier
                ) { newDater ->
                    calendar = newDater
                }
                Spacer(modifier = Modifier.height(12.dp))
                CardTextField(
                    R.drawable.secure_1,
                    "Mã bảo mật",
                    secure,
                    modifier = Modifier
                ) { newNumber ->
                    secure = newNumber
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {

                }) {
                    Text(text = "Hoàn thành")
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardScreenPreview() {
    CardScreen(navController = rememberNavController())
}