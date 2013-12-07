package net.lerozon.plugins.location;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Location extends JavaPlugin implements Listener{
	
	public void onEnable(){
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerInteract(PlayerInteractEvent evt){
		if(evt.getMaterial() == Material.PAPER){
			if(evt.getAction() == Action.RIGHT_CLICK_BLOCK || evt.getAction() == Action.RIGHT_CLICK_AIR){
				evt.getPlayer().sendMessage("Printing location of clicked block");
				evt.getPlayer().sendMessage(getStringFromLocation(evt.getClickedBlock().getLocation()));
			}else{
				evt.getPlayer().sendMessage("Printing your current location");
				evt.getPlayer().sendMessage(getStringFromLocation(evt.getPlayer().getLocation()));
			}
		}
	}
	
	public static String getStringFromLocation(org.bukkit.Location in){
		return in.getWorld().getName() + ":" + in.getX() + "," + in.getY() + "," + in.getBlockZ() + "," +
			   in.getYaw() + "," + in.getPitch();
	}
	
}
