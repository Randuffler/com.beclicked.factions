package com.beclicked.factions;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;

import com.beclicked.factions.PlayerConfig;
import com.beclicked.factions.Rank;

public class BeClicked extends JavaPlugin implements Listener {
  
  public final PluginManager pm = this.getServer().getPluginManager();
  
  public void onEnable() {
    this.pm.registerEvents(this, this);
    this.pm.registerEvents(new PlayerConfig(), this);
  }
  
  public void onDisable() {
    for (Player online : Bukkit.getOnlinePlayers()) {
      PlayerConfig.get().saveConfig(online);
    }
  }
  
  @EventHandler
  public void onFirstJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    if (!PlayerConfig.get().getPlayerFile(p).exists()) {
      Rank.giveRank(p, Rank.NONE);
			PlayerConfig.get().setup(p);
    }
  }
}
