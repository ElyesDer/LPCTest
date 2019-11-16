package com.lakooz.lpctest.database

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimestamp(mills: Long?): Date? {
        // TODO : DONE
        return if (mills == null) null else Date(mills)
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        // TODO ??
        return date?.time
    }


}