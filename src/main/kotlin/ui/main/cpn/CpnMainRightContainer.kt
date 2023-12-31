package ui.main.cpn

import androidx.compose.foundation.background
import ui.common.onClick
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.AppConfig
import base.MusicPlayController
import router.TNavigatorManager
import router.NavGraph
import router.RouterUrls
import ui.common.theme.AppColorsProvider

/**
 * 主页右边布局组件
 */
@Composable
fun CpnMainRightContainer() {
    Box(modifier = Modifier.fillMaxSize().background(color = AppColorsProvider.current.pure)) {
        Spacer(
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .background(if (MusicPlayController.showMusicPlayDrawer) AppColorsProvider.current.pure else AppColorsProvider.current.topBarColor)
        )
        NavGraph()
        CpnRightTopActionButtons()
    }
}

/**
 * 顶部TitleBar组件
 */
@Composable
fun CommonTitleBar(
    title: String = "",
    showBackButton: Boolean = false,
    customerContent: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = Modifier.padding(end = 320.dp).fillMaxWidth().height(AppConfig.topBarHeight)
            .background(if (MusicPlayController.showMusicPlayDrawer) AppColorsProvider.current.pure else AppColorsProvider.current.topBarColor),
        contentAlignment = Alignment.CenterStart
    ) {
        if (!MusicPlayController.showMusicPlayDrawer) {
            if (customerContent != null) {
                customerContent.invoke()
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (showBackButton) {
                        val navigator = TNavigatorManager.navigator

                        Icon(
                            painterResource("icons/ic_back.webp"),
                            modifier = Modifier.padding(start = 20.dp).clip(RoundedCornerShape(50)).onClick {
                                navigator.popBackStack()
                            }.padding(4.dp).size(18.dp),
                            contentDescription = "返回上一页",
                            tint = AppColorsProvider.current.firstIcon

                        )
                    }

                    Text(
                        title,
                        color = AppColorsProvider.current.firstText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
        }

    }
}


@Composable
private fun BoxScope.CpnRightTopActionButtons() {
    val showPopupWindow = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.height(50.dp).width(320.dp).align(Alignment.TopEnd),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource("icons/ic_setting.webp"),
            contentDescription = null,
            modifier = Modifier.padding(end = 14.dp).size(24.dp).padding(3.dp).onClick {
                TNavigatorManager.navigator.navigate(RouterUrls.SETTING)
            },
            tint = AppColorsProvider.current.firstIcon
        )
        Icon(
            painterResource("icons/ic_message.webp"),
            contentDescription = null,
            modifier = Modifier.padding(end = 14.dp).size(24.dp).padding(3.dp),
            tint = AppColorsProvider.current.firstIcon
        )
        Icon(
            painterResource("icons/ic_theme.webp"),
            contentDescription = null,
            modifier = Modifier.padding(end = 14.dp).size(24.dp).padding(3.dp).onClick {
                showPopupWindow.value = true
            },
            tint = AppColorsProvider.current.firstIcon
        )
        Icon(
            painterResource("icons/ic_screen_min.webp"),
            contentDescription = null,
            modifier = Modifier.padding(end = 24.dp).size(24.dp).padding(3.dp),
            tint = AppColorsProvider.current.firstIcon
        )
    }

    CpnThemePopup(showPopupWindow)
}