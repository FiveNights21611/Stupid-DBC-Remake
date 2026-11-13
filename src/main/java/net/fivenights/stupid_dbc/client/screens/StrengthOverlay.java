package net.fivenights.stupid_dbc.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

@EventBusSubscriber(Dist.CLIENT)
public class StrengthOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {

			if (true)
				guiTools$renderOverlaySizedTextLabel(event.getGuiGraphics(), java.util.Objects.toString(net.fivenights.stupid_dbc.procedures.StrengthTextProcedureProcedure.execute(entity), ""), w / 2 + -188, h / 2 + 100, 120, -6750208, false, 1.00F,
						2);
		}
	}

	private static void guiTools$renderOverlaySizedTextLabel(net.minecraft.client.gui.GuiGraphics guiGraphics, String text, int x, int y, int boxWidth, int color, boolean shadow, float scale, int overflowMode) {
		if (text == null || scale <= 0.0F || boxWidth <= 0)
			return;
		net.minecraft.client.gui.Font font = net.minecraft.client.Minecraft.getInstance().font;
		int textWidth = Math.max(1, (int) Math.floor(boxWidth / scale));
		String displayed = overflowMode == 2 ? guiTools$ellipsizeOverlaySizedText(font, text, textWidth) : text;
		boolean clip = overflowMode != 0;
		if (clip)
			guiGraphics.enableScissor(x, y, x + boxWidth, y + Math.max(1, (int) Math.ceil(font.lineHeight * scale)));
		guiGraphics.pose().pushPose();
		try {
			guiGraphics.pose().translate(x, y, 0.0F);
			guiGraphics.pose().scale(scale, scale, 1.0F);
			guiGraphics.drawString(font, displayed, 0, 0, color, shadow);
		} finally {
			guiGraphics.pose().popPose();
			if (clip)
				guiGraphics.disableScissor();
		}
	}

	private static String guiTools$ellipsizeOverlaySizedText(net.minecraft.client.gui.Font font, String value, int maxWidth) {
		if (font.width(value) <= maxWidth)
			return value;
		String ellipsis = "…";
		if (font.width(ellipsis) > maxWidth)
			return "";
		int low = 0, high = value.length();
		while (low < high) {
			int middle = (low + high + 1) >>> 1;
			if (font.width(value.substring(0, middle) + ellipsis) <= maxWidth)
				low = middle;
			else
				high = middle - 1;
		}
		return value.substring(0, low).stripTrailing() + ellipsis;
	}
}