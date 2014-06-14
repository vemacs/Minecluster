package me.vemacs.minecluster.entity.impl.npcfactory;

import com.lenis0012.bukkit.npc.NPC;
import com.lenis0012.bukkit.npc.NPCAnimation;
import com.lenis0012.bukkit.npc.NPCProfile;
import me.vemacs.minecluster.Minecluster;
import me.vemacs.minecluster.entity.AbstractClusteredHuman;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class NFHuman extends AbstractClusteredHuman {
    private NPC npc;

    public NFHuman(String name) {
        super(name);
    }

    @Override
    public void moveTo(Location target, double speed) {
        npc.pathfindTo(target, speed);
    }

    @Override
    public Location getLocation() {
        return npc.getBukkitEntity().getLocation();
    }

    @Override
    public void spawn(final Location location) {
        Bukkit.getScheduler().runTaskAsynchronously(Minecluster.getInstance(), new Runnable() {
            @Override
            public void run() {
                final NPCProfile profile = new NPCProfile(NFHuman.super.name, NFHuman.super.name);
                Bukkit.getScheduler().runTask(Minecluster.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        npc = Minecluster.getFactory().spawnHumanNPC(location, profile);
                        npc.setYaw(location.getYaw());
                    }
                });
            }
        });
    }

    @Override
    public void despawn() {
        npc.getBukkitEntity().remove();

    }

    @Override
    public void animateDamage() {
        npc.playAnimation(NPCAnimation.DAMAGE);
    }
}
