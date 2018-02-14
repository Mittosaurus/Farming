package com.gmail.mittosaurus.farming;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum cropEnum {
    CROPSc (Material.CROPS, new ItemStack(Material.WHEAT)),
    POTATOc (Material.POTATO, new ItemStack(Material.POTATO_ITEM)),
    MELONc (Material.MELON_BLOCK, new ItemStack(Material.MELON));

    Material material;
    ItemStack itemstack;

    cropEnum (Material material, ItemStack itemstack){
        this.material = material;
        this.itemstack = itemstack;
    }

    public Material getMaterial(){
        return this.material;
    }

    public ItemStack getItemstack(){
        return this.itemstack;
    }
}
