package com.eptyt_mod;

import com.eptyt_mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eptyt_mod.item.ModItems.*;

public class EptytMod implements ModInitializer {
	public static final String MOD_ID = "eptyt-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();

		LOGGER.info("Hello Fabric world!");
	}
}