package org.distantnetwork.powermageitems;

import org.bukkit.plugin.java.JavaPlugin;
import org.distantnetwork.powermageitems.Items.ZeusBolt;

public class PowermageItems extends JavaPlugin {
    public static PowermageItems instance;
    public static PowermageItems getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new ZeusBolt(), this);
    }
}
