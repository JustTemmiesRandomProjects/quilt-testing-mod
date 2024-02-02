package mom.beaver.first_mod.blocks.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GravityAttractorEntity extends BlockEntity {
	public GravityAttractorEntity(BlockPos pos, BlockState state) {
		super(BlockEntityType.FURNACE, pos, state);
		System.out.println("created new block entity");
	}

	public static void tick(World world, BlockPos pos, BlockState state, GravityAttractorEntity blockEntity) {
		System.out.println("tick");
	}
}
