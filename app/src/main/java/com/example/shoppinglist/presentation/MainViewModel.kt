package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepoImpl
import com.example.shoppinglist.domain.DeleteShopItemUseCase
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val repo = ShopListRepoImpl
    private val getShopListUseCase = GetShopListUseCase(repo)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repo)
    private val editShopItemUseCase = EditShopItemUseCase(repo)

    private val _shopList = getShopListUseCase.execute()
    val shopList: StateFlow<List<ShopItem>> get() =  _shopList

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.execute(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.execute(newItem)
    }
}