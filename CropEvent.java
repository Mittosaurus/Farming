package com.gmail.mittosaurus.farming;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;


public class CropEvent implements Listener {

    @EventHandler
    public void onCropBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();

        Material[] enumArray = new Material[]{cropEnum.CROPSc.material, cropEnum.MELONc.material, cropEnum.POTATOc.material};

        ItemStack item;
        ItemStack specialItem;

        Random rand = new Random();

        int value = rand.nextInt(100);
        int n = rand.nextInt(3) + 1;

        if (Arrays.asList(enumArray).contains(block.getType())) {
            if (block.getType() == cropEnum.CROPSc.material) {
                item = cropEnum.CROPSc.itemstack;
                specialItem = new ItemStack(Material.DIAMOND_SWORD);
            } else if (block.getType() == cropEnum.MELONc.material) {
                item = cropEnum.MELONc.itemstack;
                specialItem = new ItemStack(Material.APPLE);
            } else if (block.getType() == cropEnum.POTATOc.material) {
                item = cropEnum.MELONc.itemstack;
                specialItem = new ItemStack(Material.GOLD_NUGGET);
            } else {
                return;
            }
        } else {
            return;
        }

        Material tool = player.getInventory().getItemInMainHand().getType();

        int x;

        if (tool == Material.DIAMOND_HOE) {
            x = 4;
        } else if (tool == Material.IRON_HOE) {
            x = 3;
        } else if (tool == Material.STONE_HOE) {
            x = 2;
        } else if (tool == Material.WOOD_HOE) {
            x = 1;
        } else {
            block.setType(Material.AIR);
            return;
        }

        for (int i = 0; i < n + x; i++) {
            block.setType(Material.AIR);

            if (value == 30) {
                block.getWorld().dropItemNaturally(block.getLocation(), specialItem);
            }

            block.getWorld().dropItemNaturally(block.getLocation(), item);
        }
    }
}