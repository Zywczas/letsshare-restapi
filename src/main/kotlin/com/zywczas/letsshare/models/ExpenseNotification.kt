package com.zywczas.letsshare.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseNotification(
        @JsonProperty val ownerName: String,
        @JsonProperty val groupName: String,
        @JsonProperty val receiversIds: List<String>
)