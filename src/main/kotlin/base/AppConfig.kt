package base

import androidx.compose.ui.unit.dp
import java.io.File

object AppConfig {
    val topBarHeight = 50.dp
    val windowMinWidth = 1000.dp
    val windowMinHeight = 680.dp
    var fullScreen = false

    // 应用缓存目录
    val cacheRootDir = System.getProperty("user.dir") + File.separator + "Cache"

}