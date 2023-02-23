package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepoImpl
import com.example.shoppinglist.domain.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: ShopListRepoImpl) : ViewModel() {

    private val getShopListUseCase = GetShopListUseCase(repo)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repo)
    private val editShopItemUseCase = EditShopItemUseCase(repo)
    private val addShopItemUseCase = AddShopItemUseCase(repo)

    private val _shopList = getShopListUseCase.execute()
    val shopList: StateFlow<List<ShopItem>> get() =  _shopList


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.execute(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.execute(newItem)
    }

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.execute(shopItem)
    }

}