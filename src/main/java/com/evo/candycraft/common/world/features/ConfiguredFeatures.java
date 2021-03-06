package com.evo.candycraft.common.world.features;

import com.evo.candycraft.common.core.registry.CandyCraftFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ConfiguredFeatures {

    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> CANDY_CANE_TREE_FEATURE;

    public static void register() {
        CANDY_CANE_TREE_FEATURE = register("candy_cane_tree", CandyCraftFeatures.CANDY_CANE_TREE.get().withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()), new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0), new StraightTrunkPlacer(0, 0, 0), new TwoLayerFeature(0, 0, 0)).setIgnoreVines().build()));
    }

    private static <C extends IFeatureConfig> ConfiguredFeature<C, ?> register(String key, ConfiguredFeature<C, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
