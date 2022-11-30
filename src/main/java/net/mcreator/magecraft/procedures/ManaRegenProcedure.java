package net.mcreator.magecraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.magecraft.network.MagecraftModVariables;

public class ManaRegenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MagecraftModVariables.PlayerVariables())).Mana < 10) {
			{
				double _setval = (entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MagecraftModVariables.PlayerVariables())).Mana + 1;
				entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
