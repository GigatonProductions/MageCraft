package net.mcreator.magecraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.magecraft.network.MagecraftModVariables;

public class ManaBarCondition8Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MagecraftModVariables.PlayerVariables())).Mana >= 8) {
			return true;
		}
		return false;
	}
}
