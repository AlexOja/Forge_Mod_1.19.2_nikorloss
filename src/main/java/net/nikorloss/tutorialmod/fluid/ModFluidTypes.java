package net.nikorloss.tutorialmod.fluid;

import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.nikorloss.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes implements SimpleWaterloggedBlock {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation SCULK_OVERLAY_RL = new ResourceLocation(TutorialMod.MOD_ID, "misc/in_sculk_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<FluidType> SCULK_WATER_FLUID_TYPE = register("sculk_water_fluid",
            FluidType.Properties.create().lightLevel(12).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, SCULK_OVERLAY_RL,
                0xA13A938C, new Vector3f(58f / 255f, 147f / 255f, 140f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}