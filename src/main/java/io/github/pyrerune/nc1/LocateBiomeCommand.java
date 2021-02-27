package io.github.pyrerune.nc1;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.command.arguments.SuggestionProviders;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class LocateBiomeCommand {
    private static final SuggestionProvider<CommandSource> ALL_BIOMES = SuggestionProviders.register(new ResourceLocation("locatebiome", "all_biomes"), (ctx, builder) -> {
        return ISuggestionProvider.suggestIterable(ForgeRegistries.BIOMES.getKeys(), builder);
    });
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> locateBiomeCommand
                = Commands.literal("locatebiome")
                .requires(player -> player.hasPermissionLevel(2))
                .then(Commands.argument("biome", ResourceLocationArgument.resourceLocation())
                                .suggests(ALL_BIOMES)
                                .executes(ctx -> execute(ctx.getSource(), getBiomeFromArgument(ctx, "biome"))));

        dispatcher.register(locateBiomeCommand);
    }
    @Nullable
    private static Biome getBiomeFromArgument(CommandContext<CommandSource> ctx, String arg) throws CommandSyntaxException
    {
        ResourceLocation biomeRl = ctx.getArgument(arg, ResourceLocation.class);
        Biome biome = ForgeRegistries.BIOMES.getValue(biomeRl);

        return biome;
    }
    private static int execute(CommandSource source, Biome biome) throws CommandSyntaxException
    {
        BlockPos sourcePos = new BlockPos(source.getPos());
        BlockPos biomePos = locateBiome(source.getWorld(), biome, sourcePos, 6400, 8);
        TranslationTextComponent biomeName = new TranslationTextComponent(biome.getTranslationKey());

        if(biomePos != null)
        {
            int distance = MathHelper.floor(getDistance(sourcePos.getX(), sourcePos.getZ(), biomePos.getX(), biomePos.getZ()));

            source.sendFeedback(new TranslationTextComponent("commands.locate.success", biomeName,
                    TextComponentUtils.wrapInSquareBrackets(new TranslationTextComponent("chat.coordinates", biomePos.getX(), "~", biomePos.getZ()))
                            .applyTextStyle(style -> style.setColor(TextFormatting.GREEN)
                                    .setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + biomePos.getX() + " ~ " + biomePos.getZ()))
                                    .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.coordinates.tooltip")))), distance), false);
            return distance;
        }
        return 0;
    }

    private static BlockPos locateBiome(ServerWorld world, Biome biome, BlockPos pos, int maxSearchRadius, int searchIncrement)
    {
        return locateBiome(world, pos.getX(), pos.getY(), pos.getZ(), maxSearchRadius, searchIncrement, ImmutableList.of(biome));
    }

    private static BlockPos locateBiome(ServerWorld world, int x, int y, int z, int maxSearchRadius, int searchIncrement, List<Biome> biomes)
    {
        int originX = x >> 2;
        int originZ = z >> 2;
        int border = maxSearchRadius >> 2;
        int currentY = y >> 2;
        BlockPos pos = null;

        for(int idk = 0; idk <= border; idk += searchIncrement)
        {
            for(int zi = -idk; zi <= idk; zi += searchIncrement)
            {
                boolean flag1 = Math.abs(zi) == idk;

                for(int xi = -idk; xi <= idk; xi += searchIncrement)
                {
                    boolean flag2 = Math.abs(xi) == idk;

                    if(!flag2 && !flag1)
                        continue;

                    int currentX = originX + xi;
                    int currentZ = originZ + zi;

                    if(biomes.contains(world.getNoiseBiomeRaw(currentX, currentY, currentZ)))
                        return new BlockPos(currentX << 2, y, currentZ << 2);
                }
            }
        }

        return pos;
    }

    private static float getDistance(int x1, int y1, int x2, int y2)
    {
        int i = x2 - x1;
        int j = y2 - y1;
        return MathHelper.sqrt(i * i + j * j);
    }
}
