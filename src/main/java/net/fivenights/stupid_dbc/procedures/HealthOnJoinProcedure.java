package net.fivenights.stupid_dbc.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.fivenights.stupid_dbc.network.StupidDbcModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HealthOnJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).healthstart == false) {
			{
				StupidDbcModVariables.PlayerVariables _vars = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES);
				_vars.max_health = 25;
				_vars.health = 25;
				_vars.healthstart = true;
				_vars.markSyncDirty();
			}
		}
	}
}