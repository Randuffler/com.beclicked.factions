package com.beclicked.factions;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.beclicked.factions.BeClicked;
import com.beclicked.factions.Rank;

public class PlayerConfig implements Listener {

	static PlayerConfig instance = new PlayerConfig();
	private static final BeClicked main = (BeClicked)BeClicked.getPlugin(BeClicked.class);
	public static final File userdata = new File(main.getDataFolder(), File.separator + "players");
	
	public static PlayerConfig get() {
		return instance;
	}
	
	public void setup(Player p) {
		File pFile = new File(userdata, File.separator + p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		
		if (!pFile.exists()) {
			
			playerData.addDefault("rank", "none");
			
			playerData.options().copyDefaults(true);
			
			this.saveConfig(p);
		}
	}
	
	public void set(Player p, String path, String value) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		playerData.set(path, value);
		
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void set(Player p, String path, boolean value) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		playerData.set(path, value);
		
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void set(Player p, String path, int value) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		playerData.set(path, value);
		
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void set(Player p, String path, double value) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		playerData.set(path, value);
		
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void set(Player p, String path, float value) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		playerData.set(path, value);
		
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void set(Player p, String path, long value) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		playerData.set(path, value);
		
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveConfig(Player p) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public FileConfiguration getPlayerData(Player p) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		return playerData;
	}
	
	public File getPlayerFile(Player p) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		return pFile;
	}
	
	public void setPlayerRank(Player p, Rank rank) {
		File pFile = new File(userdata, p.getUniqueId().toString() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
		
		if (rank == Rank.NONE) {
			playerData.set("rank", "none");
		} else if (rank == Rank.ELITE) {
			playerData.set("rank", "elite");
		} else if (rank == Rank.PALADIN) {
			playerData.set("rank", "paladin");
		} else if (rank == Rank.WARLORD) {
			playerData.set("rank", "warlord");
		} else if (rank == Rank.CYBORG) {
			playerData.set("rank", "cyborg");
		} else if (rank == Rank.BETATESTER) {
			playerData.set("rank", "betatester");
		} else if (rank == Rank.YT) {
			playerData.set("rank", "yt");
		} else if (rank == Rank.YOUTUBE) {
			playerData.set("rank", "youtube");
		} else if (rank == Rank.YOUTUBEPLUS) {
			playerData.set("rank", "youtubeplus");
		} else if (rank == Rank.YOUTUBEGOLD) {
			playerData.set("rank", "youtubegold");
		} else if (rank == Rank.HELPER) {
			playerData.set("rank", "helper");
		} else if (rank == Rank.MODERATOR) {
			playerData.set("rank", "moderator");
		} else if (rank == Rank.DEVELOPER) {
			playerData.set("rank", "developer");
		} else if (rank == Rank.HEADMODERATOR) {
			playerData.set("rank", "headmoderator");
		} else if (rank == Rank.ADMINISTRATOR) {
			playerData.set("rank", "administrator");
		} else if (rank == Rank.HEADADMINISTRATOR) {
			playerData.set("rank", "headadministrator");
		} else if (rank == Rank.LEADER) {
			playerData.set("rank", "leader");
		} else if (rank == Rank.COOWNER) {
			playerData.set("rank", "coowner");
		} else if (rank == Rank.OWNER) {
			playerData.set("rank", "owner");
		} else if (rank == Rank.FOUNDER) {
			playerData.set("rank", "founder");
		} else if (rank == Rank.OP) {
			playerData.set("rank", "op");
		} else if (rank == Rank.BECLICKED) {
			playerData.set("rank", "beclicked");
		} try {
			playerData.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerConfigQuit(PlayerQuitEvent e) {
		this.saveConfig(e.getPlayer());
	}
}
