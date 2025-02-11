package com.synth.password.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.synth.password.R
import com.synth.password.ui.theme.mediumTypo
import com.synth.password.ui.viewmodel.AccountViewModel

@Composable
fun HomeScreen() {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "PassLock",
                    style = mediumTypo,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "", modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Text(
                text = "Frequently Used",
                style = mediumTypo,
                modifier = Modifier.padding(start = 16.dp)
            )
            
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {

}