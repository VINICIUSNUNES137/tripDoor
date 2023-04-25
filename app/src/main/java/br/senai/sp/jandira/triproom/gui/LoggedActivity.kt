package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category
import br.senai.sp.jandira.triproom.model.Trip
import br.senai.sp.jandira.triproom.repository.CategoryRepository
import br.senai.sp.jandira.triproom.repository.TripRepository

class LoggedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pegando o conteudo da intent
//        Log.i("ds2m", "id: ${intent.extras()}")
        setContent {
            TripRoomTheme {
                loggedScreen(
                    CategoryRepository.getCategories(),
                    TripRepository.getTrips()
                )
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)


@Composable
fun loggedScreen(
    categories: List<Category>,
    trips: List<Trip>
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), shape = RectangleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "Paris",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,

                    )
                Column(
                    modifier = Modifier.height(200.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(13.dp), horizontalAlignment = Alignment.End
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {


                            Card(shape = CircleShape, border = BorderStroke(2.dp, Color.White)) {
                                Image(
                                    painter = painterResource(id = R.drawable.susanna_profile),
                                    contentDescription = "",
                                    Modifier.width(61.dp),

                                    )
                            }
                            Text(text = "Susana", color = Color.White)
                        }
                        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.location_on_24),
                                    contentDescription = ""
                                )
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
            Text(
                text = stringResource(id = R.string.categories),
                color = Color(56, 56, 54),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

            LazyRow() {
                items(categories) {
                    Card(
                        modifier = Modifier
                            .size(width = 120.dp, height = 80.dp)
                            .padding(vertical = 8.dp),
                        backgroundColor = Color.Magenta,

                        ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier.height(32.dp),
                                painter = it.categoryIcon,
                                contentDescription = it.categoryName
                            )
                            Text(text = it.categoryName, color = Color.White)
                        }

                    }
                    Spacer(modifier = Modifier.width(12.dp))

                }
            }

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(text = stringResource(id = R.string.search))
                },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                    }
                }
            )
            
            Text(
                text = "Past Trips",
                fontSize = 14.sp,
                color = Color(86,86,84),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            )
            
            LazyColumn(){
                items(trips){
                    Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        
                        Column() {
                            Image(painter = painterResource(id = it.image), contentDescription = "")

                            Text(text = "${it.location}, ${it.startDate.year}")
                            Text(text = "${it.description}")
                            Text(text = "${it.startDate.dayOfWeek} - ${it.endDate.dayOfMonth}",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End
                            )

                        }
                        
                    }
                }
            }

        }

    }
}

