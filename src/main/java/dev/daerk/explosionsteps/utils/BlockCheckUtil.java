package dev.daerk.explosionsteps.utils;

import dev.daerk.explosionsteps.ExplosionSteps;

import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

public class BlockCheckUtil{

    ExplosionSteps plugin;

    public BlockCheckUtil(ExplosionSteps plugin){
        this.plugin = plugin;
    }

    public static boolean isConfiguredBlockBelow(Player player, ExplosionSteps plugin){
        Location below = player.getLocation().clone().subtract(0, 1, 0);
        Material blockType = below.getBlock().getType();
        List<String> blockNames = plugin.getFileConfigManager().getBlocks();
        for (String blockName : blockNames) {
            Material blockMaterial = Material.matchMaterial(blockName);
            if (blockMaterial != null && blockType == blockMaterial) {
                return true;
            }
        }
        return false;
    }
}