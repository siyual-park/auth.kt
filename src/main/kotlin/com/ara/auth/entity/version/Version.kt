package com.ara.auth.entity.version

interface Version {
    val major: String?
    val minor: String?
    val patch: String?
    val commit: String?
}
