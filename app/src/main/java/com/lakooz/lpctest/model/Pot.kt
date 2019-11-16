package com.lakooz.lpctest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Pot(
    @PrimaryKey val identifier: String,
    @ColumnInfo val name: String,
    // TODO : add missing fields : DONE
    @ColumnInfo val creatuibDate: Date,
    @ColumnInfo val category: Pot.Category,
    @ColumnInfo val contributorsCount: Int,
    @ColumnInfo val amount: Float,
    @ColumnInfo val imageUrl: String
) {


    companion object Category {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }

}