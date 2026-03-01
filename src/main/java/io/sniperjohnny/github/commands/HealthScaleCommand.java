package io.sniperjohnny.github.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.codehaus.plexus.util.StringUtils;
import org.jetbrains.annotations.NotNull;

public class HealthScaleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

    if(!(sender instanceof final Player p)) {
        sender.sendMessage(ChatColor.DARK_RED + "Du kannst das nicht tun(kein PLayer)");
        return true;
    }
if (args.length <1) {
    p.sendMessage(ChatColor.RED + "Nutzen: /" + s + "<hearts>");
    return true;
}
    String heartsargument =args[0];

    if (!StringUtils.isNumeric(heartsargument)) {
        p.sendMessage(ChatColor.DARK_RED + "Bitte nur eine Nummer über 0 eingeben.");
        return true;
    }

    int hearts = Integer.parseInt(heartsargument);
    if (hearts < 0) {
        p.sendMessage(ChatColor.DARK_RED + "Bitte nur eine Nummer über 0 eingeben.");
    }
    p.setHealthScale(hearts);
    p.sendMessage(ChatColor.DARK_GREEN + "Deine Herzen wurden gesetzt");
        return true;
    }
}
