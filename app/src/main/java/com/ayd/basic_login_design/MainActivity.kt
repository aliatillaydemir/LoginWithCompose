package com.ayd.basic_login_design

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ayd.basic_login_design.ui.theme.Basic_Login_designTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Basic_Login_designTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page() {
    Surface(color = MaterialTheme.colors.secondaryVariant) {

        val username = remember{
            mutableStateOf("")
        }

        val password = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription =" ")

            TextField(
                value = username.value,
                onValueChange = {username.value = it},
                label = { Text(text = "User name")},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )

            TextField(
                value = password.value,
                onValueChange = {password.value = it},
                label = { Text(text = "password")},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )

            Button(onClick = { Log.e("Button", "Click me!") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
                modifier = Modifier.size(215.dp,45.dp)
            ) {
                Text(text = "   Login   ")
            }
        }
    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Basic_Login_designTheme {
        Page()
    }
}