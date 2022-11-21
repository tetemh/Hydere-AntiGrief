package fr.tetemh.antigriff;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Antigriff extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event){
        if(event.getPlayer().getGameMode() == GameMode.ADVENTURE || event.getPlayer().getGameMode() == GameMode.SURVIVAL){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event){
        if(event.getPlayer().getGameMode() == GameMode.ADVENTURE || event.getPlayer().getGameMode() == GameMode.SURVIVAL){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onActiveTnt(PlayerInteractEvent event){
        if((event.getPlayer().getGameMode() == GameMode.ADVENTURE || event.getPlayer().getGameMode() == GameMode.SURVIVAL) || event.getClickedBlock().getType() == Material.TNT){
            event.setCancelled(true);
        }
    }

}
