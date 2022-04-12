package org.distantnetwork.powermageitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.distantnetwork.powermagecore.utils.Items.WeaponItem;
import org.distantnetwork.powermagecore.utils.PowermagePlayer;
import org.distantnetwork.powermagecore.utils.Rarity;

import java.util.Arrays;
import java.util.HashMap;

public class HyperWandOfMending extends WeaponItem {
    public HyperWandOfMending() {
        super(
                Material.BLAZE_ROD,
                1,
                String.format("%sHyper Wand of Mending", ChatColor.LIGHT_PURPLE),
                Arrays.asList(
                        String.format("%sAbility: Hyper Heal %sRIGHT CLICK", ChatColor.GOLD, ChatColor.YELLOW),
                        String.format("%sHeals %s4 ❤%s, but inflicts you with %sWeakness %sfor 4 second.", ChatColor.GRAY, ChatColor.RED, ChatColor.GRAY, ChatColor.GRAY, ChatColor.BLUE, ChatColor.GRAY),
                        String.format("%sMana Cost: %s70", ChatColor.DARK_GRAY, ChatColor.LIGHT_PURPLE)
                ),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                new HashMap<Enchantment, Integer>() {{ put(Enchantment.MENDING, 1); }},
                0,
                true,
                Rarity.RARE,
                4,
                60,
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
        if (pmPlayer.getMana() >= 70) {
            pmPlayer.setMana(pmPlayer.getMana() - 70);
            player.setHealth(player.getHealth() + 4);
            player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 4, 1));
        } else player.sendMessage(String.format("%sYou don't have enough mana!", ChatColor.RED));
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
