package com.synth.password.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.synth.password.ui.components.EmailTextField
import com.synth.password.ui.components.PassWordTextField
import com.synth.password.ui.components.SignInButton
import com.synth.password.ui.viewmodel.SignUpViewModel
import com.synth.password.ViewModelFactory
import com.synth.password.data.User
import com.synth.password.navigation.PassWordDestinations

@Composable
fun SignUpScreen(
    viewModelFactory: ViewModelFactory,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val signUpViewModel: SignUpViewModel = viewModel(factory = viewModelFactory)
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(48.dp)
    ) {
        Text(
            text = "Đăng kí tài khoản",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(24.dp))
        EmailTextField(email = email, onEmailChange = { email = it })
        Spacer(modifier = Modifier.height(24.dp))
        PassWordTextField("Mật khẩu", password = password, onPasswordChange = { password = it })
        Spacer(modifier = Modifier.height(24.dp))
        PassWordTextField(
            "Nhập lại mật khẩu",
            password = passwordConfirm,
            onPasswordChange = { passwordConfirm = it })
        Spacer(modifier = Modifier.weight(1f))
        SignInButton(title = "Tiếp tục", onClick = {
            if (password != passwordConfirm) {
                Toast.makeText(
                    context,
                    "Mật khẩu xác nhận chưa trùng khớp",
                    Toast.LENGTH_LONG
                ).show()
            }
            else {
                Toast.makeText(context,"Bạn đã đăng kí thành công",Toast.LENGTH_SHORT).show()
                signUpViewModel.registerUser(User(gmail = email, password = password))
                navController.navigate(PassWordDestinations.SignIn.route)
            }
        })
    }
}