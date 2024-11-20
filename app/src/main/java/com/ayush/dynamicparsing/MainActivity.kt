package com.ayush.dynamicparsing

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.ayush.dynamicparsing.ui.theme.DynamicParsingTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val httpClient = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
        val jsonObjectEndpoint = "https://openlibrary.org/works/OL82563W.json"
        val stringEndpoint = "https://openlibrary.org/works/OL1968368W.json"

        lifecycleScope.launch {
            listOf(
                stringEndpoint,
                jsonObjectEndpoint
            ).forEach { endpoint ->
                val response = httpClient.get(
                    urlString = endpoint
                )

                val dto = response.body<BookWorkDto>()
                Log.d("desc", "Book description is ${dto.description}")
            }
        }

        setContent {
            DynamicParsingTheme {

            }
        }
    }
}