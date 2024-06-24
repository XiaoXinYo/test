package com.xiaoxinyo.mc.easy.chat;

import org.bukkit.plugin.java.JavaPlugin;

final public class MCEasyChat extends JavaPlugin {
    int a = 0;
    /**
     * 当插件被Load(加载)时执行的代码
     * getLogger().info() -> 代表或其控制台Log并且发送一行info信息
     */
    @Override
    public void onLoad() {
        getLogger().info("onLoad has been invoked!");
    }

    /**
     * 当插件被Enable(开启)时执行的代码
     * getLogger().info() -> 代表或其控制台Log并且发送一行info信息
     */
    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");
    }

    /**
     * 当插件被Disable(关闭)时执行的代码
     * getLogger().info() -> 代表或其控制台Log并且发送一行info信息
     */
    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }
}