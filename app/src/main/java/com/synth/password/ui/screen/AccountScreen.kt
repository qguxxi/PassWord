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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.password.R
import com.synth.password.data.local.Account
import com.synth.password.navigation.PassWordDestinations
import com.synth.password.ui.components.CustomTextField
import com.synth.password.ui.viewmodel.AccountViewModel
import java.util.UUID

@Composable
fun AccountScreen(navController: NavController, modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var account by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(366.dp)
                        .height(194.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            ImageVector.vectorResource(R.drawable.communication),
                            null,
                            tint = androidx.compose.ui.graphics.Color.Unspecified,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        CustomTextField(
                            value = account,
                            onValueChange = { newAccount ->
                                account = newAccount
                            },
                            label = { Text("Tài khoản hoặc địa chỉ email") },
                            modifier = Modifier.padding(24.dp)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            ImageVector.vectorResource(R.drawable.key),
                            null,
                            modifier = Modifier.padding(start = 16.dp),
                            tint = androidx.compose.ui.graphics.Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        CustomTextField(
                            value = password,
                            onValueChange = { newPassword ->
                                password = newPassword
                            },
                            label = { Text("Mật khẩu") },
                            modifier = Modifier.padding(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "Mật khẩu sau khi mã hóa được lưu dưới dạng sha-256",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {
                    navController.navigate(PassWordDestinations.Main.route) // Navigate back to HomeScreen
                }) {
                    Text(text = "Hoàn thành")
                }
            }
        }
    }
}


@Preview
@Composable
private fun AccountScreenPreview() {
    AccountScreen(navController = rememberNavController())
}