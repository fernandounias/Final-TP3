package com.example.parcial.screens.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.parcial.ui.theme.Green800
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial.MainNavActions
import com.example.parcial.R
import com.example.parcial.shared.infraestructure.RetrofitModule
import com.example.parcial.ui.components.ClickableLink
import com.example.parcial.ui.theme.BackgroundScreens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navigationActions : MainNavActions,
) {

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
    val coroutineScope = rememberCoroutineScope()

    var isUsernameError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    LaunchedEffect(loginResult) {
        loginResult?.let { result ->
            val message = if (result.contains("successful")) {
                navigationActions.navigateToHome()
                "Login successful!"
            } else {
                result
            }
            snackbarHostState.showSnackbar(message)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
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
                        BackgroundScreens,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(400.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.sign_f_title),
                        style = TextStyle(fontSize = 18.sp),
                        fontWeight = FontWeight.Black
                    )
                    Spacer(modifier = Modifier.height(18.dp))

                    TextField(
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    1.dp,
                                    if (isUsernameError) Color(0xFFFFA500) else Color.LightGray
                                ),
                                shape = RoundedCornerShape(3.dp)
                            )
                            .fillMaxWidth(),
                        value = username.value,
                        singleLine = true,
                        onValueChange = {
                            username.value = it
                            isUsernameError = it.isBlank()
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.sign_f_label_u),
                                color = if (isUsernameError) Color(0xFFFFA500) else Color.Gray
                            )
                        },
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
                    Spacer(modifier = Modifier.height(18.dp))

                    TextField(
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    1.dp,
                                    if (isPasswordError) Color(0xFFFFA500) else Color.LightGray
                                ),
                                shape = RoundedCornerShape(3.dp)
                            )
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth(),
                        value = password.value,
                        onValueChange = {
                            password.value = it
                            isPasswordError = it.isBlank()
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.sign_f_label_p),
                                color = if (isPasswordError) Color(0xFFFFA500) else Color.Gray
                            )
                        },
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
                    ClickableLink(text = stringResource((R.string.sign_reset_p)), align = "right", { })
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
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            isUsernameError = username.value.isBlank()
                            isPasswordError = password.value.isBlank()

                            coroutineScope.launch {
                                if (!isUsernameError && !isPasswordError) {
                                    loginViewModel.login(username.value, password.value)
                                } else {
                                    snackbarHostState.showSnackbar("Por favor complete los campos requeridos")
                                }
                            }
                        }
                    ) {
                        Text(stringResource(id = R.string.sign_in_btn))
                    }
                    SnackbarHost(
                        hostState = snackbarHostState
                    )
                }
            }
        }
    }
}