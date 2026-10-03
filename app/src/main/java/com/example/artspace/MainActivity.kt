package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ========== SECTION 1 : MUR D'ŒUVRES D'ART ==========
        Surface(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(vertical = 24.dp)
                .shadow(8.dp),
            color = Color.White
        ) {
            Image(
                painter = painterResource(id = R.drawable.artwork),
                contentDescription = "Œuvre d'art",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentScale = ContentScale.Fit
            )
        }

        // ========== SECTION 2 : DESCRIPTEUR DE L'ŒUVRE ==========
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Still Life with Flowers",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Vincent van Gogh (1886)",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        // ========== SECTION 3 : CONTRÔLEUR D'AFFICHAGE ==========
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* action précédent */ }) {
                Text("Précédent")
            }
            Button(onClick = { /* action suivant */ }) {
                Text("Suivant")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}