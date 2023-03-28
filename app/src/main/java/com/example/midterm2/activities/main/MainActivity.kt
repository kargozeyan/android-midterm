package com.example.midterm2.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midterm2.model.User
import com.example.midterm2.ui.theme.CardBackground
import com.example.midterm2.ui.theme.CardTextGrey
import com.example.midterm2.ui.theme.Midterm2Theme
import com.example.midterm2.ui.theme.TopBarBackground

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadUsers()
        setContent {
            Midterm2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UserList(users = viewModel.users.observeAsState().value!!)
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .background(TopBarBackground)
            .fillMaxWidth()
            .padding(24.dp),
    ) {
        Text(
            text = "Users",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 32.sp
        )
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        item {
            TopBar()
        }
        items(users) {
            UserItem(user = it)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(72.dp),
        backgroundColor = CardBackground,
        elevation = 0.dp
    ) {
        Box(Modifier.padding(8.dp)) {
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = "${user.name.first} ${user.name.last}",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier.align(Alignment.BottomStart),
                text = user.email,
                color = CardTextGrey
            )
            Text(
                modifier = Modifier.align(Alignment.TopEnd),
                text = user.nationality,
                color = CardTextGrey
            )
        }
    }
}

