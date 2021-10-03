package com.simdamsi.zenith.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
//@TypeConverters(ListStringConverter::class)
class Mountain {
    @PrimaryKey
    @NonNull
    var id: String? = null
    var name: String? = null
    var altitude: Double? = null
    var massif: String? = null
    var coords: String? = null
    var pays: String? = null
    var province: String? = null
}