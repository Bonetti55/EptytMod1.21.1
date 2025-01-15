package com.eptyt_mod.item;

import com.eptyt_mod.EptytMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register (Item item, String id)
    {
        Identifier itemID = Identifier.of(EptytMod.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static final FoodComponent CHIKEN_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(1.5f)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 10 * 60, 3),1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 6 * 20, 3),1.0f)
            .build();

    public static final FoodComponent BEEF_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(1.5f)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6 * 60, 3),1.0f)
            .build();

    public static final Item DOSHIRAK_CHIKEN = register(
            new Item(new Item.Settings().food(CHIKEN_FOOD_COMPONENT)),
            "doshirak_chiken"
    );

    public static final Item DOSHIRAK_BEEF = register(
            new Item(new Item.Settings().food(BEEF_FOOD_COMPONENT)),
            "doshirak_beef"
    );

    public static final Item NOODLES = register(
            new Item(new Item.Settings()),
            "noodles"
    );

    public static void initialize(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(DOSHIRAK_CHIKEN));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(DOSHIRAK_BEEF));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(NOODLES));
    }
}
