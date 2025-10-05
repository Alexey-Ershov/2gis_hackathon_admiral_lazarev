package com.larkes.neurobuildermultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform