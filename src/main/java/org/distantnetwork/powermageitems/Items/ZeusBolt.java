package org.distantnetwork.powermageitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.distantnetwork.powermagecore.utils.Items.WeaponItem;
import org.distantnetwork.powermagecore.utils.Rarity;

import java.util.Arrays;
import java.util.HashMap;

public class ZeusBolt extends WeaponItem {
    public ZeusBolt() {
        super(
                Material.SPECTRAL_ARROW,
                1,
                String.format("%sZeus Bolt", ChatColor.GOLD),
                Arrays.asList(String.format("%sAbility: Thunderbolt %sRIGHT CLICK", ChatColor.GOLD, ChatColor.YELLOW), String.format("%sTeleport %s10 blocks %sin front of you,", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY), String.format("%sstriking lighting at your previous location.", ChatColor.GRAY), String.format("%sMana Cost: %s50", ChatColor.DARK_GRAY, ChatColor.LIGHT_PURPLE), String.format("%sCooldown: %s30 Seconds", ChatColor.DARK_GRAY, ChatColor.GREEN)),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                new HashMap<Enchantment, Integer>() {{ put(Enchantment.MENDING, 1); }},
                0,
                true,
                Rarity.LEGENDARY,
                4,
                75,
                Arrays.asList("Zeus's Weapon of the Gods"),
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

    }

    @Override
    public void leftClickOnAir(Player player, Block block, boolean shifting) {

    }

    @Override
    public void rightClickOnBlock(Player player, Block block, boolean shifting) {

    }

    @Override
    public void rightClickOnAir(Player player, Block block, boolean shifting) {

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
}
