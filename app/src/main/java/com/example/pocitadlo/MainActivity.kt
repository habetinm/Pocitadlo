package com.example.pocitadlo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pocitadlo.ui.theme.PocitadloTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height

import android.app.Activity
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocitadloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterScreen(modifier: Modifier = Modifier) {

    var count by remember {
        mutableStateOf(0)
    }

    val popis = when {
        count > 0 -> "Kladné číslo"
        count < 0 -> "Záporné číslo"
        else -> "Nula"
    }

    val absolutniHodnota = if (count < 0) {
        -count
    } else {
        count
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Počet kliknutí"
        )

        Text(
            text = count.toString()
        )

        Text(text = popis)
        Text(text = "Absolutní hodnota: $absolutniHodnota")


        CounterButtons(
            onIncrement = {
                count = count + 1
            },
            onDecrement = {
                count = count - 1
            }
        )


        Button(
            //modifier = Modifier.fillMaxWidth(),
            onClick = {
                count = 0
            }
        ) {
            Text("Reset")
        }
    }
}

@Composable
fun CounterButtons(
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Button(
            modifier = Modifier.weight(1f),
            onClick = {
                onDecrement()
            }
        ) {
            Text("-1")
        }

        Button(
            modifier = Modifier.weight(1f),
            onClick = {
                onIncrement()
            }
        ) {
            Text("+1")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    PocitadloTheme {
        CounterScreen()
    }
}