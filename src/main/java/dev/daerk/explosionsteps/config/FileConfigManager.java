package dev.daerk.explosionsteps.config;

import dev.daerk.explosionsteps.ExplosionSteps;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class FileConfigManager {


    private CustomConfig configFile;

    private List<String> blocks;

    public FileConfigManager(ExplosionSteps plugin){
        configFile = new CustomConfig("config.yml", null, plugin, false);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = configFile.getConfig();
        blocks = config.getStringList("config.block_explode.blocks");
    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }

    public List<String> getBlocks(){
        return blocks;
    }
}
