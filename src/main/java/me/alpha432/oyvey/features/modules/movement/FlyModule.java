package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class FlyModule extends Module {
    private final Setting<Float> speed = num("Speed", 2f, 0.1f, 10f);

    public FlyModule() {
        super("Fly", "fly..", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().mayfly = true;
        mc.player.onUpdateAbilities();
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;
        mc.player.getAbilities().flying = false;
        mc.player.getAbilities().mayfly = false;
        mc.player.onUpdateAbilities();
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        mc.player.getAbilities().mayfly = true;
        mc.player.getAbilities().setFlyingSpeed(speed.getValue() * 0.05f);
        mc.player.onUpdateAbilities();
    }
}
