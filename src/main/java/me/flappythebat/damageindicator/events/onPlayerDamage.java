package me.flappythebat.damageindicator.events;

import me.flappythebat.damageindicator.DamageIndicator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onPlayerDamage implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player plr =  (Player) e.getEntity();
            Player damager = (Player) e.getDamager();
            damager.spigot().sendMessage(
                    ChatMessageType.ACTION_BAR,
                    new TextComponent(ChatColor.RED+plr.getName()+ChatColor.DARK_AQUA+" has "+ChatColor.RED+"❤"+String.valueOf(Math.round(plr.getHealth())))
            );
        }
    }
}
