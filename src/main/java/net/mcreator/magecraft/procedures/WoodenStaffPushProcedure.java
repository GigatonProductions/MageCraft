package net.mcreator.magecraft.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.magecraft.network.MagecraftModVariables;

import java.util.Comparator;

public class WoodenStaffPushProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double z = 0;
		if ((entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MagecraftModVariables.PlayerVariables())).Mana >= 6) {
			z = ((Entity) world
					.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - entity.getZ();
			x = ((Entity) world
					.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - entity.getX();
			if (entity.isShiftKeyDown() && !world
					.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2), e -> true)
					.isEmpty()) {
				entity.setDeltaMovement(new Vec3(x, 0, z));
			}
			{
				double _setval = (entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MagecraftModVariables.PlayerVariables())).Mana - 6;
				entity.getCapability(MagecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
