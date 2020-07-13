package com.example.domain.wish

import java.util.*

data class Wish(
    var id: String = "",
    var title: String = "",
    var like: Int = 0,
    var datecreate: Date = Date(),
    var description: String = ""
)