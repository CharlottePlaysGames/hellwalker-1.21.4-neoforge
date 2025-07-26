package com.jinxedstudios.hellwalker;

import com.jinxedstudios.hellwalker.entities.HellwalkerEntities;
import com.jinxedstudios.hellwalker.entities.hellmarked_human_skull.HellmarkedHumanSkullRenderer;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistRenderer;
import com.jinxedstudios.hellwalker.entities.unwilling.UnwillingRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = Hellwalker.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = Hellwalker.MODID, value = Dist.CLIENT)
public class HellwalkerClient {
    public HellwalkerClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Hellwalker.LOGGER.info("HELLO FROM CLIENT SETUP");
        Hellwalker.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        EntityRenderers.register(HellwalkerEntities.POSSESSED_SCIENTIST.get(), PossessedScientistRenderer::new);
        EntityRenderers.register(HellwalkerEntities.UNWILLING.get(), UnwillingRenderer::new);
        EntityRenderers.register(HellwalkerEntities.HELLMARKED_HUMAN_SKULL.get(), HellmarkedHumanSkullRenderer::new);

    }
}
