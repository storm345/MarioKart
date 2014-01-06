package net.stormdev.mariokart;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class User {
	private Player player;
	private String playerName;
	private int checkpoint;
	private int lapsLeft;
	private ItemStack[] oldInventory;
	private final int oldLevel;
	private final float oldExp;
	private boolean inRace;
	private boolean finished;
	private Location location;
	private GameMode oldGameMode;
	private boolean respawning = false;

	public User(Player player) {
		this.player = player;
		this.checkpoint = 0;
		this.lapsLeft = 3;
		this.oldLevel = player.getLevel();
		this.oldExp = player.getExp();
		this.oldGameMode = player.getGameMode();
		inRace = false;
		finished = false;
		location = null;
		this.playerName = player.getName();
	}
	
	public void setRespawning(Boolean respawning){
		this.respawning = respawning;
	}
	
	public GameMode getOldGameMode(){
		return oldGameMode;
	}
	
	public Boolean isRespawning(){
		return respawning;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Player getPlayer() {
		if(player == null){
			player = MarioKart.plugin.getServer().getPlayer(getPlayerName());
		}
		if(isRespawning() && player == null){
			return null;
		}
		else if(isRespawning() && player != null){
			setRespawning(false);
		}
		if (player == null || !player.isOnline()) {
			player = null;
		}
		return player;
	}
	
	public void setCheckpoint(int checkpoint) {
		this.checkpoint = checkpoint;
	}

	public int getCheckpoint() {
		return checkpoint;
	}

	public void setLapsLeft(int lapsLeft) {
		this.lapsLeft = lapsLeft;
	}

	public int getLapsLeft() {
		return lapsLeft;
	}

	public void setOldInventory(ItemStack[] contents) {
		this.oldInventory = contents;
	}

	public ItemStack[] getOldInventory() {
		return oldInventory;
	}

	public int getOldLevel() {
		return oldLevel;
	}

	public float getOldExp() {
		return oldExp;
	}

	public void setInRace(boolean inRace) {
		this.inRace = inRace;
	}

	public boolean isInRace() {
		return inRace;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}
}