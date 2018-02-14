package com.gmail.mittosaurus.farming;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new CropEvent(), this);

    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
}
