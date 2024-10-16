package uwu.fluttercat.chlorophyte.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ChlorophyteBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    public ChlorophyteBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
//hardcoded particles go brrrr
        if (!world.isClient()) {
            world.setBlockState(pos, state.cycle(LIT));
        }
            world.addParticle(ParticleTypes.ENCHANTED_HIT,
                pos.getX()+0.5,
                pos.getY()+0.5,
                pos.getZ()+0.5,
                0.0,1.0,0.0);
            world.addParticle(ParticleTypes.ENCHANTED_HIT,
                pos.getX()+0.5,
                pos.getY()+0.5,
                pos.getZ()+0.5,
                0.0,-1.0,0.0);
            world.addParticle(ParticleTypes.ENCHANTED_HIT,
                pos.getX()+0.5,
                pos.getY()+0.5,
                pos.getZ()+0.5,
                1.0,0.0,0.0);
            world.addParticle(ParticleTypes.ENCHANTED_HIT,
                pos.getX()+0.5,
                pos.getY()+0.5,
                pos.getZ()+0.5,
                -1.0,0.0,0.0);
            world.addParticle(ParticleTypes.ENCHANTED_HIT,
                pos.getX()+0.5,
                pos.getY()+0.5,
                pos.getZ()+0.5,
                0.0,0.0,1.0);
            world.addParticle(ParticleTypes.ENCHANTED_HIT,
                pos.getX()+0.5,
                pos.getY()+0.5,
                pos.getZ()+0.5,
                0.0,0.0,-1.0);
        world.playSound(player, pos, SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE.value(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(LIT)) {
            return VoxelShapes.empty();
        }
        return VoxelShapes.fullCube();
    }
}

