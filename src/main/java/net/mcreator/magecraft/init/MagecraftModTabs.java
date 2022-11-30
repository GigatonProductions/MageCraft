
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magecraft.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MagecraftModTabs {
	public static CreativeModeTab TAB_MAGIC;

	public static void load() {
		TAB_MAGIC = new CreativeModeTab("tabmagic") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MagecraftModItems.MANAICON.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
