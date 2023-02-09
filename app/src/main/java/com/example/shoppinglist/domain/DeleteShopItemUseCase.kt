package com.example.shoppinglist.domain

class DeleteShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun execute(shopItem: ShopItem) {
        shopListRepo.deleteShopItem(shopItem)
    }
}