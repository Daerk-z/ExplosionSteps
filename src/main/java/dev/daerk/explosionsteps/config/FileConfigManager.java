package dev.daerk.explosionsteps.config;

import dev.daerk.explosionsteps.ExplosionSteps;

import org.bukkit.configuration.file.FileConfiguration;

public class FileConfigManager {


    private CustomConfig configFile;

    private String block;

    public FileConfigManager(ExplosionSteps plugin){
        configFile = new CustomConfig("config.yml", null, plugin, false);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = configFile.getConfig();
        block = config.getString("config.block_explode.block");
    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }

    public String getBlock(){
        return block;
    }
}
