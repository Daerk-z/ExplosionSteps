package dev.daerk.explosionsteps.utils;

import dev.daerk.explosionsteps.ExplosionSteps;

import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BlockCheckUtil{

    ExplosionSteps plugin;

    public BlockCheckUtil(ExplosionSteps plugin){
        this.plugin = plugin;
    }
    
    public static boolean isGrassBlockBelow(Player player, ExplosionSteps plugin){
        Location below = player.getLocation().clone().subtract(0, 1, 0);
        Block block = below.getBlock();
        String blockName = plugin.getFileConfigManager().getBlock();
        Material blockMaterial = Material.matchMaterial(blockName);
        if (blockMaterial == null) {
            return false;
        }
        return block.getType() == blockMaterial;
    }
}