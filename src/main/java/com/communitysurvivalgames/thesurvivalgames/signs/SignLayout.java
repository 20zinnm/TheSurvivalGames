package com.communitysurvivalgames.thesurvivalgames.signs;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import com.communitysurvivalgames.thesurvivalgames.objects.SGArena;

public class SignLayout {
	private final String name;
	private final String online;
	private final String offline;
	private final List<String> lines;
	private final boolean teleport;

	public List<String> parseLayout(SGArena sinfo) {
		List<String> laa = new ArrayList<String>();
		for (String line : this.lines) {
			line = line.replace("%displayname%", sinfo.getDisplayName());
			line = line.replace("%numpl%", String.valueOf(sinfo.getPlayers().size()));
			line = line.replace("%maxpl%", String.valueOf(sinfo.getMaxPlayers()));
			laa.add(ChatColor.translateAlternateColorCodes('&', line));
		}

		return laa;
	}

	@ConstructorProperties({ "name", "online", "offline", "lines", "teleport" })
	public SignLayout(String name, String online, String offline, List<String> lines, boolean teleport) {
		this.name = name;
		this.online = online;
		this.offline = offline;
		this.lines = lines;
		this.teleport = teleport;
	}

	public String getName() {
		return this.name;
	}

	public String getOnline() {
		return this.online;
	}

	public String getOffline() {
		return this.offline;
	}

	public List<String> getLines() {
		return this.lines;
	}

	public boolean isTeleport() {
		return this.teleport;
	}

	public boolean canEqual(Object other) {
		return other instanceof SignLayout;
	}

	public int hashCode() {
		int result = 1;
		Object $name = getName();
		result = result * 31 + ($name == null ? 0 : $name.hashCode());
		Object $online = getOnline();
		result = result * 31 + ($online == null ? 0 : $online.hashCode());
		Object $offline = getOffline();
		result = result * 31 + ($offline == null ? 0 : $offline.hashCode());
		Object $lines = getLines();
		result = result * 31 + ($lines == null ? 0 : $lines.hashCode());
		result = result * 31 + (isTeleport() ? 1231 : 1237);
		return result;
	}

	public String toString() {
		return "SignLayout(name=" + getName() + ", online=" + getOnline() + ", offline=" + getOffline() + ", lines=" + getLines() + ", teleport=" + isTeleport() + ")";
	}
}
