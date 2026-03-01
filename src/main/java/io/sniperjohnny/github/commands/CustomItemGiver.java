package io.sniperjohnny.github.commands;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.CustomModelData;
import io.papermc.paper.datacomponent.item.Equippable;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import io.sniperjohnny.github.ServerPlugin;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CustomItemGiver implements TabExecutor {
    public static ItemStack getdevil_horns() {
        ItemStack item = ItemStack.of(Material.PAPER);
        ItemMeta meta = item.getItemMeta();


        // 1. Verzauberungen (Wie bisher)
        meta.addEnchant(Enchantment.PROTECTION, 6, true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION, 6, true);
        meta.addEnchant(Enchantment.UNBREAKING, 6, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.RESPIRATION, 6, true);
        meta.addEnchant(Enchantment.AQUA_AFFINITY, 6, true);

        // 2. Lore mit modernem Adventure-Format (verhindert Kursivschrift)
        meta.lore(List.of(
                Component.text("With this you are partly the Devil", NamedTextColor.DARK_RED)
                        .decoration(TextDecoration.ITALIC, false)
        ));

        // 3. Attribute direkt über meta hinzufügen (WICHTIG!)
        // Wir nutzen meta.addAttributeModifier statt DataComponentTypes, damit die
        // Standard-Rüstungswerte von Netherite erhalten bleiben.
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "devil_horns_stats");

        meta.addAttributeModifier(Attribute.MAX_HEALTH,
                new AttributeModifier(key, 20, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.GRAVITY,
                new AttributeModifier(key, -0.04, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.SAFE_FALL_DISTANCE,
                new AttributeModifier(key, 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(key, 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, new AttributeModifier(key, 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        // Meta speichern, bevor wir die speziellen Data-Komponenten setzen
        item.setItemMeta(meta);

        // 4. Die finalen Data-Komponenten setzen
        item.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HEAD));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Devil Horns", NamedTextColor.DARK_RED));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "devil_horns"));
        item.setData(DataComponentTypes.MAX_STACK_SIZE, 1);




        // Den Helm unsichtbar machen (Verweist auf deine invisible_armor_layer_1.png)


        // Name und Unzerstörbarkeit


        return item;
    }
    public static ItemStack getblue_kyoriu_horns() {
        ItemStack item = ItemStack.of(Material.BONE);
        ItemMeta meta = item.getItemMeta();


        // 1. Verzauberungen (Wie bisher)
        meta.addEnchant(Enchantment.PROTECTION, 4, true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION, 4, true);
        meta.addEnchant(Enchantment.UNBREAKING, 6, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.RESPIRATION, 4, true);
        meta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);

        // 2. Lore mit modernem Adventure-Format (verhindert Kursivschrift)
        meta.lore(List.of(
                Component.text("Become partly an different being", NamedTextColor.DARK_BLUE)
                        .decoration(TextDecoration.ITALIC, false)
        ));

        // 3. Attribute direkt über meta hinzufügen (WICHTIG!)
        // Wir nutzen meta.addAttributeModifier statt DataComponentTypes, damit die
        // Standard-Rüstungswerte von Netherite erhalten bleiben.
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "blue_kyoriu_horns_stats");

        meta.addAttributeModifier(Attribute.MAX_HEALTH,
                new AttributeModifier(key, 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(key, 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, new AttributeModifier(key, 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        // Meta speichern, bevor wir die speziellen Data-Komponenten setzen
        item.setItemMeta(meta);

        // 4. Die finalen Data-Komponenten setzen
        item.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HEAD));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Kyoriu Horns Blue", NamedTextColor.DARK_BLUE));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "hiros_kyoriu_horns"));
        item.setData(DataComponentTypes.MAX_STACK_SIZE, 1);




        // Den Helm unsichtbar machen (Verweist auf deine invisible_armor_layer_1.png)


        // Name und Unzerstörbarkeit


        return item;
    }
    public static ItemStack gethiros_kyoriu_horns() {
        ItemStack item = ItemStack.of(Material.BONE);
        ItemMeta meta = item.getItemMeta();


        // 1. Verzauberungen (Wie bisher)
        meta.addEnchant(Enchantment.PROTECTION, 8, true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION, 8, true);
        meta.addEnchant(Enchantment.UNBREAKING, 8, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.RESPIRATION, 8, true);
        meta.addEnchant(Enchantment.AQUA_AFFINITY, 8, true);

        // 2. Lore mit modernem Adventure-Format (verhindert Kursivschrift)
        meta.lore(List.of(
                Component.text("An reference to Hiro out of darling in the franxx.", NamedTextColor.DARK_BLUE)
                        .decoration(TextDecoration.ITALIC, false)
        ));

        // 3. Attribute direkt über meta hinzufügen (WICHTIG!)
        // Wir nutzen meta.addAttributeModifier statt DataComponentTypes, damit die
        // Standard-Rüstungswerte von Netherite erhalten bleiben.
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "hiros_kyoriu_horns_stats");

        meta.addAttributeModifier(Attribute.MAX_HEALTH,
                new AttributeModifier(key, 30, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(key, 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, new AttributeModifier(key, 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        // Meta speichern, bevor wir die speziellen Data-Komponenten setzen
        item.setItemMeta(meta);

        // 4. Die finalen Data-Komponenten setzen
        item.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HEAD));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Hiros Kyoriu Horns", NamedTextColor.DARK_BLUE));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "hiros_kyoriu_horns"));
        item.setData(DataComponentTypes.MAX_STACK_SIZE, 1);




        // Den Helm unsichtbar machen (Verweist auf deine invisible_armor_layer_1.png)


        // Name und Unzerstörbarkeit


        return item;
    }
    public static ItemStack get02_kyoriu_horns() {
        ItemStack item = ItemStack.of(Material.BONE);
        ItemMeta meta = item.getItemMeta();


        // 1. Verzauberungen (Wie bisher)
        meta.addEnchant(Enchantment.PROTECTION, 8, true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION, 8, true);
        meta.addEnchant(Enchantment.UNBREAKING, 8, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.RESPIRATION, 8, true);
        meta.addEnchant(Enchantment.AQUA_AFFINITY, 8, true);

        // 2. Lore mit modernem Adventure-Format (verhindert Kursivschrift)
        meta.lore(List.of(
                Component.text("An reference to 02 out of darling in the franxx.", NamedTextColor.DARK_RED)
                        .decoration(TextDecoration.ITALIC, false)
        ));

        // 3. Attribute direkt über meta hinzufügen (WICHTIG!)
        // Wir nutzen meta.addAttributeModifier statt DataComponentTypes, damit die
        // Standard-Rüstungswerte von Netherite erhalten bleiben.
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "02_kyoriu_horns_stats");

        meta.addAttributeModifier(Attribute.MAX_HEALTH,
                new AttributeModifier(key, 30, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(key, 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, new AttributeModifier(key, 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        // Meta speichern, bevor wir die speziellen Data-Komponenten setzen
        item.setItemMeta(meta);

        // 4. Die finalen Data-Komponenten setzen
        item.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HEAD));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("02 Kyoriu Horns", NamedTextColor.DARK_RED));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "02_kyoriu_horns"));
        item.setData(DataComponentTypes.MAX_STACK_SIZE, 1);




        return item;
    }

    public static ItemStack getred_kyoriu_horns() {
        ItemStack item = ItemStack.of(Material.BONE);
        ItemMeta meta = item.getItemMeta();


        // 1. Verzauberungen (Wie bisher)
        meta.addEnchant(Enchantment.PROTECTION, 4, true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION, 4, true);
        meta.addEnchant(Enchantment.UNBREAKING, 6, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.RESPIRATION, 4, true);
        meta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);

        // 2. Lore mit modernem Adventure-Format (verhindert Kursivschrift)
        meta.lore(List.of(
                Component.text("Become partly an different being", NamedTextColor.DARK_RED)
                        .decoration(TextDecoration.ITALIC, false)
        ));

        // 3. Attribute direkt über meta hinzufügen (WICHTIG!)
        // Wir nutzen meta.addAttributeModifier statt DataComponentTypes, damit die
        // Standard-Rüstungswerte von Netherite erhalten bleiben.
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "red_kyoriu_horns_stats");

        meta.addAttributeModifier(Attribute.MAX_HEALTH,
                new AttributeModifier(key, 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(key, 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, new AttributeModifier(key, 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        // Meta speichern, bevor wir die speziellen Data-Komponenten setzen
        item.setItemMeta(meta);

        // 4. Die finalen Data-Komponenten setzen
        item.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HEAD));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Kyoriu Horns Red", NamedTextColor.DARK_RED));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "02_kyoriu_horns"));
        item.setData(DataComponentTypes.MAX_STACK_SIZE, 1);




        // Den Helm unsichtbar machen (Verweist auf deine invisible_armor_layer_1.png)


        // Name und Unzerstörbarkeit


        return item;
    }
    public static ItemStack getbeater_of_death() {
        ItemStack item = ItemStack.of(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.SHARPNESS, 9, true);
        meta.addEnchant(Enchantment.LOOTING, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 1000, true);

        List<String> lore = new ArrayList<>();
        lore.add("§4The one who wields this weapon will be the Beater of Death");
        lore.add("§k§l§o You shall be immortal whilest you hold this weapon!");
        meta.setLore(lore);

        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "is_beaterofdeath");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        item.setItemMeta(meta);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "beater_of_death"));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Beater of Death", NamedTextColor.DARK_RED));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Beater of Death", NamedTextColor.DARK_RED));

        return item;
    }
    public static ItemStack getmurasame() {
        ItemStack item = ItemStack.of(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.SHARPNESS, 9, true);
        meta.addEnchant(Enchantment.LOOTING, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 10, true);
        meta.addEnchant(Enchantment.MENDING, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add("§4 This sword one shots anything but watch out don't cut yourself because it applies to you to!");
        meta.setLore(lore);

        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "is_murasame");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        item.setItemMeta(meta);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "murasame"));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Murasame", NamedTextColor.DARK_RED));
        item.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Murasame", NamedTextColor.DARK_RED));

        return item;
    }
    public static ItemStack getminerv1() {
        ItemStack item = ItemStack.of(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.EFFICIENCY, 6, true);
        meta.addEnchant(Enchantment.FORTUNE, 5, true);

        List<String> lore = new ArrayList<>();
        lore.add("§4 This is a strong drill");

        meta.setLore(lore);


        item.setItemMeta(meta);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "minerv1"));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Drill V1", NamedTextColor.DARK_GRAY));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Drill V1", NamedTextColor.DARK_GRAY));

        return item;
    }
    public static ItemStack getminerv2() {
        ItemStack item = ItemStack.of(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.EFFICIENCY, 8, true);
        meta.addEnchant(Enchantment.FORTUNE, 6, true);

        List<String> lore = new ArrayList<>();
        lore.add("§4 This is an Custom Drill in the 3 by 3 Version");
        meta.setLore(lore);

        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "is_hammer_3x3");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        item.setItemMeta(meta);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "minerv2"));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Drill V2", NamedTextColor.DARK_GRAY));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Drill V2", NamedTextColor.DARK_GRAY));

        return item;
    }
    public static ItemStack getminerv3() {
        ItemStack item = ItemStack.of(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
        meta.addEnchant(Enchantment.FORTUNE, 7, true);

        List<String> lore = new ArrayList<>();
        lore.add("§4 This is an Custom Drill in the 5 by 5 Version");
        meta.setLore(lore);
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "is_hammer_5x5");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        item.setItemMeta(meta);
        item.setData(DataComponentTypes.ITEM_MODEL, Key.key("sniperjohnny", "minerv3"));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Drill V3", NamedTextColor.DARK_GRAY));
        item.setData(DataComponentTypes.UNBREAKABLE);
        item.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Drill V3", NamedTextColor.DARK_GRAY));

        return item;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.DARK_RED + "This command is only for players.");
            return true;
        }

        if (args.length < 3) {
            p.sendMessage(ChatColor.RED + "Usage: /opci give/remove <player> <item>");
            return true;
        }

        String sub = args[0];
        String playerName = args[1];
        String itemName = args[2];

        if (!sub.equals("give")) {
            if (sub.equals("remove")){
                Player target = Bukkit.getPlayerExact(playerName);
                if (target == null) {
                    p.sendMessage(ChatColor.RED + "Player not found.");
                    return true;
                }

                if (itemName.equalsIgnoreCase("beater_of_death")) {
                    target.getInventory().removeItem(getbeater_of_death());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Beater of Death.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("devil_horns")) {
                    target.getInventory().removeItem(getdevil_horns());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Devilhorns.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("blue_kyoriu_horns")) {


                    target.getInventory().removeItem(getblue_kyoriu_horns());
                    target.getInventory().removeItem(gethiros_kyoriu_horns());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Kyoriu Horns Blue.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("red_kyoriu_horns")) {


                    target.getInventory().removeItem(getred_kyoriu_horns());
                    target.getInventory().removeItem(get02_kyoriu_horns());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Kyoriu Horns Red.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("minerv1")) {
                    target.getInventory().removeItem(getminerv1());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Minerv1.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("minerv2")) {
                    target.getInventory().removeItem(getminerv2());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Minerv1.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("minerv3")) {
                    target.getInventory().removeItem(getminerv3());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost the Minerv1.");
                    return true;
                }
                if (itemName.equalsIgnoreCase("murasame")) {
                    target.getInventory().removeItem(getmurasame());
                    p.sendMessage(ChatColor.BLACK + target.getName() + " has lost Murasame.");
                    return true;
                }

                p.sendMessage(ChatColor.RED + "Unknown item.");
                return true;

            }else {
                p.sendMessage("Unknown Command");
                return true;
            }

        }





        Player target = Bukkit.getPlayerExact(playerName);
        if (target == null) {
            p.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        if (itemName.equalsIgnoreCase("beater_of_death")) {
            if (!p.isOp()) {
                p.sendMessage("You Have no Permission of doing that!");
                return true;
            }
            target.getInventory().addItem(getbeater_of_death());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has become the Beater of Death.");
            return true;
        }
        if (itemName.equalsIgnoreCase("devil_horns")) {
            target.getInventory().addItem(getdevil_horns());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has become partly the Devil.");
            return true;
        }
        if (itemName.equalsIgnoreCase("blue_kyoriu_horns")) {
            if (target.getUniqueId().toString().equals("07cfe0f3-45d6-4c6f-9c07-d098c2cbe04a")) {
                target.getInventory().addItem(gethiros_kyoriu_horns());
            } else if (target.getUniqueId().toString().equals("ca82c640-1185-4c4f-850b-f90050a47684")) {
                target.getInventory().addItem(gethiros_kyoriu_horns());
            }
            target.getInventory().addItem(getblue_kyoriu_horns());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has gotten Kyoriu Horns Blue");
            return true;
        }
        if (itemName.equalsIgnoreCase("red_kyoriu_horns")) {
            if (target.getUniqueId().toString().equals("07cfe0f3-45d6-4c6f-9c07-d098c2cbe04a")) {
                target.getInventory().addItem(get02_kyoriu_horns());
            }
            else if (target.getUniqueId().toString().equals("ca82c640-1185-4c4f-850b-f90050a47684")) {
                target.getInventory().addItem(get02_kyoriu_horns());
            }
            target.getInventory().addItem(getred_kyoriu_horns());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has gotten Kyoriu Horns Red");
            return true;
        }

        if (itemName.equalsIgnoreCase("minerv1")) {
            target.getInventory().addItem(getminerv1());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has become a miner.");
            return true;
        }
        if (itemName.equalsIgnoreCase("minerv2")) {
            target.getInventory().addItem(getminerv2());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has become a stronger miner.");
            return true;
        }
        if (itemName.equalsIgnoreCase("minerv3")) {
            target.getInventory().addItem(getminerv3());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has become an even stronger miner.");
            return true;
        }
        if (itemName.equalsIgnoreCase("murasame")) {
            target.getInventory().addItem(getmurasame());
            p.sendMessage(ChatColor.BLACK + target.getName() + " has become a Demon at heart.");
            return true;
        }

        p.sendMessage(ChatColor.RED + "Unknown item.");
        return true;
    }

    @Override
    public @NotNull List<String> onTabComplete(@NotNull CommandSender sender,
                                               @NotNull Command command,
                                               @NotNull String label,
                                               @NotNull String[] args) {

        List<String> completions = new ArrayList<>();

        // /ci <subcommand>
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], List.of("give", "remove"), completions);
            return completions;
        }

        // /ci give <player>
        if (args.length == 2) {
            List<String> players = new ArrayList<>();
            for (Player p : Bukkit.getOnlinePlayers()) {
                players.add(p.getName());
            }
            StringUtil.copyPartialMatches(args[1], players, completions);
            return completions;
        }

        // /ci give <player> <item>
        if (args.length == 3) {
            StringUtil.copyPartialMatches(args[2], List.of("beater_of_death", "blue_kyoriu_horns","devil_horns",
                    "minerv1", "minerv2", "minerv3", "murasame", "red_kyoriu_horns"), completions);
            return completions;
        }

        return completions;
    }
}