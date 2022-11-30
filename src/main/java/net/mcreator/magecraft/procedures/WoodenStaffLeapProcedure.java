package net.mcreator.magecraft.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.magecraft.network.MagecraftModVariables;

public class WoodenStaffLeapProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MagecraftModVariables.PlayerVariables())).Mana >= 4) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 1), (entity.getDeltaMovement().z())));
			{
				double _setval = (entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MagecraftModVariables.PlayerVariables())).Mana - 4;
				entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
