package br.senai.sp.jandira.triproom.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.components.BottomShape
import br.senai.sp.jandira.triproom.components.TopShape
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme
import br.senai.sp.jandira.triproom.R

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                // A surface container using the 'background' color from the theme
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {

    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), horizontalArrangement = Arrangement.End
            ) {

                TopShape()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Color(207, 6, 240),
                    fontSize = 48.sp,
                    fontWeight = FontWeight(800),
                )
                Text(text = stringResource(id = R.string.create_new), color = Color(160, 156, 156))
                Spacer(modifier = Modifier.height(16.dp))
                Box(
//                    contentAlignment = Alignment.BottomEnd
                ) {
                    Card(
                        modifier = Modifier.size(100.dp),
                        shape = CircleShape,
                        backgroundColor = Color(160, 160, 160)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = ""
                        )
                    }
                    Image(
                        painterResource(id = R.drawable.baseline_add_a_photo_24),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                //aqui começaaaaaaaaaaaaaaaaaaaaaaaaaaa

                Column() {

                Column(
                    modifier = Modifier
                        .height(height = 300.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    OutlinedTextField(
                        value = "",
                        shape = RoundedCornerShape(16.dp),
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(63.dp),
                        label = { Text(text = stringResource(id = R.string.username)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person_24),
                                contentDescription = "Username",
                                modifier = Modifier,
                                tint = Color(206, 1, 240)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                focusedLabelColor = Color(207, 1, 240)
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = "",
                        shape = RoundedCornerShape(16.dp),
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(63.dp),
                        label = { Text(text = stringResource(id = R.string.phone)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.phone_android_24),
                                contentDescription = "Phone",
                                modifier = Modifier,
                                tint = Color(206, 1, 240)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                focusedLabelColor = Color(207, 1, 240)
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        shape = RoundedCornerShape(16.dp),
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(63.dp),
                        label = { Text(text = stringResource(id = R.string.email)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_24),
                                contentDescription = "Phone",
                                modifier = Modifier,
                                tint = Color(206, 1, 240)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                focusedLabelColor = Color(207, 1, 240)
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        shape = RoundedCornerShape(16.dp),
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(63.dp),
                        label = { Text(text = stringResource(id = R.string.password)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_24),
                                contentDescription = "Phone",
                                modifier = Modifier,
                                tint = Color(206, 1, 240)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                focusedLabelColor = Color(207, 1, 240)
                            )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Checkbox(checked = false, onCheckedChange = {})
                        Text(text = stringResource(id = R.string.over))
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    ) {

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),

                            ) {
                            Text(
                                text = stringResource(
                                    id = R.string.create_account
                                ).uppercase(),
                                fontWeight = FontWeight(800),
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }



                }

                }
                //aqui terminaaaaaaaaaaaaaaaaaaaaa


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.already_account),
                    color = Color(160, 156, 156)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    modifier = Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)

                    },
                    text = stringResource(id = R.string.sign_in),
                    color = Color(207, 1, 240),
                    fontWeight = FontWeight(800)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {

                BottomShape()

            }

        }
    }
}