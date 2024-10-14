package uwu.fluttercat.chlorophyte;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import uwu.fluttercat.chlorophyte.block.ModBlocks;

public class ChlorophyteClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHLOROPHYTE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHLOROPHYTE_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHIFTED_CHLOROPHYTE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHIFTED_CHLOROPHYTE_BLOCK, RenderLayer.getTranslucent());
    }
}
