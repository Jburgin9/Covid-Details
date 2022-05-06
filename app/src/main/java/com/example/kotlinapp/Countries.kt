package com.example.kotlinapp

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun country(
    viewModel: MainViewModel
){
    var expanded by remember { mutableStateOf(false)}
    ExposedDropdownMenuBox(expanded = expanded,
        onExpandedChange = {expanded = !expanded}) {
        TextField(value = "",
            onValueChange = {},
        label = {Text("Countries")},
        trailingIcon = {
            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
        },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false }) {
                viewModel.state.value.forEach{
                    DropdownMenuItem(onClick = { }) {
                        Text(it)

                    }
                }
        }

    }
//    Row {
//        Text(text = name)
//    }
}