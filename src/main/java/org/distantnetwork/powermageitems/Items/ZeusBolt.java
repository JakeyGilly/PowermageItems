package org.distantnetwork.powermageitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;
import org.distantnetwork.powermagecore.utils.Items.WeaponItem;
import org.distantnetwork.powermagecore.utils.PowermagePlayer;
import org.distantnetwork.powermagecore.utils.Rarity;

import java.util.*;

import static org.distantnetwork.powermagecore.PowermageCore.getPlugin;

public class ZeusBolt extends WeaponItem implements Listener {
    private List<UUID> lightning = new ArrayList<>();
    private Map<UUID, Long> cooldown = new HashMap<>();
    public ZeusBolt() {
        super(
                Material.SPECTRAL_ARROW,
                1,
                String.format("%sZeus Bolt", ChatColor.GOLD),
                Arrays.asList(
                        String.format("%sAbility: Thunderbolt %sRIGHT CLICK", ChatColor.GOLD, ChatColor.YELLOW),
                        String.format("%sTeleport %s10 blocks %sin front of you,", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY),
                        String.format("%sstriking lighting at your previous location.", ChatColor.GRAY),
                        String.format("%sMana Cost: %s50", ChatColor.DARK_GRAY, ChatColor.LIGHT_PURPLE),
                        String.format("%sCooldown: %s30 Seconds", ChatColor.DARK_GRAY, ChatColor.GREEN)
                ),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                new HashMap<Enchantment, Integer>() {{ put(Enchantment.MENDING, 1); }},
                0,
                true,
                Rarity.LEGENDARY,
                4,
                75,
                true
        );
    }

    @Override
    public void onEquip(Player player) {

    }

    @Override
    public void onUnequip(Player player) {

    }

    @Override
    public void clickEntity(Player player, Entity target, boolean shifting) {

    }

    @Override
    public void punchEntity(Player player, Entity target, double damage, boolean shifting) {

    }

    @Override
    public void leftClickOnBlock(Player player, Block block, boolean shifting) {
        PowermagePlayer pmPlayer = new PowermagePlayer(player);
        if (pmPlayer.getMana() >= 50) {
            if (cooldown.get(player.getUniqueId()) == null || cooldown.get(player.getUniqueId()) <= System.currentTimeMillis()) {
                player.getWorld().strikeLightning(player.getLocation());
                BlockIterator iter = new BlockIterator(player, 10);
                Block lastBlock = iter.next();
                while (iter.hasNext()) {
                    lastBlock = iter.next();
                    if (lastBlock.getType() == Material.AIR) continue;
                    break;
                }
                player.teleport(lastBlock.getLocation().add(0, 1, 0).setDirection(player.getLocation().getDirection()));
                pmPlayer.setMana(pmPlayer.getMana() - 50);
                cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 30000);
                player.sendMessage(String.format("%sUsed %sThunderbolt%s! %s(50 Mana)", ChatColor.GREEN, ChatColor.GOLD, ChatColor.GREEN, ChatColor.LIGHT_PURPLE));
                pmPlayer.save();
                lightning.add(player.getUniqueId());
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        lightning.remove(player.getUniqueId());
                    }
                }.runTaskLater(getPlugin(), 40);
            } else player.sendMessage(String.format("%sYou must wait %s%s seconds%s before using this ability again.", ChatColor.RED, ChatColor.GOLD, (cooldown.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000, ChatColor.RED));
        } else player.sendMessage(String.format("%sYou do not have enough mana to use this ability.", ChatColor.RED));
    }

    @Override
    public void leftClickOnAir(Player player, Block block, boolean shifting) {
        leftClickOnBlock(player, block, shifting);
    }

    @Override
    public void rightClickOnBlock(Player player, Block block, boolean shifting) {
        leftClickOnAir(player, block, shifting);
    }

    @Override
    public void rightClickOnAir(Player player, Block block, boolean shifting) {
        rightClickOnBlock(player, block, shifting);
    }

    @Override
    public void onBlockBreak(Player player, Block block, boolean shifting) {

    }

    @Override
    public void onBlockPlace(Player player, Block block, boolean shifting) {

    }

    @Override
    public void onDrop(Player player) {

    }

    @Override
    public void onPickup(Player player) {

    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
                if (lightning.contains(player.getUniqueId())) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
