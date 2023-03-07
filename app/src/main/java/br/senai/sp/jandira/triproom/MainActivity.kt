package br.senai.sp.jandira.triproom

import android.graphics.fonts.FontFamily
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.Shapes
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme{
                TripRoomScreen()
            }
         }
    }
}
@Preview
@Composable
fun TripRoomScreen(){
    
    Surface(modifier =  Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp), horizontalArrangement = Arrangement.End) {

            Card(
                modifier = Modifier
                    .height(height = 40.dp)
                    .width(width = 120.dp),
                backgroundColor = Color(207, 6, 240),
                shape = RoundedCornerShape(bottomStart = 12.dp )
                ) {

            }

    }
            //Spacer(modifier = Modifier.height(200.dp))
            Column(modifier = Modifier
                .height(500.dp)
                .padding(start = 16.dp)) { // column pai dos texts
                

            Column(modifier = Modifier.padding(bottom = 64.dp)) {
                Text(text = "Login", fontSize = 64.sp, fontWeight = FontWeight(800),color = Color(207, 6, 240))
                Text(text = "Please sign in to continue.", fontSize = 16.sp, fontWeight = FontWeight(400),color = Color(160, 156, 156))
            }
        //}
            Column() {
        OutlinedTextField(
            value = "",
            shape = RoundedCornerShape(16.dp),
            onValueChange ={},
            label = { Text(text = "E-mail")},
            leadingIcon = { Icon(
            painter = painterResource(id = R.drawable.mail),
            contentDescription = "Email",
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp),
            )} )
                OutlinedTextField(
                    value = "",
                    shape = RoundedCornerShape(16.dp),
                    onValueChange ={},
                    label = { Text(text = "Password")},
                    leadingIcon = { Icon(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = "Lock",
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                    )} )
                Button(
                modifier = Modifier
                    .width(150.dp)
                    .height(64.dp),
                    onClick = {},
                    shape = RoundedCornerShape(24.dp),


                ) {
            }

            Column() {

            }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom) {

                Card(
                    modifier = Modifier
                        .height(height = 40.dp)
                        .width(width = 120.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RoundedCornerShape(topEnd = 12.dp )
                ) {
//aaaaaaaa
                }

            }
        }

    }
}
