package dev.daerk.explosionsteps.utils;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CooldownUtil {
    private final Map<UUID, Long> last = new ConcurrentHashMap<>();
    private final long cooldownMillis;

    public CooldownUtil(long cooldownMillis) {
        this.cooldownMillis = cooldownMillis;
    }
    
    public boolean tryUse(UUID id) {
        long now = System.currentTimeMillis();
        Long prev = last.get(id);
        if (prev == null || now - prev >= cooldownMillis) {
            last.put(id, now);
            return true;
        }
        return false;
    }
}
