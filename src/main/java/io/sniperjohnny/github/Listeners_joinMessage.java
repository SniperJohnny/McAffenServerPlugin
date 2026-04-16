package io.sniperjohnny.github;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners_joinMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GREEN + "Herzlich Willkommen zurück auf play.mcaffen.de: " + p.getName() + ".");
        } else {
            e.setJoinMessage(ChatColor.GREEN + "Herzlich Willkommen auf play.mcaffen.de: " + p.getName() + " Wir Hoffen, dass du viel Spaß haben wirst!");
        }
        p.setInvulnerable(false);



    }

    public void onPlayerLeaveEvent(PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.RED + "Wir hoffen dich wiederzusehen " + p.getName() + " auf play.mcaffen.de");
    }
}