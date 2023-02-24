package com.hackathon.playtime.utils

enum class OrderByEnum(val orderType: String) {
    NameDesc("name"),
    NameAsc("-name"),
    RatingDesc("rating"),
    RatingAsc("-rating"),
    ReleasedDesc("released"),
    ReleasedAsc("-released")
}