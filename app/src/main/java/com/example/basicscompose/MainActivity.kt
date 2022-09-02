package com.example.basicscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscompose.ui.theme.BasicsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded=remember{ mutableStateOf(false)}
    val expanded1=remember{ mutableStateOf(false)}

    val extraPadding=if(expanded.value) 48.dp else 0.dp

    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Surface(color = MaterialTheme.colors.primary,
        modifier=Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Row(modifier=Modifier
                .padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {
                    Text("Hello ,")
                    Text(name)
                }
                OutlinedButton(onClick = { expanded.value=!expanded.value }) {
                    Text(if(expanded.value) "Show Less" else "Show More")
                }
            }
        }
        Surface(color = MaterialTheme.colors.primary,
            modifier=Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Row (modifier=Modifier
                .padding(24.dp)){
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {
                    Text("Hello ,")
                    Text("compose")
                }
                OutlinedButton(onClick = { expanded1.value=!expanded1.value }) {
                    Text(if(expanded1.value) "Show Less" else "Show More")
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsComposeTheme {
        Greeting("Android")
    }
}