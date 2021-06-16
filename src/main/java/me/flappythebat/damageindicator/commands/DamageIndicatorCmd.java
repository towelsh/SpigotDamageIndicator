package me.flappythebat.damageindicator.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

import static org.bukkit.Bukkit.getLogger;

public class DamageIndicatorCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Logger logger = getLogger();

        if (sender instanceof Player) {
            Player plr = (Player) sender;
            plr.sendMessage(ChatColor.AQUA+"This server is running "+ChatColor.GOLD+"DamageIndicator v1.1");
        } else {
            logger.info(ChatColor.AQUA+"This server is running "+ChatColor.GOLD+"DamageIndicator v1.1");
        }

        return true;
    }
}
