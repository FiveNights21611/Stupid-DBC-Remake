package net.fivenights.stupid_dbc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.fivenights.stupid_dbc.network.StupidDbcModVariables;

public class StengthITemRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			StupidDbcModVariables.PlayerVariables _vars = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES);
			_vars.Strength = entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).Strength + 1;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Your Strength Is now: " + entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).Strength)), false);
	}
}