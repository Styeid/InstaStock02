package com.jufaja.instastock11.models

data class DataPost (
    var datum: Long = 0,
    var fund: String = "",
    var party: Long = 0,
    var partyvalue: Long = 0,
    var totalvalue: Long = 0,
    var plbyterm: Long = 0,
    var plfromotg: Long = 0,
    var cebyterm: Long = 0,
    var cefromorg: Long = 0,
    var alvalue: Long = 0,
    var albyterm: Long = 0,
    var alfrromorg: Long = 0,
    var percentagex: Long = 0,
    var percentagey: Long = 0,
    var user: User? = null
)