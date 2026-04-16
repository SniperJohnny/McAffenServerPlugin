package io.sniperjohnny.github;

import io.papermc.paper.connection.PlayerConfigurationConnection;
import io.papermc.paper.event.connection.configuration.AsyncPlayerConnectionConfigureEvent;
import io.sniperjohnny.github.Listeners.BlockBreakListener;
import io.sniperjohnny.github.Listeners.DamageListener;
import io.sniperjohnny.github.Listeners.Inventory_Listeners;
import io.sniperjohnny.github.commands.*;
import net.kyori.adventure.resource.ResourcePackCallback;
import net.kyori.adventure.resource.ResourcePackInfo;
import net.kyori.adventure.resource.ResourcePackRequest;
import net.kyori.adventure.text.Component;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ServerPlugin extends JavaPlugin implements Listener {

    private static ServerPlugin instance;
   /* public static boolean accepted;
    private static ResourcePackInfo packInfo;
    @Override
    public void onLoad() {
    //runs first
        instance = this;
        saveDefaultConfig();
        final CompletableFuture<ResourcePackInfo> future = ResourcePackInfo.resourcePackInfo().
                id(UUID.fromString("07cfe0f3-45d6-4c6f-9c07-d098c2cbe04a"))
                .uri(URI.create(
                        "https://download.mc-packs.net/pack/98e1934b22482f4ce266234ee168443e86f944c7.zip"
                        )).computeHashAndBuild();

        future.thenAccept(pack -> {
            packInfo = pack;
        });

    }
    @EventHandler
    public void onConfigure(AsyncPlayerConnectionConfigureEvent e) {
        final PlayerConfigurationConnection connection = e.getConnection();
        final CompletableFuture<Boolean> acceptedFuture = new CompletableFuture<>();
        connection.getAudience().sendResourcePacks(ResourcePackRequest.resourcePackRequest()
                .packs(packInfo)
                .callback(ResourcePackCallback.onTerminal((
                        packid, audience) -> {
                    acceptedFuture.complete(true);
        }, (packid, audience)-> {
                    acceptedFuture.complete(false);
                        }
                ))

        );
        accepted = acceptedFuture.join();


    }
    */
    @Override
    public void onDisable() {
        //runs third
    }
    @Override
    public void onEnable() {
        //runs second

       getServer().getPluginManager().registerEvents(new Listeners_joinMessage(), this);
       getServer().getPluginManager().registerEvents( this, this);
       getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
       getLogger().info("Hello from the affenserverplugin");
       getCommand("fliegen").setExecutor(new FlyCommand());
       getCommand("maxh").setExecutor(new HealthScaleCommand());
       getCommand("endit").setExecutor(new End_itCommand());
       getCommand("adminshop").setExecutor(new adminshopcommand());
       getCommand("opcustomitem").setExecutor(new CustomItemGiver());
       getServer().getPluginManager().registerEvents(new Inventory_Listeners(), this);
       getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }
    public static ServerPlugin getInstance() {
        return instance;
    }


}
