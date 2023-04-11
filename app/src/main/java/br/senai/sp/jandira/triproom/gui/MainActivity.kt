package br.senai.sp.jandira.triproom.gui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import br.senai.sp.jandira.triproom.repository.UserRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)


        setContent {
            TripRoomTheme {
                TripRoomScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TripRoomScreen() {

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

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
            //Spacer(modifier = Modifier.height(200.dp))
            Column(
                modifier = Modifier
                    .height(500.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) { // column pai dos texts


                Column(modifier = Modifier.padding(bottom = 64.dp)) {
                    Text(
                        text = stringResource(id = R.string.login),
                        fontSize = 64.sp,
                        fontWeight = FontWeight(800),
                        color = Color(207, 6, 240)
                    )
                    Text(
                        text = stringResource(id = R.string.please),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(160, 156, 156)
                    )
                }
                //}
                Column(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = emailState,
                        shape = RoundedCornerShape(16.dp),
                        onValueChange = { emailState = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        label = { Text(text = stringResource(id = R.string.email)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_24),
                                contentDescription = "Email",
                                modifier = Modifier,
                                tint = Color(206, 1, 240)
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(205, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                            focusedLabelColor = Color(207, 1, 240)
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = passwordState,
                        shape = RoundedCornerShape(16.dp),
                        onValueChange = { passwordState = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        label = { Text(text = stringResource(id = R.string.password)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_24),
                                contentDescription = "Password",
                                modifier = Modifier,
                                tint = Color(206, 1, 240)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240),
                                focusedLabelColor = Color(207, 1, 240)

                            )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Button(
                        modifier = Modifier
                            .width(150.dp)
                            .height(64.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),
                        onClick = {

//                            val intent = Intent(context, LoggedActivity::class.java)
//                            context.startActivity(intent)
//
                            authenticateUser(email = emailState, password = passwordState, context = context)


                        },
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row() {
                            Text(
                                text = stringResource(id = R.string.sign_in),
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight(900)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_forward_24),
                                contentDescription = "Arrow right",
                                tint = Color(255, 255, 255)
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(id = R.string.have_account),
                        color = Color(160, 156, 156)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = stringResource(id = R.string.sign_up),
                        modifier = Modifier
                            .clickable {
                                val intent = Intent(context, SignUpActivity::class.java)
                                context.startActivity(intent)

                            }, color = Color(207, 1, 240), fontWeight = FontWeight(800)
                    )

                }
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

fun authenticateUser(
    email: String,
    password: String,
    context: Context
) {

    val userRepository = UserRepository(context)

    val user = userRepository.authenticate(email = email, password = password)

    if (user != null){
        Toast.makeText(context, "User alredy exists", Toast.LENGTH_LONG).show()
        val intent = Intent(context, LoggedActivity::class.java)
        context.startActivity(intent)
    }else{
        Toast.makeText(context, "Not exists", Toast.LENGTH_LONG).show()
    }


}

