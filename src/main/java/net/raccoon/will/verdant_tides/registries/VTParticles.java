package net.raccoon.will.verdant_tides.registries;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;

import java.util.function.Supplier;

public class VTParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, VerdantTides.MODID);

    public static final Supplier<SimpleParticleType> NOTE_PARTICLE = PARTICLE_TYPES.register("note_particle", () -> new SimpleParticleType(true));




    public static void register(IEventBus eventBus) {PARTICLE_TYPES.register(eventBus);
    }
}
