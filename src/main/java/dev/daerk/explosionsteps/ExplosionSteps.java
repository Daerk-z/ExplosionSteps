package dev.daerk.explosionsteps;

import org.bukkit.Bukkit;

import dev.daerk.explosionsteps.config.FileConfigManager;
import dev.daerk.explosionsteps.task.GrassExplosionTask;
import dev.daerk.explosionsteps.utils.MessageColors;

import org.bukkit.plugin.java.JavaPlugin;


public class ExplosionSteps extends JavaPlugin {

    
    private FileConfigManager fileConfigManager;

    public void onEnable() {

        fileConfigManager = new FileConfigManager(this);

        Bukkit.getConsoleSender().sendMessage(MessageColors.coloredMessage("&aExplosionSteps habilitado!"));
        new GrassExplosionTask(this).runTaskTimer(this, 0, 1);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageColors.coloredMessage("&cExplosionSteps deshabilitado."));
    }

    public FileConfigManager getFileConfigManager(){
        return fileConfigManager;
    }
}