package net.fivenights.stupid_dbc.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.fivenights.stupid_dbc.network.StupidDbcModVariables;
import net.fivenights.stupid_dbc.StupidDbcMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CustomStrengthTestProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double tmp = 0;
		if (sourceentity instanceof ServerPlayer == true) {
			StupidDbcMod.LOGGER.debug("Is Player");
			tmp = sourceentity.getData(StupidDbcModVariables.PLAYER_VARIABLES).melee_dmg;
		} else {
			StupidDbcMod.LOGGER.debug("Is Not Player");
			tmp = amount;
		}
		StupidDbcMod.LOGGER.debug("Returned TMP!");
		if (event instanceof LivingIncomingDamageEvent _event) {
			_event.setAmount((float) tmp);
		}
	}
}