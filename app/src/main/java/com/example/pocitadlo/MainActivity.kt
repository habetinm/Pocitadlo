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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

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

    val jeSude = count % 2 == 0

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Počet kliknutí", modifier = Modifier.padding(bottom = 20.dp)
        )

        Spacer(
            modifier = Modifier.fillMaxWidth().height(8.dp).background(Color.Yellow)
        )

        Text(
            text = count.toString(), fontSize = 48.sp
            //text = count.toString(), modifier = Modifier.background(Color.Yellow).padding(20.dp)
        )

        Text(text = popis, fontSize = 24.sp)
        Text(text = "Absolutní hodnota: $absolutniHodnota")
        Text(
            fontSize = 24.sp,
            text = if (jeSude) "Sudé číslo" else "Liché číslo"
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        CounterButtons(
            modifier = Modifier.padding(horizontal = 50.dp),
            onIncrement = {
                count = count + 1
            },
            onDecrement = {
                count = count - 1
            }
        )

        ResetButton(
            modifier = Modifier.padding(top = 20.dp),
            onReset = {
                count = 0
            }
        )
/*
        Button(
            //modifier = Modifier.fillMaxWidth(),
            onClick = {
                count = 0
            }
        ) {
            Text("Reset")
        }
 */

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("A", modifier = Modifier.align(Alignment.TopStart))
            Text("B")
            Text("C", modifier = Modifier.align(Alignment.BottomEnd))
        }
    }
}

@Composable
fun CounterButtons(
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(0.8f), horizontalArrangement = Arrangement.spacedBy(8.dp)
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

@Composable
fun ResetButton(
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().background(Color.LightGray), Arrangement.Center
    ) {
        Button(
            modifier = modifier,
            onClick = {
                onReset()
            }
        ) {
            Text("Reset")
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