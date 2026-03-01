package io.sniperjohnny.github.guis;

import io.sniperjohnny.github.commands.CustomItemGiver;
import io.sniperjohnny.github.menu.SimpleMenu;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;



public class Shop extends SimpleMenu {
    public Shop() {
        super(Rows.FIVE, "Admin Shop");
    }

    @Override
    public void onSetItems() {
        // We use a final array so we can modify the value inside the lambda
        final int[] quantity = {1};

        // We need a way to redraw the items whenever a button is clicked
        Runnable refresh = () -> {
            // Create the items with the NEW quantity
            ItemStack showQuantityItem = new ItemStack(Material.PAPER, quantity[0]);
            ItemStack netheriteBlocks = new ItemStack(Material.NETHERITE_BLOCK, quantity[0]);
            ItemStack BedrockBlocks = new ItemStack(Material.BEDROCK, quantity[0]);
            ItemStack GrassBlock = new ItemStack(Material.GRASS_BLOCK, quantity[0]);
            ItemStack NotchApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, quantity[0]);
            ItemStack DiamondBlocks = new ItemStack(Material.DIAMOND_BLOCK, quantity[0]);
            ItemStack Netherite_helmet = new ItemStack(Material.NETHERITE_HELMET, 1);
            Netherite_helmet.addEnchantment(Enchantment.PROTECTION, 4);
            Netherite_helmet.addEnchantment(Enchantment.UNBREAKING, 3);
            Netherite_helmet.addEnchantment(Enchantment.MENDING, 1);
            Netherite_helmet.addEnchantment(Enchantment.RESPIRATION, 3);
            Netherite_helmet.addEnchantment(Enchantment.AQUA_AFFINITY, 1);
            ItemStack Netherite_Chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
            Netherite_Chestplate.addEnchantment(Enchantment.PROTECTION, 4);
            Netherite_Chestplate.addEnchantment(Enchantment.UNBREAKING, 3);
            Netherite_Chestplate.addEnchantment(Enchantment.MENDING, 1);
            ItemStack Netherite_Leggings = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
            Netherite_Leggings.addEnchantment(Enchantment.PROTECTION, 4);
            Netherite_Leggings.addEnchantment(Enchantment.UNBREAKING, 3);
            Netherite_Leggings.addEnchantment(Enchantment.MENDING, 1);
            Netherite_Leggings.addEnchantment(Enchantment.SWIFT_SNEAK, 3);
            ItemStack Netherite_Boots = new ItemStack(Material.NETHERITE_BOOTS, 1);
            Netherite_Boots.addEnchantment(Enchantment.PROTECTION, 4);
            Netherite_Boots.addEnchantment(Enchantment.UNBREAKING, 3);
            Netherite_Boots.addEnchantment(Enchantment.MENDING, 1);
            Netherite_Boots.addEnchantment(Enchantment.FEATHER_FALLING, 4);
            Netherite_Boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
            ItemStack Netherite_Sword = new ItemStack(Material.NETHERITE_SWORD, 1);
            Netherite_Sword.addEnchantment(Enchantment.SHARPNESS, 5);
            Netherite_Sword.addEnchantment(Enchantment.UNBREAKING, 3);
            Netherite_Sword.addEnchantment(Enchantment.MENDING, 1);
            Netherite_Sword.addEnchantment(Enchantment.SWEEPING_EDGE, 3);
            Netherite_Sword.addEnchantment(Enchantment.LOOTING, 3);
            Netherite_Sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
            ItemStack Totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);


