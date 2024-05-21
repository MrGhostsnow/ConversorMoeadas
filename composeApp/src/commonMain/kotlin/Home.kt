import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home() {

    var dolar by remember {
        mutableStateOf("")
    }

    var real by remember {
        mutableStateOf("")
    }


    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.Green
            ){
                Text(
                    "Conversor de Moeda", color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Text("5,12 Real brasileiro",
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp, 50.dp, 0.dp, 0.dp)
            )
            Text(
                "21 de mai., 17:00 UTC",
                fontSize = 14.sp,
                modifier = Modifier.padding(20.dp, 10.dp, 20.dp, 20.dp)
            )

            OutlinedTextField(
                value = dolar,
                onValueChange = {
                    dolar = it

                    if (dolar.isEmpty()){
                        dolar = ""
                        real = ""
                    }else{
                        val valorConvertido = dolar.toDouble() * 5.12
                        real = valorConvertido.toString()
                    }

                },
                label = {
                    Text("Dólar americano")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedLabelColor = Color.DarkGray,
                    textColor = Color.Black,
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                maxLines = 1,
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )

            OutlinedTextField(
                value = real,
                onValueChange = {
                    real = it
                },
                label = {
                    Text("Real")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedLabelColor = Color.DarkGray,
                    textColor = Color.Black,
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                maxLines = 1,
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )
        }
    }
}
