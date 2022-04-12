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

public class ForkOfForce extends WeaponItem {
    public ForkOfForce() {
        super(
                Material.TRIDENT,
                1,
                String.format("%sFork Of Force", ChatColor.LIGHT_PURPLE),
                Arrays.asList(
                        String.format("%sAbility: Riptide %sRIGHT CLICK AND HOLD", ChatColor.GOLD, ChatColor.YELLOW),
                        String.format("%sLaunches you into the air if you use this ability in water", ChatColor.GRAY),
                        String.format("%sMana Cost: &d25", ChatColor.DARK_GRAY)
                ),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                new HashMap<Enchantment, Integer>() {{ put(Enchantment.MENDING, 1); put(Enchantment.RIPTIDE, 1); put(Enchantment.LOYALTY, 1); }},
                0,
                true,
                Rarity.EPIC,
                9,
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

    }

    @Override
    public void leftClickOnAir(Player player, Block block, boolean b) {

    }

    @Override
    public void rightClickOnBlock(Player player, Block block, boolean b) {

    }

    @Override
    public void rightClickOnAir(Player player, Block block, boolean b) {

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
