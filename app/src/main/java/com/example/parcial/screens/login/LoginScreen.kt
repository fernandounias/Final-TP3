package com.example.parcial.screens.login

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
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

    val snackbarHostState = remember { SnackbarHostState() }

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

        LoginBox(
            isVisible,
            navigationActions,
            loginViewModel,
            snackbarHostState
        )
    }
}

@Composable
fun LoginBox(
    isVisible: Boolean,
    navigationActions : MainNavActions,
    loginViewModel: LoginViewModel,
    snackbarHostState: SnackbarHostState
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val rememberMe = remember {mutableStateOf(false)}

    val loginResult by loginViewModel.loginResult.collectAsState()
//    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    val snackbarCompleteFieldsMessage = stringResource(id = R.string.snackbar_complete_fields)
    val snackbarForgotPasword = stringResource(id = R.string.snackbar_forgot_pasword)
    val snackbarLoginSuccessMessage = stringResource(id = R.string.snackbar_forgot_pasword)

    var isUsernameError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    ///Checks if the username & password should be pre-filled
    val sharedPreferences = LocalContext.current.getSharedPreferences("login_preferences", Context.MODE_PRIVATE)
    val savedUsername = sharedPreferences.getString("username", "")
    val savedPassword = sharedPreferences.getString("password", "")

    // Prefill values if available
    if (savedUsername != null && savedUsername.isNotEmpty()) {
        username.value = savedUsername
        rememberMe.value = true
    }
    if (savedPassword != null && savedPassword.isNotEmpty()) {
        password.value = savedPassword
    }

    LaunchedEffect(loginResult) {
        loginResult?.let { result ->
            val message = if (result.contains("successful")) {
                ///saves username and password when remember checkbox is checked
                if (rememberMe.value) {
                    sharedPreferences.edit()
                        .putString("username", username.value)
                        .putString("password", password.value)
                        .apply()
                }
                navigationActions.navigateToHome()
                snackbarLoginSuccessMessage
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
                    UsernameTextField(
                        value = username.value,
                        onValueChange = {
                            username.value = it
                            isUsernameError = it.isBlank()
                        },
                        label = stringResource(id = R.string.sign_f_label_u),
                        isUsernameError
                    )

                    Spacer(modifier = Modifier.height(18.dp))
                    PasswordTextField(
                        value = password.value,
                        onValueChange = {
                            password.value = it
                            isPasswordError = it.isBlank()
                        },
                        label = stringResource(id = R.string.sign_f_label_p),
                        isPasswordError
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ){
                        ClickableLink(
                            text = stringResource((R.string.sign_reset_p)),
                            align = "right",
                            message = snackbarForgotPasword,
                            snackbarHostState
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RoundCheckbox(
                            checked = rememberMe.value,
                            onCheckedChange = { isChecked ->
                                rememberMe.value = isChecked
                                /// Save or remove username & password based on the checkbox state
                                if (isChecked) {
                                    sharedPreferences.edit()
                                        .putString("username", username.value)
                                        .putString("password", password.value)
                                        .apply()
                                } else {
                                    sharedPreferences.edit()
                                        .remove("username")
                                        .remove("password")
                                        .apply()
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Text((stringResource(id = R.string.sign_remember))
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            isUsernameError = username.value.isBlank()
                            isPasswordError = password.value.isBlank()

                            coroutineScope.launch {
                                if(username.value.isBlank() || password.value.isBlank()){
                                    snackbarHostState.showSnackbar(message = snackbarCompleteFieldsMessage)
                                }else if (username.value.isNotBlank() && password.value.isNotBlank()) {
                                    loginViewModel.login(username.value, password.value)
                                }
                            }
                        }
                    ) {
                        Text(stringResource(id = R.string.sign_in_btn))
                    }
//                    SnackbarHost(
//                        hostState = snackbarHostState
//                    )
                }
            }
        }
    }
}