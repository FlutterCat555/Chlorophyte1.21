package uwu.fluttercat.chlorophyte.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import uwu.fluttercat.chlorophyte.Chlorophyte;

public class ModItems {
    public static final Item DEBUGGER = registerItem("debugger", new Item(new Item.Settings()));
    public static final Item CHLOROPHYTE = registerItem("chlorophyte", new Item(new Item.Settings()));
    public static final Item CHLOROPHYTE_SWORD = registerItem("chlorophyte_sword", new Item(new Item.Settings()));
    public static final Item CHLOROPHYTE_SCYTHE = registerItem("chlorophyte_scythe", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Chlorophyte.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Chlorophyte.LOGGER.info("Registering Mod Items for " + Chlorophyte.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
            entries.add(DEBUGGER);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CHLOROPHYTE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(CHLOROPHYTE_SCYTHE);
            entries.add(CHLOROPHYTE_SWORD);
        });
    }
}