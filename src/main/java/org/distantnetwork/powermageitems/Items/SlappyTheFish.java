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

public class SlappyTheFish extends WeaponItem {
        public SlappyTheFish() {
                super(
                        Material.COD,
                        1,
                        String.format("%sSlappy The Fish", ChatColor.GREEN),
                        Arrays.asList(
                                String.format("%sAbility: Knockback %sPASSIVE", ChatColor.GOLD, ChatColor.YELLOW),
                                String.format("%sKnocks whoever you hit back %s6 %sblocks.", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY)
                        ),
                        Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                        new HashMap<Enchantment, Integer>() {{ put(Enchantment.MENDING, 1); put(Enchantment.KNOCKBACK, 2); }},
                        0,
                        true,
                        Rarity.UNCOMMON,
                        4,
                        100,
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
