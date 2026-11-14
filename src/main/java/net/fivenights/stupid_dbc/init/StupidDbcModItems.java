package net.fivenights.stupid_dbc.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.fivenights.stupid_dbc.item.StengthITemItem;
import net.fivenights.stupid_dbc.StupidDbcMod;

public class StupidDbcModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(StupidDbcMod.MODID);
	public static final DeferredItem<Item> STENGTH_I_TEM;
	static {
		STENGTH_I_TEM = REGISTRY.register("stength_i_tem", StengthITemItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}