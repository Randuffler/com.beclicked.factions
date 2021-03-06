package com.beclicked.factions;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.beclicked.factions.PlayerConfig;

public enum Rank {
	
	BECLICKED(1, RankType.OWNER),
	OP(2, RankType.LEAD),
	FOUNDER(3, RankType.LEAD),
	OWNER(4, RankType.LEAD),
	COOWNER(5, RankType.LEAD),
	LEADER(6, RankType.LEAD),
	HEADADMINISTRATOR(7, RankType.HEAD),
	ADMINISTRATOR(8, RankType.STAFF),
	HEADMODERATOR(9, RankType.HEAD),
	MODERATOR(10, RankType.STAFF),
	DEVELOPER(11, RankType.STAFF),
	HELPER(12, RankType.JRSTAFF),
	BUILDER(13, RankType.STAFF),
	TRAINEE(14, RankType.JRSTAFF),
	YOUTUBEGOLD(15, RankType.YOUTUBE),
	YOUTUBEPLUS(16, RankType.YOUTUBE),
	YOUTUBE(17, RankType.YOUTUBE),
	BETATESTER(18, RankType.SPECIAL),
	CYBORG(19, RankType.SPECIAL),
	YT(20, RankType.YOUTUBE),
	WARLORD(21, RankType.RANKED),
	PALADIN(22, RankType.RANKED),
	ELITE(23, RankType.RANKED),
	NONE(24, RankType.PLAYER),
	NULL(25, null);

	public static HashMap<UUID, Rank> ranks = new HashMap<UUID, Rank>();
	private int priority;
	private RankType type;

	Rank(int priority, RankType type) {
		this.priority = priority;
		this.type = type;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public RankType getType() {
		return this.type;
	}
	
	public static void giveRank(Player p, Rank rank) {
		ranks.put(p.getUniqueId(), rank);
		PlayerConfig.get().setPlayerRank(p, rank);
		if ((rank.equals(Rank.OP)) || (rank.equals(Rank.BECLICKED))) {
			p.setOp(true);
		} else {
			p.setOp(false);
		}
	}
	
	public static Rank translateStringToRank(String rank) {
		Rank r = Rank.NULL;
		if (rank.equalsIgnoreCase("none")) {
			r = Rank.NONE;
		} else if (rank.equalsIgnoreCase("elite")) {
			r = Rank.ELITE;
		} else if (rank.equalsIgnoreCase("paladin")) {
			r = Rank.PALADIN;
		} else if (rank.equalsIgnoreCase("warlord")) {
			r = Rank.WARLORD;
		} else if (rank.equalsIgnoreCase("cyborg")) {
			r = Rank.CYBORG;
		} else if ((rank.equalsIgnoreCase("betatester")) || (rank.equalsIgnoreCase("beta"))) {
			r = Rank.BETATESTER;
		} else if (rank.equalsIgnoreCase("yt")) {
			r = Rank.YT;
		} else if (rank.equalsIgnoreCase("youtube")) {
			r = Rank.YOUTUBE;
		} else if ((rank.equalsIgnoreCase("youtubeplus")) || (rank.equalsIgnoreCase("youtube+"))) {
			r = Rank.YOUTUBEPLUS;
		} else if (rank.equalsIgnoreCase("youtubegold")) {
			r = Rank.YOUTUBEGOLD;
		} else if (rank.equalsIgnoreCase("builder")) {
			r = Rank.BUILDER;
		} else if (rank.equalsIgnoreCase("trainee")) {
			r = Rank.TRAINEE;
		} else if (rank.equalsIgnoreCase("helper")) {
			r = Rank.HELPER;
		} else if ((rank.equalsIgnoreCase("moderator")) || (rank.equalsIgnoreCase("mod"))) {
			r = Rank.MODERATOR;
		} else if ((rank.equalsIgnoreCase("developer")) || (rank.equalsIgnoreCase("dev"))) {
			r = Rank.DEVELOPER;
		} else if ((rank.equalsIgnoreCase("headmoderator")) || (rank.equalsIgnoreCase("headmod"))) {
			r = Rank.HEADMODERATOR;
		} else if ((rank.equalsIgnoreCase("administrator")) || (rank.equalsIgnoreCase("admin"))) {
			r = Rank.ADMINISTRATOR;
		} else if ((rank.equalsIgnoreCase("headadministrator")) || (rank.equalsIgnoreCase("headadmin"))) {
			r = Rank.HEADADMINISTRATOR;
		} else if (rank.equalsIgnoreCase("leader")) {
			r = Rank.LEADER;
		} else if (rank.equalsIgnoreCase("coowner")) {
			r = Rank.COOWNER;
		} else if (rank.equalsIgnoreCase("owner")) {
			r = Rank.OWNER;
		} else if (rank.equalsIgnoreCase("founder")) {
			r = Rank.FOUNDER;
		} else if ((rank.equalsIgnoreCase("op")) || (rank.equalsIgnoreCase("operator"))) {
			r = Rank.OP;
		} else if (rank.equalsIgnoreCase("beclicked")) {
			r = Rank.BECLICKED;
		}
		return r;
	}
	
	public static String translateRanktoString(Rank rank) {
		return rank.toString();
	}
	
	public static String translateRanktoLowerCaseString(Rank rank) {
		return rank.toString().toLowerCase();
	}
	
	public static boolean hasRank(Player p, Rank rank) {
		return getRank(p.getUniqueId()) == rank;
	}
	
	public static Rank getRank(UUID uuid) {
		return ranks.get(uuid);
	}
	
	public static boolean hasAtLeast(Rank playerRank, Rank checkRank) {
		return playerRank.compareTo(checkRank) <= 0;
	}
	
	public static boolean hasAtMost(Rank playerRank, Rank checkRank) {
		return playerRank.compareTo(checkRank) >= 0;
	}
	
	public static boolean isLessThan(Rank playerRank, Rank checkRank) {
		return playerRank.compareTo(checkRank) < 0;
	}
	
	public static boolean isGreaterThan(Rank playerRank, Rank checkRank) {
		return playerRank.compareTo(checkRank) > 0;
	}
	
	public static boolean hasCorrectRank(Player p, Player target, Rank rank) {
		if (Rank.hasAtLeast(Rank.getRank(p.getUniqueId()), rank)) {
			if (target != null) {
				if (Rank.isLessThan(Rank.getRank(p.getUniqueId()), Rank.getRank(target.getUniqueId()))) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}
}
