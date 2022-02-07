package com.shahriyar.foodrecipes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shahriyar.foodrecipes.databinding.RecipesRowLayoutBinding
import com.shahriyar.foodrecipes.models.FoodRecipe
import com.shahriyar.foodrecipes.models.Result
import com.shahriyar.foodrecipes.util.RecipesDiffUtil

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {

    private var recipes= emptyList<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        return RecipesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val currentRecipe=recipes[position]
        holder.bind(currentRecipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun setData(newData:FoodRecipe){
        val recipesDiffUtil=RecipesDiffUtil(recipes, newData.results)
        val diffUtilResult=DiffUtil.calculateDiff(recipesDiffUtil)
        recipes=newData.results
        diffUtilResult.dispatchUpdatesTo(this)
    }

    class RecipesViewHolder(private val binding: RecipesRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
          fun bind(result:Result){
              binding.result=result
              binding.executePendingBindings()
          }
        companion object{
            fun from(parent: ViewGroup): RecipesViewHolder{
                val layoutInflater=LayoutInflater.from(parent.context)
                val binding=RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return RecipesViewHolder(binding)
            }
        }
    }
}