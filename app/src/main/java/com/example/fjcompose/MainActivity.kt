package com.example.fjcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fjcompose.ui.theme.FJComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FJComposeTheme {

            }
        }
    }
}


@Composable
fun Button(){
    Box(
        modifier = Modifier
            .padding(all = 10.dp)
            .width(250.dp)
            .height(60.dp)
            .background(color = Color(0xFFeebbc3)),
        contentAlignment = Alignment.Center
    ){
        Text(
            "Click",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 32.sp,
                color = Color(0xFF232946)
            )
        )
    }
}

@Composable
fun Logo(){
    Box(
        modifier = Modifier
            .padding(bottom = 100.dp)
            .width(250.dp)
            .height(250.dp)
            .background(color = Color(0xFFb8c1ec)),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "To Do List",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 50.sp,
                color = Color(0xFF232946)
            )
        )
    }
}

@Composable
fun StartUpScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF232946)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()
        Button()
    }
}

@Composable
fun MainScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF232946))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        ListDisplay(listOf<String>("hey","Lol"))
//        ListCreate()
//        ListHolder(title = "Test", content = "Test")
    }
}

@Composable
fun AddButton(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            modifier = Modifier
                .padding(40.dp)
                .width(60.dp)
                .height(60.dp)
                .border(border = BorderStroke(2.dp, color = Color(0xFF121629))),
            colors = buttonColors(Color(0xFFeebbc3)),
            onClick = { },
        )
        {

        }
    }


}

@Composable
fun ListHolder(title: String, content: String){
    Column(
        modifier = Modifier
            .padding(25.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color(0xFFeebbc3))
                .border(border = BorderStroke(2.dp, color = Color(0xFF121629))),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(5.dp)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color(0xFFfffffe))
                .border(border = BorderStroke(2.dp, color = Color(0xFF121629))),
        contentAlignment = Alignment.TopStart
        )
        {
            Text(
                text = content,
                style = TextStyle(
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(5.dp)
            )
        }
    }

}

@Composable
fun ListDisplay(data_list : List<String>){
    val dummy = listOf<ListData>(
        ListData("Homework","uhh Chemistry"),
        ListData("Homework2","uhh calc"),
        ListData("Homework3","uhh cse"),
    )


    Column(
        modifier = Modifier.fillMaxSize()
    )
    {
//        data_list.forEach{each ->
//            ListHolder(title = "test", content = each)
//        }
        dummy.forEach {
            ListHolder(title = it.title, content = it.content)
        }
        AddButton()
    }
}

@Composable
fun ListCreate(){
    Column(
        modifier = Modifier
            .padding(25.dp)
    ) {
        var title by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }

        TextField(value = "Title...", onValueChange = {
            title = it
        })
        TextField(value = "Content...", onValueChange = {
            content = it
        })
        Button(
            onClick = {

            }
        ) {
            Text("Added")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FJComposeTheme {
        MainScreen()
    }
}

data class ListData(var title: String, var content: String){

}