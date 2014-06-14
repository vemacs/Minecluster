package me.vemacs.minecluster;

import com.lenis0012.bukkit.npc.NPCFactory;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Minecluster extends JavaPlugin {
    @Getter
    private static Minecluster instance;
    @Getter
    private static NPCFactory factory;

    @Override
    public void onEnable() {
        instance = this;
        factory = new NPCFactory(this);
    }
}