package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun execute(shopItemId: Int): ShopItem {
        return shopListRepo.getShopItem(shopItemId)
    }
}