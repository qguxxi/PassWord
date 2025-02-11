package com.synth.password.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.synth.password.R
import com.synth.password.data.local.AppDatabase
import com.synth.password.repository.AccountRepository
import com.synth.password.repository.UserRepository
import com.synth.password.ui.viewmodel.AccountViewModel
import kotlinx.coroutines.launch

data class BottomNavigationItem(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    val items = listOf(
        BottomNavigationItem(
            "home",
            ImageVector.vectorResource(R.drawable.home__1__1),
            ImageVector.vectorResource(R.drawable.home_def)
        ) ,
        BottomNavigationItem(
            "add",
            ImageVector.vectorResource(R.drawable.add),
            ImageVector.vectorResource(R.drawable.add_def)
        ) ,
        BottomNavigationItem(
            "profile",
            ImageVector.vectorResource(R.drawable.profile),
            ImageVector.vectorResource(R.drawable.profile_def)
        )
    )

    BottomSheetScaffold(
        sheetContainerColor = Color.White,
        scaffoldState = scaffoldState,
//            Triển khai Bottom Sheet tại đây
        sheetContent = { AddBottomSheet(navController) },
        sheetPeekHeight = 0.dp
    ) {
        Scaffold(
            bottomBar = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NavigationBar(
                        tonalElevation = 7.dp,
                        modifier = Modifier
                            .navigationBarsPadding()
                            .padding(bottom = 8.dp)
                            .clip(shape = RoundedCornerShape(30.dp))
                            .background(
                                color = MaterialTheme.colorScheme.surfaceContainer,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .height(64.dp)
                            .width(300.dp)
                    ) {
                        items.forEachIndexed { index, item ->
                            val isSelected = selectedIndex == index
                            NavigationBarItem(
                                label = null,
                                enabled = selectedIndex != index,
                                selected = isSelected,
                                onClick = {
                                    selectedIndex = index
                                    if (item.route == "add") {
                                        scope.launch {
                                            scaffoldState.bottomSheetState.expand()
                                        }
                                    }
                                },
                                alwaysShowLabel = false,
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.route,
                                        tint = Color.Unspecified
                                    )
                                },
                                interactionSource = remember { MutableInteractionSource() }, // Disable ripple effect
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.Transparent // Remove selection indicator if needed
                                )
                            )
                        }
                    }
                }
            }
        ) {
            ContentScreen(
                navController = navController,
                index = selectedIndex,
                modifier = modifier.padding(it)
            )
        }
    }
}


@Composable
fun ContentScreen(navController: NavController, index: Int, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val appDatabase = AppDatabase.getInstance(context)
    val userDao = appDatabase.userDao()
    when (index) {
        0 -> HomeScreen()
        1 -> AddScreen()
        2 -> ProfileScreen()
    }
}