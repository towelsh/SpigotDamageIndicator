package me.flappythebat.damageindicator;

import me.flappythebat.damageindicator.commands.DamageIndicatorCmd;
import me.flappythebat.damageindicator.events.onPlayerDamage;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class DamageIndicator extends JavaPlugin {

    Logger logger = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("<DEBUG> Registering events...");
        getServer().getPluginManager().registerEvents(new onPlayerDamage(), this);
        logger.info("<DEBUG> Registering commands...");
        getCommand("di").setExecutor(new DamageIndicatorCmd());
        getCommand("damageindicator").setExecutor(new DamageIndicatorCmd());
        logger.info("Started!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Stopped. Bye!");
    }
}
