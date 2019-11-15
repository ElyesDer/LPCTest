package com.lakooz.lpctest.model

import androidx.room.Entity
import java.util.*

@Entity
data class Pot(
    val identifier: String,
    val name: String,
    // TODO : add missing fields : DONE
    val creatuibDate: Date,
    val category: Pot.Category,
    val contributorsCount : Int,
    val amount: Float,
val imageUrl : String
) {


    companion object Category{
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }
}