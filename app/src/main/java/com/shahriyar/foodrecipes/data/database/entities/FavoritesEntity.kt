package com.shahriyar.foodrecipes.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shahriyar.foodrecipes.util.Constants.Companion.FAVORITE_RECIPES_TABLE
import com.shahriyar.foodrecipes.models.Result

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var result: Result
)