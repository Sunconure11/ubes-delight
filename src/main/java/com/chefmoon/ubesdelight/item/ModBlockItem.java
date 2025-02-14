package com.chefmoon.ubesdelight.item;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlockItem extends BlockItem {

    private final boolean hasCustomTooltip;

    public ModBlockItem(Block block) {
        super(block, new ModItemSettings());
        this.hasCustomTooltip = false;
    }

    public ModBlockItem(Block block, Settings settings) {
        super(block, settings);
        this.hasCustomTooltip = false;
    }

    public ModBlockItem(Block block, Settings settings, Boolean hasCustomTooltip) {
        super(block, settings);
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (UbesDelightMod.CONFIG.isFoodEffectTooltip()) {//TODO: add config Block tooltips? V0.1.4
            if (hasCustomTooltip) {
                tooltip.add(UbesDelightMod.tooltip("tooltip." + this).formatted(Formatting.GRAY));
            }
        }
    }
}