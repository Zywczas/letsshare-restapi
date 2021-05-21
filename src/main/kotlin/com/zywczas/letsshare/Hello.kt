package com.zywczas.letsshare

import com.fasterxml.jackson.annotation.JsonProperty

data class Hello(
        @JsonProperty("message") val message: String
)