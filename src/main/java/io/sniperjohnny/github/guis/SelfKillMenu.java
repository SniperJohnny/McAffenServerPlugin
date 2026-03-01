package io.sniperjohnny.github.guis;


import io.sniperjohnny.github.menu.SimpleMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SelfKillMenu  extends SimpleMenu {

    public SelfKillMenu() {
        super(Rows.ONE, "Beende dein Leiden!");
    }

    @Override
    public void onSetItems() {
        final ItemStack hold_it = new ItemStack(Material.TOTEM_OF_UNDYING);
        final ItemMeta hold_itmeta = hold_it.getItemMeta();
        hold_itmeta.displayName(Component.text("Then remain living! :)", NamedTextColor.GREEN));
        hold_it.setItemMeta(hold_itmeta);
        final ItemStack clearoffhand = new ItemStack(Material.AIR);
        final ItemStack killItem = new ItemStack(Material.SKELETON_SKULL);
        final ItemMeta killmeta = killItem.getItemMeta();
        killmeta.displayName(Component.text("Beende es.", NamedTextColor.DARK_RED));
        killItem.setItemMeta(killmeta);
        setItem(5, hold_it, player -> {
            player.sendRichMessage("<green> Dann leb ebend weiter!");
            player.getInventory().setItemInOffHand(hold_it);
            player.damage(20);
            player.closeInventory();
            player.setHealth(20);
            player.getInventory().setItemInOffHand(clearoffhand);
        });
       setItem(3, killItem, player -> {
            player.sendRichMessage("<red> Du hast es Beendet!");
            player.setHealth(0);
            player.closeInventory();
            player.setDeathScreenScore(404);
       });
    }
}
