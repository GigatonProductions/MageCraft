
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magecraft.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.magecraft.network.InventorySMessage;
import net.mcreator.magecraft.MagecraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MagecraftModKeyMappings {
	public static final KeyMapping INVENTORY_S = new KeyMapping("key.magecraft.inventory_s", GLFW.GLFW_KEY_E, "key.categories.inventory");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(INVENTORY_S);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == INVENTORY_S.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						MagecraftMod.PACKET_HANDLER.sendToServer(new InventorySMessage(0, 0));
						InventorySMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
