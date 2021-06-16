package me.flappythebat.damageindicator.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.flappythebat.damageindicator.DamageIndicator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamage implements Listener {

    private DamageIndicator plugin;

    public PlayerDamage(DamageIndicator plugin) {
         this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {

        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player plr =  (Player) e.getEntity();
            Player damager = (Player) e.getDamager();

            String rawMessage = plugin.getConfig().getString("message");
            String message;
            String finalMessage;

            message = rawMessage.replaceAll("%attacker%", damager.getName())
                    .replaceAll("%damagedplayer%", plr.getName())
                    .replaceAll("%damagedplayerhealth%", String.valueOf(Math.round(plr.getHealth())))
                    .replaceAll("%damagedplayerhealth%", String.valueOf(Math.round(plr.getHealth())/2));

            if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                finalMessage = PlaceholderAPI.setPlaceholders(damager, message);
            } else {
                finalMessage = message;
            }

            if (plugin.getConfig().getBoolean("actionbar")) {
                damager.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(
                                ChatColor.translateAlternateColorCodes('&',finalMessage)
                        )
                );
            } else {
                damager.sendMessage(ChatColor.translateAlternateColorCodes('&',finalMessage));
            }
        }
    }
}
