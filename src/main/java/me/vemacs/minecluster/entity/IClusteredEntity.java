package me.vemacs.minecluster.entity;

import org.bukkit.Location;

public interface IClusteredEntity {
    public void moveTo(Location target, double speed);
    public Location getLocation();
    public void spawn(Location location);
    public void despawn();
    public void teleport(Location location);
    public void animateDamage();
}
