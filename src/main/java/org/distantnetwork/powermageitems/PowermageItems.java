package org.distantnetwork.powermageitems;

import org.bukkit.plugin.java.JavaPlugin;
import org.distantnetwork.powermageitems.Items.ZeusBolt;

public class PowermageItems extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ZeusBolt(), this);
    }
}
