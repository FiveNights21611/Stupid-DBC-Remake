package net.fivenights.stupid_dbc.procedures;

import net.minecraft.world.entity.Entity;

import net.fivenights.stupid_dbc.network.StupidDbcModVariables;

public class HealthtextprocProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("###,###").format(entity.getData(StupidDbcModVariables.PLAYER_VARIABLES).max_health);
	}
}