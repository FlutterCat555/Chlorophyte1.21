package uwu.fluttercat.chlorophyte;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uwu.fluttercat.chlorophyte.block.ModBlocks;
import uwu.fluttercat.chlorophyte.item.ModItems;

public class Chlorophyte implements ModInitializer {
	public static final String MOD_ID = "chlorophyte";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Totally not stolen from terraria");

	}
}