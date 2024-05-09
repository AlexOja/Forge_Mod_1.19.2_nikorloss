package net.nikorloss.tutorialmod.fluid;

import net.nikorloss.tutorialmod.TutorialMod;
import net.nikorloss.tutorialmod.block.ModBlocks;
import net.nikorloss.tutorialmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, TutorialMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_SCULK_WATER = FLUIDS.register("sculk_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SCULK_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SCULK_WATER = FLUIDS.register("flowing_sculk_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SCULK_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SCULK_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SCULK_WATER_FLUID_TYPE, SOURCE_SCULK_WATER, FLOWING_SCULK_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.SCULK_WATER_BLOCK)
            .bucket(ModItems.SCULK_WATER_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}