package me.flappythebat.damageindicator;

import me.flappythebat.damageindicator.commands.DamageIndicatorCmd;
import me.flappythebat.damageindicator.events.PlayerDamage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class DamageIndicator extends JavaPlugin {

    Logger logger = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerDamage(this), this);
        getCommand("di").setExecutor(new DamageIndicatorCmd());
        getCommand("damageindicator").setExecutor(new DamageIndicatorCmd());

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            logger.info(ChatColor.BLUE + "Hooked into PlaceholderAPI!");
        }

        logger.info(ChatColor.GREEN+"Started!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info(ChatColor.GREEN+"Stopped. Bye!");
    }
}
