import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import base.AppConfig
import moe.tlaster.precompose.PreComposeWindow
import moe.tlaster.precompose.navigation.rememberNavigator
import org.succlz123.lib.imageloader.core.ImageLoader
import router.NCNavigatorManager
import ui.common.theme.AppTheme
import ui.common.theme.themeTypeState
import ui.main.MainPage
import util.EnvUtil
import java.awt.Dimension
import java.io.File


const val WIDTH = 600
const val HEIGHT = 600

@Composable
@Preview
private fun mainApp() {
    AppTheme(themeTypeState.value) {
        NCNavigatorManager.navigator = rememberNavigator()
        MainPage()
    }
}

fun main() = application {

    initImageLoader()
    // 窗口状态初始化
    val windowState = rememberWindowState(
        size = DpSize(AppConfig.windowMinWidth, AppConfig.windowMinHeight), position = WindowPosition(
            Alignment.Center
        )
    )
    // 预窗口状态设置
    PreComposeWindow(
        state = windowState,
        onCloseRequest = ::exitApplication,
        undecorated = EnvUtil.isWindows(),
        title = ""
    ) {
        window.minimumSize = Dimension(AppConfig.windowMinWidth.value.toInt(), AppConfig.windowMinHeight.value.toInt())
        // 窗口根组件属性设置，填满整个窗口、去除标题框
        window.rootPane.apply {
            rootPane.putClientProperty("apple.awt.fullWindowContent", true)
            rootPane.putClientProperty("apple.awt.transparentTitleBar", true)
            rootPane.putClientProperty("apple.awt.windowTitleVisible", false)

        }
        mainApp()

    }
}

private fun initImageLoader() {
    // 加载图像缓存地址
    ImageLoader.configuration(rootDirectory = File(AppConfig.cacheRootDir))
    // println(AppConfig.cacheRootDir)
}