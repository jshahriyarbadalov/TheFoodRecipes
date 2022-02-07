package com.shahriyar.foodrecipes.data.network

import com.shahriyar.foodrecipes.models.FoodJoke
import com.shahriyar.foodrecipes.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Query

interface FoodRecipesApi {

    @GET("/recipes/complexSearch")
   suspend fun getRecipes(
        @QueryMap queries:Map<String,String>
    ):Response<FoodRecipe>

    @GET("/recipes/complexSearch")
   suspend fun searchRecipes(
       @QueryMap searchQuery:Map<String,String>
   ):Response<FoodRecipe>

   @GET("food/jokes/random")
   suspend fun getFoodJoke(
       @Query("apiKey") apiKey:String
   ):Response<FoodJoke>
}