package com.lenibonje.habari.data.db

import androidx.room.TypeConverter
import com.lenibonje.habari.data.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String):  Source{
        return Source(name, name)
    }

}