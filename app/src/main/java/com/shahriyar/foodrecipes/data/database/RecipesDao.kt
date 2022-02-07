package com.shahriyar.foodrecipes.data.database

import androidx.room.*
import com.shahriyar.foodrecipes.data.database.entities.FavoritesEntity
import com.shahriyar.foodrecipes.data.database.entities.FoodJokeEntity
import com.shahriyar.foodrecipes.data.database.entities.RecipesEntity
import com.shahriyar.foodrecipes.models.FoodJoke
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Dao
interface RecipesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteRecipe(favoriteEntity:FavoritesEntity)

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity)

    @Query("SELECT*FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Query("SELECT*FROM favorite_recipes_table ORDER BY id ASC")
    fun readFavoriteRecipes():Flow<List<FavoritesEntity>>

    @Query("SELECT*FROM food_joke_table ORDER BY id ASC")
    fun readFoodJoke():Flow<List<FoodJokeEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoriteEntity: FavoritesEntity)

    @Query("DELETE FROM favorite_recipes_table")
    suspend fun deleteAllFavoriteRecipes()
}