            // Update the slots
            setItem(40, showQuantityItem);
            setItem(23, Netherite_helmet, player -> {
                player.getInventory().addItem(Netherite_helmet);
                System.out.println(player.getName() + " has bought a Netherite Helmet");
            });
            setItem(24, Netherite_Chestplate, player -> {
                player.getInventory().addItem(Netherite_Chestplate);
                System.out.println(player.getName() + " has bought a Netherite Chestplate");
            });
            setItem(25, Netherite_Leggings, player -> {
                player.getInventory().addItem(Netherite_Leggings);
                System.out.println(player.getName() + " has bought a Netherite Leggings");
            });
            setItem(26, Netherite_Boots, player -> {
                player.getInventory().addItem(Netherite_Boots);
                System.out.println(player.getName() + " has bought a Netherite Boots");
            });
            setItem(22, netheriteBlocks, player -> {
                player.getInventory().addItem(netheriteBlocks);
                System.out.println(player.getName() + "has bought "+ quantity[0] + " Netherite Blocks");
            });
            setItem(21, BedrockBlocks, player -> {
                player.getInventory().addItem(BedrockBlocks);
                System.out.println(player.getName() + "has bought "+ quantity[0] + " Bedrock");
            });
            setItem(20, GrassBlock, player -> {
                player.getInventory().addItem(GrassBlock);
                System.out.println(player.getName() + "has bought "+ quantity[0] + " Grass_Blocks");
            });
            setItem(19, NotchApple, player -> {
                player.getInventory().addItem(NotchApple);
                System.out.println(player.getName() + "has bought "+ quantity[0] + " Notch Apples");
            });
            setItem(18, DiamondBlocks, player -> {
                player.getInventory().addItem(DiamondBlocks);
                System.out.println(player.getName() + "has bought "+ quantity[0] + " Diamond Blocks");
            });
            setItem(17, Totem, player -> {
                player.getInventory().addItem(Totem);
                System.out.println(player.getName() + "has bought "+ 1 + " Totem");

            });
            setItem(0, CustomItemGiver.getblue_kyoriu_horns(), player -> {
               player.getInventory().addItem(CustomItemGiver.getblue_kyoriu_horns());
                System.out.println(player.getName() + "has bought blue kyoriu horns");
            });
            setItem(1, CustomItemGiver.getred_kyoriu_horns(), player -> {
                player.getInventory().addItem(CustomItemGiver.getred_kyoriu_horns());
                System.out.println(player.getName() + "has bought red kyoriu horns");
            });
            setItem(2, CustomItemGiver.getdevil_horns(), player -> {
                player.getInventory().addItem(CustomItemGiver.getdevil_horns());
                System.out.println(player.getName() + "has bought devilhorns");
            });
            setItem(3, CustomItemGiver.getminerv1(), player -> {
                player.getInventory().addItem(CustomItemGiver.getminerv1());
                System.out.println(player.getName() + "has bought Miner V1");
            });
            setItem(4, CustomItemGiver.getminerv2(), player -> {
                player.getInventory().addItem(CustomItemGiver.getminerv2());
                System.out.println(player.getName() + "has bought Miner V2");
            });
            setItem(5, CustomItemGiver.getminerv3(), player -> {
                player.getInventory().addItem(CustomItemGiver.getminerv3());
                System.out.println(player.getName() + "has bought Miner V3");
            });


        };

        // Initial draw
        refresh.run();
        // RED BUTTONS (Subtraction) - Clamp between 1 and 64
        setItem(42, new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1), player -> {
            quantity[0] = Math.min(64, quantity[0] + 1);
            refresh.run();
        });

        setItem(43, new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 16), player -> {
            // If adding 16 goes over 64, snap it to 64
            if (quantity[0] + 16 > 64) quantity[0] = 64;
            else quantity[0] += 16;
            refresh.run();
        });

        setItem(44, new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 32), player -> {
            // If adding 32 goes over 64, snap it to 64
            if (quantity[0] + 32 > 64) quantity[0] = 64;
            else quantity[0] += 32;
            refresh.run();
        });

// RED BUTTONS (Subtraction)
        setItem(38, new ItemStack(Material.RED_STAINED_GLASS_PANE, 1), player -> {
            quantity[0] = Math.max(1, quantity[0] - 1);
            refresh.run();
        });

        setItem(37, new ItemStack(Material.RED_STAINED_GLASS_PANE, 16), player -> {
            // If subtracting 16 goes below 1, snap it to 1
            if (quantity[0] - 16 < 1) quantity[0] = 1;
            else quantity[0] -= 16;
            refresh.run();
        });

        setItem(36, new ItemStack(Material.RED_STAINED_GLASS_PANE, 32), player -> {
            // If subtracting 32 goes below 1, snap it to 1
            if (quantity[0] - 32 < 1) quantity[0] = 1;
            else quantity[0] -= 32;
            refresh.run();
        });
    }
}
