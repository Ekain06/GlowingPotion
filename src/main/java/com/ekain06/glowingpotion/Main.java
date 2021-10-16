package com.ekain06.glowingpotion;

import com.ekain06.glowingpotion.mixin.BrewingRecipeRegistryInvoker;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MOD_ID = "glowingpotion";
	//public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static final Potion GLOWING_POTION = new Potion(new StatusEffectInstance(StatusEffects.GLOWING, 3600));  // 3 mins
	public static final Potion LONG_GLOWING_POTION = new Potion(new StatusEffectInstance(StatusEffects.GLOWING, 9600));  // 8 mins

	@Override
	public void onInitialize() {
		Registry.register(Registry.POTION, new Identifier(MOD_ID, "glowing"), GLOWING_POTION);
		Registry.register(Registry.POTION, new Identifier(MOD_ID, "long_glowing"), LONG_GLOWING_POTION);

		BrewingRecipeRegistryInvoker.registerPotionRecipe(Potions.AWKWARD, Items.GLOW_INK_SAC, GLOWING_POTION);
		BrewingRecipeRegistryInvoker.registerPotionRecipe(GLOWING_POTION, Items.REDSTONE, LONG_GLOWING_POTION);
	}
}
