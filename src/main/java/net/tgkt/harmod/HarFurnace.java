package net.tgkt.harmod;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HarFurnace extends AbstractFurnaceBlock {
    public HarFurnace(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new HarFurnaceBlockEntity();
    }

    @Override
    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        // This is called from the onUse method on the AbstractFurnaceBlock so it's a bit different from a normal container block
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof HarFurnaceBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            // Counts as an interaction with a furnace, so we increment the stat
            player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }
    }
}
