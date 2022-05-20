package tech.taoofcoding.mobile.androidApp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Text
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WelcomeView("你好，myddd")
            }
        }
    }


    @Composable
    fun WelcomeView(text: String) {
        Text(
            text = text,
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.caption
        )

    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun previewWelcome() {
        MaterialTheme {
            WelcomeView("这是Jetpack Compose")
        }
    }
}