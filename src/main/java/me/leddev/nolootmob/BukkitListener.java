package me.leddev.nolootmob;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;

public class BukkitListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.WITHER_SKELETON) {
            Entity entity = event.getEntity();
            List<ItemStack> drops = event.getDrops();

            Iterator<ItemStack> iterator = drops.iterator();
            while (iterator.hasNext()) {
                ItemStack item = iterator.next();
                if (item.getType() == Material.STONE_SWORD) {
                    iterator.remove();
                }
            }
        }
    }
}
