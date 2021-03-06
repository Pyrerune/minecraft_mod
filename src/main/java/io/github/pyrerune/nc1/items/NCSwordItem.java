package io.github.pyrerune.nc1.items;

import com.google.common.collect.ImmutableList;
import javafx.util.Pair;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

import java.util.*;

public class NCSwordItem extends SwordItem {
    public NCSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);

    }
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.addEnchantment(getRandomSwordEnchantment().getKey(), getRandomSwordEnchantment().getValue());
    }
    private static Pair<Enchantment,Integer> getRandomSwordEnchantment() {
        List<Enchantment> swordEnchantments = new ArrayList<>(Arrays.asList(Enchantments.BANE_OF_ARTHROPODS, Enchantments.VANISHING_CURSE,
                Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK, Enchantments.LOOTING, Enchantments.MENDING,
                Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.SWEEPING, Enchantments.UNBREAKING));
        Enchantment enchantment = swordEnchantments.get(new Random().nextInt(swordEnchantments.size()));

        return new Pair<>(enchantment, enchantment.getMaxLevel());
    }
}
