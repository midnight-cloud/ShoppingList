package com.example.shoppinglist.domain

import kotlinx.coroutines.flow.StateFlow

interface ShopListRepo {
    fun getShopList(): StateFlow<List<ShopItem>>
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
}