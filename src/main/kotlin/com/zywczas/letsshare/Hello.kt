package com.zywczas.letsshare

import com.fasterxml.jackson.annotation.JsonProperty

data class Hello(
        @JsonProperty val message: String
)