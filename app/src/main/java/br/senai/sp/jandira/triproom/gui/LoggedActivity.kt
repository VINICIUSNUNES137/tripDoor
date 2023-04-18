package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme
import br.senai.sp.jandira.triproom.R

class LoggedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                loggedScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loggedScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Card(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "Paris",
                    modifier = Modifier.fillMaxWidth()
                )
                Column(modifier = Modifier.height(200.dp), verticalArrangement = Arrangement.SpaceBetween) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(13.dp), horizontalAlignment = Alignment.End
                    ) {
                        Card(shape = CircleShape, border = BorderStroke(2.dp, Color.White)) {
                            Image(
                                painter = painterResource(id = R.drawable.susanna_profile),
                                contentDescription = "",
                                Modifier.width(61.dp)
                            )
                        }
                        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                            Row(Modifier.fillMaxWidth()) {
                                painterResource(id = R.drawable.location_on_24)
                                Text(text = "You're in Paris", color = Color.White)
                            }
                            Text(
                                text = "My Trips",
                                color = Color.White,
                                fontWeight = FontWeight(900),
                                fontSize = 32.sp
                            )
                        }

                    }
                }
            }
        }

    }
}

