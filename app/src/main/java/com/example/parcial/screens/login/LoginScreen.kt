package com.example.parcial.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.parcial.ui.theme.Green800
import androidx.compose.ui.unit.dp
import com.example.parcial.R
import com.example.parcial.MainNavActions
import com.example.parcial.shared.BottomNavBar

@Preview
@Composable
fun LoginScreen() {
    var showPopup by remember { mutableStateOf(false) }
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

        // WIP
//        if(showPopup){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
//                    .padding(16.dp)
                    .height(500.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
            ){
                Text("login popup box!", modifier = Modifier.align(Alignment.Center))
                Button(
                    onClick = { showPopup = false },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(0.5.dp)
                ) { Text("X") }
            }
//        }
    }
}
