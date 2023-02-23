package com.example.shoppinglist.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.presentation.MainViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val shopList = viewModel.shopList.collectAsState().value
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {
            items(shopList) { item ->
                ShopItemElement(item = item, navController = navController, viewModel = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShopItemElement(item: ShopItem, navController: NavController, viewModel: MainViewModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), modifier = Modifier
            .alpha(if (item.isEnabled) 1f else 0.5f)
            .padding(top = 4.dp, bottom = 4.dp)
            .combinedClickable(
                onClick = {
                    viewModel.changeEnableState(item)
                },
                onLongClick = {
                    viewModel.deleteShopItem(item)
                },
            ),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = item.name,
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.count.toString(),
                modifier = Modifier.padding(end = 16.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}