package com.example.shoppinglist.domain

import kotlinx.coroutines.flow.StateFlow

class GetShopListUseCase(private val shopListRepo: ShopListRepo) {
    fun execute(): StateFlow<List<ShopItem>> {
        return shopListRepo.getShopList()
    }
}