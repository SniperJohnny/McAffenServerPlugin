package io.sniperjohnny.github.commands;

import io.sniperjohnny.github.guis.SelfKillMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class End_itCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if(!(sender instanceof final Player p)) {
            sender.sendMessage(ChatColor.DARK_RED+ "this command is only for Players");
            return true;
        }

        new SelfKillMenu().open(p);
        return true;
    }
}
