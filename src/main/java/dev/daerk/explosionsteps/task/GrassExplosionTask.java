package dev.daerk.explosionsteps.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import dev.daerk.explosionsteps.ExplosionSteps;
import dev.daerk.explosionsteps.utils.BlockCheckUtil;
import dev.daerk.explosionsteps.utils.CooldownUtil;
import dev.daerk.explosionsteps.utils.ExplosionUtil;

public class GrassExplosionTask extends BukkitRunnable {

    private final ExplosionSteps plugin;
    private final CooldownUtil cooldown = new CooldownUtil(1000); // 1 segundo
    private final float explosionPower = 4.0f;
    private final boolean breakBlocks = true;
    private final boolean setFire = false;
    
    public GrassExplosionTask(ExplosionSteps plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!p.hasPermission("xs.explode.use")) continue;
            if (!BlockCheckUtil.isGrassBlockBelow(p, plugin)) continue;
            if (!cooldown.tryUse(p.getUniqueId())) continue;
            ExplosionUtil.createExplosion(p.getLocation(), explosionPower, setFire, breakBlocks);
        }
    }
}
