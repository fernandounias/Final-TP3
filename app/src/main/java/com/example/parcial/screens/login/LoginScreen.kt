package com.example.parcial.screens.login

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.parcial.ui.theme.Green800
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial.MainNavActions
import com.example.parcial.R
import com.example.parcial.shared.infraestructure.Auth.AuthRepository
import com.example.parcial.shared.infraestructure.RetrofitModule
import com.example.parcial.ui.components.ClickableLink
import com.example.parcial.ui.theme.BackgroundScreens
import kotlinx.coroutines.delay

//@Preview
@Composable
fun LoginScreen(
    navigationActions : MainNavActions,
) {

//    var showPopup by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(true) }

    val authServices = RetrofitModule.authServices

    val factory = LoginViewModelFactory(authServices)
    val loginViewModel: LoginViewModel = viewModel(factory = factory)

    LaunchedEffect(Unit) {
        delay(3000)
        isVisible = true
    }
    Box(
        modifier = Modifier
            .background(Green800)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.add_login),
                contentDescription = "app banner",
                modifier = Modifier.size(width = 288.dp, height = 154.dp)
            )
        }

        LoginBox(isVisible, navigationActions, loginViewModel)
//        LoginBox(isVisible, navigationActions)
//        LoginBox(false, onLoginClick(viewModel.login(username, password)))
//        LoginBox(isVisible, viewModel)
//        LoginBox(isVisible)
        // WIP
    }
}

@Composable
fun LoginBox(
    isVisible: Boolean,
    navigationActions : MainNavActions,
    loginViewModel: LoginViewModel
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val rememberMe = remember {mutableStateOf(false)}
    val loginResult by loginViewModel.loginResult.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(loginResult) {
        Log.d("LoginBox", "is called")
        loginResult?.let { result ->
            val snackbarResult = snackbarHostState.showSnackbar(result)
            if (snackbarResult == SnackbarResult.Dismissed) {
                Log.d("snackbarR", "called: ${SnackbarResult.entries}")
            }
            if (result.contains("successful")) {
                snackbarHostState.showSnackbar("Login successful!")
//                delay(800) // Wait before navigating
                navigationActions.navigateToHome()
            } else if (result.contains("failed") || result.contains("error")) {
                snackbarHostState.showSnackbar(result)
            }
        }
    }
//    loginResult?.let { result ->
//        if (result.contains("successful")) {
//            LaunchedEffect(Unit) {
//                snackbarHostState.showSnackbar(result)
//                delay(2000)
//                // Waits 2 seconds before navigating
//                navigationActions.navigateToHome()
//            }
//        }
//    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        SnackbarHost(hostState = snackbarHostState)

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(initialOffsetY = { it / 2 }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it / 2 }) + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(
//                        Color.White,
                        BackgroundScreens,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .height(400.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.sign_f_title),
                        style = TextStyle(fontSize = 18.sp),
                        fontWeight = FontWeight.Black
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier
//                            .fillMaxSize()
//                            .height(400.dp)
                    ){
                        TextField(
                            modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, Color.LightGray),
                                    shape = RoundedCornerShape(3.dp)
                                )
                                .fillMaxWidth(),
                            value = username.value,
                            singleLine = true,
                            onValueChange = { username.value = it },
                            label = { Text(stringResource(id = R.string.sign_f_label_u)) },
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                cursorColor = Color.Black,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(8.dp),
                        )
//                        Spacer(modifier = Modifier.height(4.dp))
                        Spacer(modifier = Modifier.height(18.dp))
                        TextField(
                            modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, Color.LightGray),
                                    shape = RoundedCornerShape(3.dp)
                                )
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            value = password.value,
                            onValueChange = { password.value = it },
                            label = { Text(stringResource(id = R.string.sign_f_label_p)) },
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                cursorColor = Color.Black,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(8.dp),
                            visualTransformation = PasswordVisualTransformation()
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ){
                        ClickableLink(text = stringResource((R.string.sign_reset_p)), align = "right", { showT() })
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RoundCheckbox(
                            checked = rememberMe.value,
                            onCheckedChange = { rememberMe.value = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text((stringResource(id = R.string.sign_remember))
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    loginResult?.let { result ->
                        Text(
                            text = if (result.contains("successful", ignoreCase = true)) "Login Successful" else "Login Failed",
                            color = if (result.contains("successful", ignoreCase = true)) Color.Green else Color.Red,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            if (username.value.isNotBlank() && password.value.isNotBlank()) {
                                loginViewModel.login(username.value, password.value)
//                            navigationActions.navigateToHome()
                            } else {
                                snackbarMessage = "Por favor complete los campos"
                                Log.d("inputBtn", "pressed")
                            }
//                            onLoginClick(username.value, password.value)
//                            viewModel.login(username.value, password.value)
                        }) {
                        Text(stringResource(id = R.string.sign_in_btn))
                    }

                    /*
                        //Show login result message
                        // modify show a snackbar message
                        val loginResult = viewModel.loginResult.observeAsState()
                        loginResult.value?.let {
                            Text(text = it, modifier = Modifier.padding(top = 16.dp))
                        }
                    */
                }
            }
        }
    }
}



fun showT (){}