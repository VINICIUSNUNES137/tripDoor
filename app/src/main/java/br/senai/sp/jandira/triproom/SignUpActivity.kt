package br.senai.sp.jandira.triproom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

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

@Preview (showBackground = true, showSystemUi = true)
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

                Card(
                    modifier = Modifier
                        .height(height = 40.dp)
                        .width(width = 120.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RoundedCornerShape(bottomStart = 16.dp)
                ) {
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                Text(text = stringResource(id = R.string.sign_up),
                    color = Color(207, 6, 240),
                    fontSize = 32.sp,
                    fontWeight = FontWeight(800),
                )
                Text(text = stringResource(id = R.string.create_new), color = Color(160, 156, 156))
                Spacer(modifier = Modifier.height(48.dp))
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
                    })
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
                    })
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
                    })
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
                    })
                Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {

                    Checkbox(checked = false, onCheckedChange = {} )
                    Text(text = stringResource(id = R.string.over))
                }


                Row(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                ) {
                    
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),

                    ) {
                    Text(text = stringResource(
                        id = R.string.create_account).uppercase(),
                        fontWeight = FontWeight(800),
                        fontSize = 16.sp,
                        color = Color.White
                     )
                }
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text(
                        text = stringResource(id = R.string.already_account),
                        color = Color(160, 156, 156))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        modifier = Modifier .clickable {
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)

                        },
                        text = stringResource(id = R.string.sign_in),
                        color = Color(207, 1, 240),
                        fontWeight = FontWeight(800))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {

                Card(
                    modifier = Modifier
                        .height(height = 40.dp)
                        .width(width = 120.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RoundedCornerShape(topEnd = 16.dp)
                ) {
//aaaaaaaa
                }

            }

        }
    }
}