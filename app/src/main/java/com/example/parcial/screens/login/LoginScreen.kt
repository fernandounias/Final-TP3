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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
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
import com.example.parcial.MainNavActions
import com.example.parcial.R
import com.example.parcial.ui.components.ClickableLink
import com.example.parcial.ui.theme.BackgroundScreens

//@Preview
@Composable
fun LoginScreen(navigationActions : MainNavActions) {
//fun LoginScreen(viewModel: LoginViewModel) {
//    var showPopup by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
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

        LoginBox(isVisible, navigationActions)
//        LoginBox(false, onLoginClick(viewModel.login(username, password)))
//        LoginBox(isVisible, viewModel)
//        LoginBox(isVisible)
        // WIP
    }
}

@Composable
fun LoginBox(
    isVisible: Boolean,
//    viewModel: LoginViewModel
//    onLoginClick: (String, String) -> Unit
    navigationActions : MainNavActions
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val rememberMe = remember {mutableStateOf(false)}
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
//                    verticalArrangement = Arrangement.Center,
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
                            onValueChange = { username.value = it },
                            label = { Text(stringResource(id = R.string.sign_f_label_u)) },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                cursorColor = Color.Black,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                //
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,
                                focusedLabelColor = Color.Gray,
                                unfocusedLabelColor = Color.Black
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
                                .fillMaxWidth(),
                            value = password.value,
                            onValueChange = { password.value = it },
                            label = { Text(stringResource(id = R.string.sign_f_label_p)) },
                            colors = TextFieldDefaults.colors(
//                                focusedContainerColor = Color.White,
//                                unfocusedContainerColor = Color.White,
                                cursorColor = Color.Black,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                //
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedLabelColor = Color.Gray,
                                unfocusedLabelColor = Color.Black
                            ),
                            shape = RoundedCornerShape(8.dp),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
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
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            navigationActions.navigateToHome()
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

fun onLoginClick(username: String, passowrd : String) {

}

//@Preview
@Composable
fun RoundCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    var isFocused by remember { mutableStateOf(false) }
//    var checked = true
//    fun onCheckedChange(checked: Boolean){}

    Box(
        modifier = Modifier
            .focusable()
            .onFocusChanged { focusState -> isFocused = focusState.isFocused }
            .clickable { onCheckedChange(!checked) }
            .size(30.dp) // Size of the round checkbox
            .background(
                if (checked) Color.Transparent else Color.White,
                shape = CircleShape
            )
            .border(
                 2.dp,
                when {
                    checked -> Color.Transparent
                    isFocused -> Color.Transparent
                    else -> Color.Gray
                     },
                shape = CircleShape
            ),
//            .clip(CircleShape), // Makes the box round
//            .background(if (checked) Color(0xFF00D563) else Color.Gray), // Checked color
        contentAlignment = Alignment.Center,
    ){
        if (checked) {
            FocusableCheckedIcon(iconFocus = R.drawable.checkbox_checked, iconChecked = R.drawable.checkbox_unchecked, null)
        }
    }
}

@Composable
fun FocusableCheckedIcon(iconFocus: Int, iconChecked: Int, iconDefault: Int? ) {
    var isChecked by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .focusable()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .clickable { isChecked = !isChecked } // Toggle checked state
    ) {
        val iconId = when {
            isChecked && isFocused -> iconChecked
            isChecked -> iconChecked
            isFocused -> iconChecked
            else -> null // Default icon
        }

        iconId?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

fun showT (){}