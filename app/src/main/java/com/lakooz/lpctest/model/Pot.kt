package com.lakooz.lpctest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lakooz.lpctest.database.DateConverter
import java.util.*

@Entity
data class Pot(
    @PrimaryKey val identifier: String,
    @ColumnInfo val name: String,
    // TODO : add missing fields : DONE
    @TypeConverters(DateConverter::class)
    val creationDate: Date,
    val category: Int,
    val contributorsCount: Int,
    val amount: Float,
    val imageUrl: String
) {


    companion object {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }

}