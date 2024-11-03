package com.example.parcial.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcial.R
import com.example.parcial.ui.components.BotonClick
import com.example.parcial.ui.theme.BackgroundScreens

@Composable
fun AppDrawer(
    onDismiss: () -> Unit,
    onOptionClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundScreens)
    ) {
        Spacer(modifier = Modifier.height(90.dp))

        // Imagen de perfil
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.profile_img), // Placeholder de imagen
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.Gray, shape = CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "👋 Hola Mariana Belén", style = MaterialTheme.typography.titleSmall, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))

        // Opciones del Drawer
        val options = listOf("Mis datos", "Mi CVU", "Configuración", "Ayuda", "Términos y condiciones", "Cerrar sesión")
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOptionClick(option) }
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                BotonClick(texto = option)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Modo oscuro toggle
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BotonClick(texto = "Dark Mode")
        }
    }
}