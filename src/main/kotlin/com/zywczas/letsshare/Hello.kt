package com.zywczas.letsshare

import com.fasterxml.jackson.annotation.JsonProperty

class Hello(
        @JsonProperty("message") message: String
)