package io.github.pyrerune.nc1.items;

import io.github.pyrerune.nc1.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class NCItemGroup extends ItemGroup {
    private ItemStack icon = null;
    public NCItemGroup(String label) {
        super(label);
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }

    @Override
    public ItemStack createIcon() {
        return this.icon;
    }
}
