package com.lakooz.lpctest.database

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimestamp(mills: Long?): Date? {
        // TODO : DONE

        return if (mills == null) {
            Date(mills)
        } else {
            null
        }

    }

    @TypeConverter
    fun fromDate(date: Date?) {
        // TODO

    }


}