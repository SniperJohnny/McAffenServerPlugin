package io.sniperjohnny.github.commands;

import io.sniperjohnny.github.guis.Shop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class adminshopcommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(sender instanceof final Player p))
        {
            sender.sendMessage("Der Befehl ist nur für spieler");
            return true;
        }
        new Shop().open(p);
        return true;
    }
}
