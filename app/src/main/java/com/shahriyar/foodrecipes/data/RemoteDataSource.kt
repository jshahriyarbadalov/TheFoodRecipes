package com.shahriyar.foodrecipes.data

import com.shahriyar.foodrecipes.data.network.FoodRecipesApi
import com.shahriyar.foodrecipes.models.FoodJoke
import com.shahriyar.foodrecipes.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
){
   suspend fun getRecipes(queries: Map<String, String>):Response<FoodRecipe>{
       return foodRecipesApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery:Map<String, String>):Response<FoodRecipe>{
        return foodRecipesApi.searchRecipes(searchQuery)
    }

    suspend fun getFoodJoke(apiKey:String):Response<FoodJoke>{
        return foodRecipesApi.getFoodJoke(apiKey)
    }
}
