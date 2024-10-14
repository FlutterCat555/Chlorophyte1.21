package uwu.fluttercat.chlorophyte.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import uwu.fluttercat.chlorophyte.Chlorophyte;

public class ModBlocks {

    public static  final Block CHLOROPHYTE_BLOCK = registerBlock("chlorophyte_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static  final Block SHIFTED_CHLOROPHYTE_BLOCK = registerBlock("shifted_chlorophyte_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).sounds(BlockSoundGroup.AMETHYST_BLOCK).noCollision().nonOpaque()));

    public static  final Block BUGGED_BLOCK = registerBlock("bugged_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.INTENTIONALLY_EMPTY).noCollision()));


    private static  Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return  Registry.register(Registries.BLOCK, Identifier.of(Chlorophyte.MOD_ID, name), block);
    }
    private static void  registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Chlorophyte.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        Chlorophyte.LOGGER.info("Registering Mod Blocks for "+ Chlorophyte.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
                    entries.add(CHLOROPHYTE_BLOCK);
                    entries.add(SHIFTED_CHLOROPHYTE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
                entries.add(BUGGED_BLOCK);
        });
    }
}
