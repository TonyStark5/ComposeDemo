import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import androidx.compose.ui.window.WindowPosition

const val WIDTH = 600
const val HEIGHT = 600

@Composable
@Preview
fun MainApp() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Box(modifier = Modifier.offset(60.dp,60.dp)){

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
