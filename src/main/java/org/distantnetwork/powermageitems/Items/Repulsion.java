package org.distantnetwork.powermageitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.util.Vector;
import org.distantnetwork.powermagecore.utils.Items.WeaponItem;
import org.distantnetwork.powermagecore.utils.PowermagePlayer;
import org.distantnetwork.powermagecore.utils.Rarity;

import java.util.Arrays;
import java.util.HashMap;

public class Repulsion extends WeaponItem {
    public Repulsion() {
        super(
                Material.SCUTE,
                1,
                String.format("%sRepulsion", ChatColor.GREEN),
                Arrays.asList(
                        String.format("%sAbility: Launch Away %sRIGHT CLICK", ChatColor.GOLD, ChatColor.YELLOW),
                        String.format("%sLaunches everyone within a %s5 block %sradius away.", ChatColor.GREEN, ChatColor.GRAY, ChatColor.GRAY),
                        String.format("%sMana Cost: %s10", ChatColor.DARK_GRAY, ChatColor.LIGHT_PURPLE)
                ),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS),
                new HashMap<Enchantment, Integer>() {{put(Enchantment.MENDING, 1);}},
                0,
                true,
                Rarity.UNCOMMON,
                0,
                20,
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
        if (pmPlayer.getMana() >= 10) {
            for (Entity entity : player.getNearbyEntities(2.5, 2.5, 2.5)) {
                if (entity instanceof Player) {
                    Player target = (Player) entity;
                    if (target == player) continue;
                }
                entity.setVelocity(new Vector(
                        entity.getLocation().getX() - player.getEyeLocation().getX(),
                        entity.getLocation().add(0, 1, 0).getY() - player.getEyeLocation().getY(),
                        entity.getLocation().getZ() - player.getEyeLocation().getZ()
                ).normalize().multiply(1.5D).setY(1.0D));
                entity.sendMessage(String.format("%sYou were launched away by %s%s%s.", ChatColor.GRAY, ChatColor.BLUE, player.getName(), ChatColor.GRAY));
            }
            player.sendMessage(String.format("%sUsed %sBounce%s! %s(10 Mana)", ChatColor.GREEN, ChatColor.GOLD, ChatColor.GREEN, ChatColor.LIGHT_PURPLE));
            pmPlayer.setMana(pmPlayer.getMana() - 10);
            pmPlayer.save();
            if (player.getInventory().getItemInMainHand() == this.getItem()) {
                player.getInventory().setItemInMainHand(this.getItem());
            } else if (player.getInventory().getItemInOffHand() == this.getItem()) {
                player.getInventory().setItemInOffHand(this.getItem());
            }
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
        leftClickOnAir(player, block, b);
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
