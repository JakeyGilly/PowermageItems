package org.distantnetwork.powermageitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.scheduler.BukkitRunnable;
import org.distantnetwork.powermagecore.utils.ConfigurationManager;
import org.distantnetwork.powermagecore.utils.Items.WeaponItem;
import org.distantnetwork.powermagecore.utils.PowermagePlayer;
import org.distantnetwork.powermagecore.utils.Rarity;

import java.util.Arrays;
import java.util.HashMap;

import static org.distantnetwork.powermageitems.PowermageItems.getInstance;

public class SuperDasher extends WeaponItem {
    public SuperDasher() {
        super(
                Material.GOLDEN_SWORD,
                1,
                String.format("%sSuper Dasher", ChatColor.GREEN),
                Arrays.asList(
                        String.format("%sAbility: Superspeed %sRIGHT CLICK", ChatColor.GOLD, ChatColor.YELLOW),
                        String.format("%sGives you %s+40%% speed %sfor %s40 seconds.", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY, ChatColor.GREEN),
                        String.format("%sMana Cost: %s60", ChatColor.DARK_GRAY, ChatColor.LIGHT_PURPLE)
                ),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                new HashMap<Enchantment, Integer>() {{ put(Enchantment.MENDING, 1); }},
                0,
                true,
                Rarity.UNCOMMON,
                5,
                35,
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
    public void clickEntity(Player player, Entity entity, boolean b) {

    }

    @Override
    public void punchEntity(Player player, Entity entity, double v, boolean b) {

    }

    @Override
    public void leftClickOnBlock(Player player, Block block, boolean b) {
        PowermagePlayer pmPlayer = new PowermagePlayer(player);
        if (pmPlayer.getMana() >= 60) {
            player.setWalkSpeed((float) (player.getWalkSpeed() + (pmPlayer.getSpeedUpgrade() * ConfigurationManager.getDefaultConfig().getDouble("upgrades.speed.speedPerLevel")))+0.08f);
            pmPlayer.setMana(pmPlayer.getMana() - 60);
            pmPlayer.save();
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.setWalkSpeed((float) (player.getWalkSpeed() - (pmPlayer.getSpeedUpgrade() * ConfigurationManager.getDefaultConfig().getDouble("upgrades.speed.speedPerLevel")))-0.08f);
                }
            }.runTaskLater(getInstance(), 800);
        } else player.sendMessage(String.format("%sYou do not have enough mana to use this ability.", ChatColor.RED));
    }

    @Override
    public void leftClickOnAir(Player player, Block block, boolean b) {
        leftClickOnBlock(player, block, b);
    }

    @Override
    public void rightClickOnBlock(Player player, Block block, boolean b) {
        leftClickOnAir(player, block, b);
    }

    @Override
    public void rightClickOnAir(Player player, Block block, boolean b) {
        rightClickOnBlock(player, block, b);
    }

    @Override
    public void onBlockBreak(Player player, Block block, boolean b) {

    }

    @Override
    public void onBlockPlace(Player player, Block block, boolean b) {

    }

    @Override
    public void onDrop(Player player) {

    }

    @Override
    public void onPickup(Player player) {

    }

    @Override
    public void onCaughtFish(Player player, Entity entity) {

    }

    @Override
    public void onShootBow(Player player, Entity entity) {

    }
}
