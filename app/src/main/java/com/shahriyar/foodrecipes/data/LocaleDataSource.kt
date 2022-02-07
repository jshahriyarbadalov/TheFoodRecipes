package com.shahriyar.foodrecipes.data

import com.shahriyar.foodrecipes.data.database.RecipesDao
import com.shahriyar.foodrecipes.data.database.entities.FavoritesEntity
import com.shahriyar.foodrecipes.data.database.entities.FoodJokeEntity
import com.shahriyar.foodrecipes.data.database.entities.RecipesEntity
import com.shahriyar.foodrecipes.models.FoodJoke
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocaleDataSource @Inject constructor(
    private val recipesDao: RecipesDao
){

     fun readRecipes():Flow<List<RecipesEntity>>{
        return recipesDao.readRecipes()
    }

    fun readFavoriteRecipes():Flow<List<FavoritesEntity>>{
        return recipesDao.readFavoriteRecipes()
    }

    fun readFoodJoke():Flow<List<FoodJokeEntity>>{
        return recipesDao.readFoodJoke()
    }

   suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun insertFavoriteRecipes(favoritesEntity: FavoritesEntity){
        recipesDao.insertFavoriteRecipe(favoritesEntity)
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity){
        recipesDao.insertFoodJoke(foodJokeEntity)
    }

    suspend fun deleteFavoriteRecipes(favoritesEntity: FavoritesEntity){
        recipesDao.deleteFavoriteRecipe(favoritesEntity)
    }

    suspend fun  deleteAllFavoriteRecipes(){
        recipesDao.deleteAllFavoriteRecipes()
    }
}