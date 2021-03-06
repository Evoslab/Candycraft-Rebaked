package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.CookieCrouperEntity;
import com.evo.candycraft.common.entities.OreoCookieCrouperEntity;
import com.evo.candycraft.common.entities.StrawberryCookieCrouperEntity;
import com.evo.candycraft.common.entities.SweetberryCookieCrouperEntity;
import com.minecraftabnormals.abnormals_core.core.util.registry.EntitySubRegistryHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class CandyCraftEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CandyCraft.MODID);

    public static EntityType<CookieCrouperEntity> COOKIE_CROUPER_TYPE;
    public static EntityType<StrawberryCookieCrouperEntity> STRAWBERRY_COOKIE_CROUPER_TYPE;
    public static EntityType<SweetberryCookieCrouperEntity> SWEETBERRY_COOKIE_CROUPER_TYPE;
    public static EntityType<OreoCookieCrouperEntity> OREO_COOKIE_CROUPER_TYPE;

    public static final RegistryObject<EntityType<CookieCrouperEntity>> COOKIE_CROUPER = register("cookie_crouper", () -> COOKIE_CROUPER_TYPE);
    public static final RegistryObject<EntityType<StrawberryCookieCrouperEntity>> STRAWBERRY_COOKIE_CROUPER = register("strawberry_cookie_crouper", () -> STRAWBERRY_COOKIE_CROUPER_TYPE);
    public static final RegistryObject<EntityType<SweetberryCookieCrouperEntity>> SWEETBERRY_COOKIE_CROUPER = register("sweetberry_cookie_crouper", () -> SWEETBERRY_COOKIE_CROUPER_TYPE);
    public static final RegistryObject<EntityType<OreoCookieCrouperEntity>> OREO_COOKIE_CROUPER = register("oreo_cookie_crouper", () -> OREO_COOKIE_CROUPER_TYPE);


    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(STRAWBERRY_COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SWEETBERRY_COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(OREO_COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
    }

    public static void initEntityTypes() {
        COOKIE_CROUPER_TYPE = EntityType.Builder.create(CookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("cookie_crouper");
        STRAWBERRY_COOKIE_CROUPER_TYPE = EntityType.Builder.create(StrawberryCookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("strawberry_cookie_crouper");
        SWEETBERRY_COOKIE_CROUPER_TYPE = EntityType.Builder.create(SweetberryCookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("sweetberry_cookie_crouper");
        OREO_COOKIE_CROUPER_TYPE = EntityType.Builder.create(OreoCookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("oreo_cookie_crouper");
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> entityTypeSupplier) {
        return ENTITIES.register(name, entityTypeSupplier);
    }
}

