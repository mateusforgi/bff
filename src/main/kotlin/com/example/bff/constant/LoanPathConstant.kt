package com.example.bff.constant

// GENERAL
const val CPF = "cpf"
private const val CPF_PLACEHOLDER = "{$CPF}"

// BFF
const val LOAN_ENDPOINT = "/loan"
const val GET_TIMELINE_ENDPOINT_BFF = "/$LOAN_ENDPOINT/timeline/$CPF_PLACEHOLDER"

// TIMELINE API
const val GET_TIMELINE = "/timeline/$CPF_PLACEHOLDER"
const val API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
