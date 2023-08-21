import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

const val WIDTH = 600
const val HEIGHT = 600

@Composable
@Preview
fun MainApp() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Row(modifier = Modifier.offset(60.dp,60.dp)){
            Button(modifier = Modifier.offset(60.dp,60.dp),onClick = {
                text = "Hello, Tony!"
            }) {
                Text(text)
            }
        }
        Button(modifier = Modifier.offset(60.dp,60.dp),onClick = {
            text = "Hello, Tony!"
        }) {
            Text(text)
        }
        Button(onClick = {
            text = "Hello, Tony!"
        }) {
            Text(text)
        }

    }

}

fun main() = application {


    // 设置是否居中显示
    val state = WindowState(size = DpSize(WIDTH.dp, HEIGHT.dp), position = WindowPosition.Aligned(Alignment.Center))
    val title = "Welcome to Tony's Home!"
    Window(onCloseRequest = ::exitApplication, state = state, resizable = true, title = title) {
        MainApp()
    }
}
