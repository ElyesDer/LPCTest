package com.lakooz.lpctest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.lakooz.lpctest.database.DateConverter

@Entity
data class Pot(
    @SerializedName("id")
    @PrimaryKey val identifier: String,
    @ColumnInfo val name: String,
    // TODO : add missing fields : DONE
    @TypeConverters(DateConverter::class)
    val creationDate: String?,
    val category: Int?,
    val contributorsCount: Int?,
    val amount: Float?,
    val imageUrl: String?
) {

    companion object {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }

}