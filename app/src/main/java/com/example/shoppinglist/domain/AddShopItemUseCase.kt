package com.example.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun execute(shopItem: ShopItem) {
        shopListRepo.addShopItem(shopItem)
    }
}