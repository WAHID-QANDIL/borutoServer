package com.wahid.modle

import kotlinx.serialization.Serializable
@Serializable
data class ApiResponse(
    val success:Boolean,
    val message:String?,
    val prevPage:Int? = null,
    val nextPage:Int? = null,
    val heroes:List<Hero> = emptyList(),
    val lastUpdated:Long? = null
)
