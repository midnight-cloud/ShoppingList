package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun execute(shopItem: ShopItem) {
        shopListRepo.editShopItem(shopItem)
    }
}