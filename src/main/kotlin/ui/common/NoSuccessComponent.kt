package ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.common.theme.AppColorsProvider

@Composable
fun NoSuccessComponent(
    modifier: Modifier = Modifier.fillMaxWidth().heightIn(min = 320.dp),
    contentAlignment: Alignment = Alignment.Center,
    iconResId: String = "icons/ic_empty.xml",
    message: String = "暂无数据",
    retryBlock: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .let {
                if (retryBlock != null)
                    it.onClick { retryBlock.invoke() }
                else it
            },
        contentAlignment = contentAlignment
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                painterResource(iconResId),
                null,
                tint = AppColorsProvider.current.primary,
                modifier = Modifier.size(100.dp)
            )
            if (!message.isEmpty()) {
                Text(
                    "$message",
                    fontSize = 14.sp,
                    color = AppColorsProvider.current.thirdText,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }
}
