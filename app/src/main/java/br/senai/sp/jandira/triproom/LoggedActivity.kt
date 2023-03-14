package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class LoggedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun loggedScreen(){
    Card() {
        Image(
            painter = painterResource(id = R.drawable.paris),
            contentDescription = "Paris",
            modifier = Modifier.height(100.dp)
        )
    }
}

