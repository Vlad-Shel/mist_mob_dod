package com.example.mob_dod_mist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mob_dod_mist.ui.theme.Mob_dod_mistTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.CardDefaults




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mob_dod_mistTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("api") { ApiScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
            composable("custom") { CustomScreen(navController) }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally // Для центрирования элементов
    ) {
        // Логотип
        androidx.compose.foundation.Image(
            painter = androidx.compose.ui.res.painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier
        )

        // Приветственный текст
        Text(
            text = "Вітаємо в нашому мобільному додатку!",

            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center // Центрирование текста
        )

        // Кнопка "Перейти до API"
        androidx.compose.material3.Button(
            onClick = { navController.navigate("api") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Розклад")
        }

        // Кнопка "Перейти до профілю"
        androidx.compose.material3.Button(
            onClick = { navController.navigate("profile") },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Перейти до профілю")
        }

        // Кнопка "Перейти до Custom"
        androidx.compose.material3.Button(
            onClick = { navController.navigate("custom") },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Відкрити список задач")
        }
    }
}


@Composable
fun ApiScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Текст "Список данных"
        Text(
            text = "Розклад на сьогодні",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Выравнивание по центру
                .padding(bottom = 8.dp)
        )

        // Имитация ListView
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(listOf("МІСТ", "ІАД", "ІАД", "ФШІ")) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }

        // Кнопка "Назад на головну"
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Назад на головну")
        }
    }
}


@Composable
fun ProfileScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Фото профиля
        Image(
            painter = painterResource(id = R.drawable.foto_studenta),
            contentDescription = stringResource(id = R.string.profile_photo_description),
            modifier = Modifier
                .width(160.dp)
                .height(200.dp)
                .padding(bottom = 16.dp)
        )

        // Имя студента
        Text(
            text = stringResource(id = R.string.profile_name),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

        // Группа студента
        Text(
            text = stringResource(id = R.string.profile_group),
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

        // Описание профиля
        Text(
            text = stringResource(id = R.string.profile_description),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        // Кнопка "Назад на головну"
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Назад на головну")
        }
    }
}



@Composable
fun CustomScreen(navController: NavHostController) {
    val taskList = remember { mutableStateListOf<String>() }
    var newTask by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "To-Do List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Поле ввода
        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("Нова задача") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Кнопка для добавления задачи
        Button(
            onClick = {
                if (newTask.isNotBlank()) {
                    taskList.add(newTask)
                    newTask = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Додати")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Список задач
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(taskList) { task ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = task,
                            modifier = Modifier.weight(1f),
                            fontSize = 18.sp
                        )
                        Button(
                            onClick = { taskList.remove(task) },
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(text = "Видалити")
                        }
                    }
                }
            }
        }

        // Кнопка "Назад на головну"
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Назад на головну")
        }
    }
}