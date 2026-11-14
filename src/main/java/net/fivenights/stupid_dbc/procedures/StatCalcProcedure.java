package net.fivenights.stupid_dbc.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.fivenights.stupid_dbc.network.StupidDbcModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StatCalcProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).melee_dmg != entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).Strength * 1.1) {
			{
				StupidDbcModVariables.PlayerVariables _vars = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES);
				_vars.melee_dmg = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).Strength * 1.1;
				_vars.markSyncDirty();
			}
		}
	}
}