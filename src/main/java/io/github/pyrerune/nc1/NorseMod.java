package io.github.pyrerune.nc1;


import io.github.pyrerune.nc1.init.BiomeInit;
import io.github.pyrerune.nc1.init.BlockInit;
import io.github.pyrerune.nc1.init.ItemInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO Custom Recipes
//TODO Custom Tools
//TODO Add LANG
//TODO Replace apple with smth fun (leaves loot table)
@Mod("nc1")
@Mod.EventBusSubscriber(modid = NorseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class NorseMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "nc1";
    public NorseMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);

    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeInit.registerBiomes();
    }
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ItemGroup.MISC);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }
    public void clientSetup(FMLClientSetupEvent event) {

        RenderTypeLookup.setRenderLayer(BlockInit.IRON_WOOD_SAPLING.get(), RenderType.getCutout());
    }

    public void commonSetup(FMLCommonSetupEvent args) {
    }
}

