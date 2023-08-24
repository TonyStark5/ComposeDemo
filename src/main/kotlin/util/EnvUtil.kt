package util

import java.util.*


/**
 * 环境工具库
 * 用于获取系统类型
 */
object EnvUtil {
    val osName = System.getProperty("os.name", "generic")

    fun isMac() = osName.lowercase(Locale.getDefault()).contains("mac")

    fun isWindows() = osName.contains("indows")

    fun isLinux() = osName.contains("nix") || osName.contains("nux") || osName.contains("aix")
}