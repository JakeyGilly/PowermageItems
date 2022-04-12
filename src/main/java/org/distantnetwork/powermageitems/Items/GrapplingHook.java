package org.distantnetwork.powermageitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.util.Vector;
import org.distantnetwork.powermagecore.utils.Items.WeaponItem;
import org.distantnetwork.powermagecore.utils.Rarity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GrapplingHook extends WeaponItem {
    Map<UUID, Long> cooldown = new HashMap<>();
    public GrapplingHook() {
        super(
                Material.FISHING_ROD,
                1,
                String.format("%sGrappling Hook", ChatColor.WHITE),
                Arrays.asList(
                        String.format("%sAbility: Grapple %sRIGHT CLICK", ChatColor.GOLD, ChatColor.YELLOW),
                        String.format("%sFling yourself through the air at speed and reach places previously unreachable.", ChatColor.GRAY),
                        String.format("%sCooldown: %s2 Seconds", ChatColor.DARK_GRAY, ChatColor.GREEN)
                ),
                Arrays.asList(ItemFlag.HIDE_ATTRIBUTES),
                new HashMap<Enchantment, Integer>(),
                0,
                true,
                Rarity.COMMON,
                0,
                25,
                true);
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
        if (cooldown.get(player.getUniqueId()) == null || cooldown.get(player.getUniqueId()) <= System.currentTimeMillis()) {
            Location loc = entity.getLocation();
            player.setVelocity(new Vector(
                    entity.getLocation().getX() - player.getEyeLocation().getX(),
                    entity.getLocation().add(0, 1, 0).getY() - player.getEyeLocation().getY(),
                    entity.getLocation().getZ() - player.getEyeLocation().getZ()
            ).normalize().multiply(-1.5D).setY(1.0D));
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 2000);
        }
    }

    @Override
    public void onShootBow(Player player, Entity entity) {

    }
}
