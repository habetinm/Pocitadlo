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
import androidx.compose.ui.Alignment

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

    Row (modifier = modifier.padding(1.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {//padding(1.dp)) {
            Text(
                text = "Počet kliknutí 1: ",
                //modifier = modifier
            )

            Text(
                text = count.toString()
            )
/**/
            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.LightGray)
                    .height(150.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {
                        count = count + 1
                    }
                ) {
                    Text("+1")
                }

                Button(
                    onClick = {
                        count = count - 1
                    }
                ) {
                    Text("-1")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.LightGray)
                    .height(150.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        count = count + 10
                    }
                ) {
                    Text("+10")
                }

                Button(
                    onClick = {
                        count = count - 10
                    }
                ) {
                    Text("-10")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.LightGray)
                    .height(150.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        count = 0
                    }
                ) {
                    Text("0")
                }
            }

 /**/
        }

        Column(modifier = Modifier.weight(1f)) {//padding(1.dp)) {
            Text(
                text = "Počet kliknutí 2: ",
                //modifier = modifier
            )

            Text(
                text = count.toString()
            )
/**/
            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.LightGray)
                    .height(150.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {
                        count = count + 1
                    }
                ) {
                    Text("+1")
                }

                Button(
                    onClick = {
                        count = count - 1
                    }
                ) {
                    Text("-1")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.LightGray)
                    .height(150.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        count = count + 10
                    }
                ) {
                    Text("+10")
                }

                Button(
                    onClick = {
                        count = count - 10
                    }
                ) {
                    Text("-10")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.LightGray)
                    .height(150.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        count = 0
                    }
                ) {
                    Text("0")
                }
            }

 /**/
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