package dev.daerk.explosionsteps.utils;

import org.bukkit.Location;

public class ExplosionUtil {

    public static void createExplosion(Location loc, float power, boolean setFire, boolean breakBlocks) {
        if (loc == null || loc.getWorld() == null) return;
        loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), power, setFire, breakBlocks);
    }
}
