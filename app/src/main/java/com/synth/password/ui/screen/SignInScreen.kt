package com.synth.password.ui.screen

import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.synth.password.ui.components.SignInButton
import com.synth.password.ui.theme.signInTypo
import com.synth.password.ui.viewmodel.SignInViewModel
import com.synth.password.R
import com.synth.password.ViewModelFactory
import com.synth.password.navigation.PassWordDestinations
import com.synth.password.ui.components.EmailTextField
import com.synth.password.ui.components.PassWordTextField
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    viewModelFactory: ViewModelFactory,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val signInViewModel: SignInViewModel = viewModel(factory = viewModelFactory)
    val keyboardController = LocalSoftwareKeyboardController.current
    var password by remember { mutableStateOf("") }
    var gmail by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures {
                // Ẩn bàn phím khi nhấn ra ngoài
                keyboardController?.hide()
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.primary,
                style = signInTypo ,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(48.dp))
            EmailTextField(email = gmail, onEmailChange = { gmail = it })
            Spacer(modifier = Modifier.height(48.dp))
            PassWordTextField("Mật khẩu", password = password, onPasswordChange = { password = it })
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Text(text = "Bạn chưa có tài khoản?", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Đăng kí ngay",
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary),
                    modifier = Modifier.pointerInput(Unit) {
                        detectTapGestures {
                            // Điều hướng đến màn hình sign up
                            navController.navigate(PassWordDestinations.SignUp.route)
                        }
                    }
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            SignInButton(
                title = "Đăng nhập",
                onClick = {
                    signInViewModel.viewModelScope.launch {
                        if (signInViewModel.loginUser(gmail = gmail, password = password))
                            navController.navigate(PassWordDestinations.Main.route) {
                                popUpTo(PassWordDestinations.SignIn.route) {
                                    inclusive = true
                                }
                            }
                        else Toast.makeText(
                            context,
                            "Bạn đã điền thông tin sai",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
            )

        }
    }
}
