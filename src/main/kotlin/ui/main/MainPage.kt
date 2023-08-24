package ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.common.toast.Toast
import ui.main.cpn.CpnMusicPlayBottomBar
import ui.main.cpn.CpnMainLeftMenu
import ui.main.cpn.CpnMainMusicPlayDrawer
import ui.main.cpn.CpnMainRightContainer
import ui.play.CpnCurrentPlayListSheet

/**
 * 主页
 */
@Composable
fun MainPage() {
    // 纵向布局，组件自适应充满窗体
    Column {
        Box(modifier = Modifier.weight(1f)) {
            Row(modifier = Modifier.fillMaxSize()) {
                CpnMainLeftMenu()
                CpnMainRightContainer()
            }
            CpnMainMusicPlayDrawer()
            CpnCurrentPlayListSheet()
            Toast()
        }

        CpnMusicPlayBottomBar()
    }


}