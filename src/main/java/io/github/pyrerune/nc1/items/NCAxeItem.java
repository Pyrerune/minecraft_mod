package io.github.pyrerune.nc1.items;

import javafx.util.Pair;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NCAxeItem extends AxeItem {
    public NCAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.addEnchantment(getRandomSwordEnchantment().getKey(), getRandomSwordEnchantment().getValue());
    }
    private static Pair<Enchantment,Integer> getRandomSwordEnchantment() {
        List<Enchantment> swordEnchantments = new ArrayList<>(Arrays.asList(Enchantments.BANE_OF_ARTHROPODS, Enchantments.VANISHING_CURSE,
                Enchantments.EFFICIENCY, Enchantments.FORTUNE, Enchantments.MENDING, Enchantments.SHARPNESS,
                Enchantments.SILK_TOUCH, Enchantments.SMITE, Enchantments.UNBREAKING));
        Enchantment enchantment = swordEnchantments.get(new Random().nextInt(swordEnchantments.size()));

        return new Pair<>(enchantment, enchantment.getMaxLevel());
    }
}
