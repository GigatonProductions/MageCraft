
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magecraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.magecraft.item.WoodenStaffItem;
import net.mcreator.magecraft.item.ManaiconItem;
import net.mcreator.magecraft.MagecraftMod;

public class MagecraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MagecraftMod.MODID);
	public static final RegistryObject<Item> WOODEN_STAFF = REGISTRY.register("wooden_staff", () -> new WoodenStaffItem());
	public static final RegistryObject<Item> MANAICON = REGISTRY.register("manaicon", () -> new ManaiconItem());
}
