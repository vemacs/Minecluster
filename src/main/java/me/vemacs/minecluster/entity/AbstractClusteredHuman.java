package me.vemacs.minecluster.entity;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;

@RequiredArgsConstructor
public abstract class AbstractClusteredHuman implements IClusteredEntity {
    @NonNull
    protected String name;

    @Override
    public void teleport(Location location) {
        despawn();
        spawn(location);
    }
}
