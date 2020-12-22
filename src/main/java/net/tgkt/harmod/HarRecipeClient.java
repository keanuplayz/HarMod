package net.tgkt.harmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class HarRecipeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(HarCookingRecipe.HAR_FURNACE_SCREEN_HANDLER, HarFurnaceScreen::new);
    }
}
