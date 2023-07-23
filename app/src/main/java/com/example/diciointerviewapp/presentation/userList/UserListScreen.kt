package com.example.diciointerviewapp.presentation.userList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.diciointerviewapp.data.remote.responses.User

@Composable
fun UserListScreen(
    navController: NavController
){
    Column {
        TopAppBar(
            title = { Text(text = "Lista de usuarios") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Rounded.ArrowBack, "")
                }
            },
            backgroundColor = MaterialTheme.colors.onPrimary
        )
        SearchBar(
            hint = "Nombre...",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {}
        UserList()
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused
                }
        )
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}


@Composable
fun UserList(
    viewModel : UserListViewModel = hiltViewModel()

) {
    val userList by remember {
        viewModel.userList
    }

        viewModel.getUsers()
        LazyColumn(
            modifier = Modifier.padding(6.dp)
        ) {
            items(userList.size) {
                UserEntry(entry = userList[it] as User)
            }
        }

}


@Composable
fun UserEntry(
    entry: User,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            entry.nombre.replaceFirstChar {
                it.uppercase()
            },
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
        Text(
            entry.apellidoPaterno.replaceFirstChar {
                it.uppercase()
            },
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
        Text(
            entry.apellidoMaterno.replaceFirstChar {
                it.uppercase()
            },
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
        Text(
            entry.edad.toString(),
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
        Text(
            entry.email,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
        Text(
            entry.fechaNac,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
    }
}