package net.fivenights.stupid_dbc.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.fivenights.stupid_dbc.network.StupidDbcModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class KillProcedure {
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
		if (entity instanceof Player && entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).health <= 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			{
				StupidDbcModVariables.PlayerVariables _vars = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES);
				_vars.health = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).max_health;
				_vars.markSyncDirty();
			}
		}
	}
}