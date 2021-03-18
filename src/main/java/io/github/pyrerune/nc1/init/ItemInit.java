package io.github.pyrerune.nc1.init;

import io.github.pyrerune.nc1.NorseMod;
import io.github.pyrerune.nc1.items.NCItemTier;
import io.github.pyrerune.nc1.items.NCSwordItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, NorseMod.MODID);
    public static final RegistryObject<Item> IRON_WOOD_SWORD = ITEMS.register("iron_wood_sword", () -> new NCSwordItem(NCItemTier.IRON_WOOD, 13, 6.0f, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> IRON_WOOD_PICKAXE = ITEMS.register("iron_wood_pickaxe", () -> new PickaxeItem(NCItemTier.IRON_WOOD, 6, 3.0f, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> IRON_WOOD_AXE = ITEMS.register("iron_wood_axe", () -> new AxeItem(NCItemTier.IRON_WOOD, 17, 7.0f, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> IRON_WOOD_SHOVEL = ITEMS.register("iron_wood_shovel", () -> new ShovelItem(NCItemTier.IRON_WOOD, 4, 3.0f, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> IRON_WOOD_HOE = ITEMS.register("iron_wood_hoe", () -> new HoeItem(NCItemTier.IRON_WOOD, 3.0f, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CURSED_SWORD_CASING = ITEMS.register("cursed_sword_casing", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CURSED_PICKAXE_CASING = ITEMS.register("cursed_pickaxe_casing", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CURSED_AXE_CASING = ITEMS.register("cursed_axe_casing", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CURSED_SHOVEL_CASING = ITEMS.register("cursed_shovel_casing", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CURSED_HOE_CASING = ITEMS.register("cursed_hoe_casing", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CURSED_TOOL_CASING = ITEMS.register("cursed_tool_casing", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

}
