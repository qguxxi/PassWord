package com.synth.password.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synth.password.ui.components.IconWithCircle
import com.synth.password.ui.theme.smallTypo
import com.synth.password.R

@Composable
fun AddBottomSheet() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            Button(
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconWithCircle(iconVector = ImageVector.vectorResource(id = R.drawable.user_def),Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(24.dp))
                    Column {
                        Text(text = "Đăng nhập", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Lưu thông tin cho tài khoản đăng nhập cho các ứng dụng khác", style = smallTypo)
                    }
                }
            }
            Button(
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconWithCircle(iconVector = ImageVector.vectorResource(id = R.drawable.card_def),Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(24.dp))
                    Column {
                        Text(text = "Thẻ ngân hàng", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Lưu thông tin thẻ ngân hàng", style = smallTypo)
                    }
                }
            }
            Button(
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconWithCircle(iconVector = ImageVector.vectorResource(id = R.drawable.padlock_def),Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(24.dp))
                    Column {
                        Text(text = "Tạo mật khẩu", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Tự động tạo mật khẩu có mật khẩu mạnh", style = smallTypo)
                    }
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun AddBottomSheetPreview() {
    AddBottomSheet()
}