package mom.beaver.first_mod.blocks;

import mom.beaver.first_mod.blocks.entities.GravityAttractorEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

import java.util.function.Supplier;

public class GravityAttractor extends BlockWithEntity {
	public static final BlockEntityType<GravityAttractorEntity> GRAVITY_ATTRACTOR_ENTITY_BLOCK_ENTITY_TYPE;
	public GravityAttractor(Settings settings) {
		super(settings);
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new GravityAttractorEntity(pos, state);
	}

	public BlockRenderType getRenderType(BlockState state) {
		System.out.println("get render type");
		return BlockRenderType.MODEL;
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return checkType(world, type, GRAVITY_ATTRACTOR_ENTITY_BLOCK_ENTITY_TYPE);
	}
}
