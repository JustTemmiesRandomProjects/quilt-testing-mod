package mom.beaver.first_mod.Registries;

import mom.beaver.first_mod.FirstMod;
import mom.beaver.first_mod.blocks.GravityAttractor;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Blocks {
	static ArrayList<Object[]> itemList = new ArrayList<>();

	public static void init() {
		registerBlockAndItem("gravity_attractor", new GravityAttractor(AbstractBlock.Settings.create()), new QuiltItemSettings());

		modifyItemGroups();
	}

	private static void registerBlockAndItem(String ID, Block block, QuiltItemSettings itemSettings) {
		Registry.register(Registries.BLOCK, new Identifier(FirstMod.ID, ID), block);
		Item item = new BlockItem(block, itemSettings);
		Registry.register(Registries.ITEM, new Identifier(FirstMod.ID, ID), item);
		itemList.add(new Object[]{ID, item, block});
	}

	private static void modifyItemGroups() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE_BLOCKS).register(entries -> {
			for (Object[] innerList : itemList) {
				entries.addItem(((Block) innerList[2]).asItem());
			}
		});
	}
}
