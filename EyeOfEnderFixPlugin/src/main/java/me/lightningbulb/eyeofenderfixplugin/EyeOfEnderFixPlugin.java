package me.lightningbulb.eyeofenderfixplugin;

import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EyeOfEnderFixPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[EyeOfEnderFixPlugin] EyeOfEnderFixPlugin is active");

        //register holding compass listener
        new ThrowListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[EyeOfEnderFixPlugin] EyeOfEnderFixPlugin is shutting down");
    }
}

class ThrowListener implements Listener {

    private final EyeOfEnderFixPlugin plugin;

    public ThrowListener(EyeOfEnderFixPlugin plugin) {
        this.plugin = plugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void changeEyePosition(EntitySpawnEvent e) {

        if (e.getEntityType() == EntityType.ENDER_SIGNAL) {

            EnderSignal eye = (EnderSignal) e.getEntity();

            //shift target over 4 blocks on both axes
            eye.setTargetLocation(eye.getTargetLocation().add(4,0,4));
        }

    }

}
