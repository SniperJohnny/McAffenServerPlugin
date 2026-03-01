package io.sniperjohnny.github.Listeners;

import io.sniperjohnny.github.ServerPlugin;
import io.sniperjohnny.github.commands.CustomItemGiver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.ArmorStand;


public class DamageListener implements Listener {

    private static final int MAX_CURSE_STACKS = 5;

    // ------------------------------------------------------------
    //  MURASAME DAMAGE LISTENER
    // ------------------------------------------------------------
    @EventHandler
    public void murasameDamageListener(EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player p)) return;
        if (!isHoldingMurasame(p)) return;

        Entity hit = e.getEntity();

        // Start spreading curse on first hit
        if (hit instanceof LivingEntity living) {
            startCurseSpread(living);
        }

        // 5% chance to cut yourself if not OP and attacking too fast
        if (!p.isOp() && p.getAttackCooldown() <= 0.9) {
            if (Math.random() < 0.25) {

                p.sendMessage("§4 You have cut yourself, prepare for death!");

                Bukkit.getScheduler().runTaskLater(ServerPlugin.getInstance(), () -> {

                    p.setHealth(0);

                    ItemStack weapon = p.getInventory().getItemInMainHand();
                    Component message = Component.text(p.getName(), NamedTextColor.DARK_RED)
                            .append(Component.text(" has cut himself ", NamedTextColor.GRAY))
                            .append(
                                    Component.text(weapon.getItemMeta().getDisplayName(), NamedTextColor.DARK_RED)
                                            .hoverEvent(weapon.asHoverEvent())
                            );

                    Bukkit.getServer().sendMessage(message);

                    World world = p.getWorld();
                    world.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 3f, 1f);
                    world.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_DEATH, 1.2f, 1.3f);
                    world.spawnParticle(Particle.SOUL, p.getLocation(), 20);
                    world.spawnParticle(Particle.SOUL_FIRE_FLAME, p.getLocation(), 20);

                }, 50);
            }
        }
    }

    // ------------------------------------------------------------
    //  SPREADING CURSE SYSTEM
    // ------------------------------------------------------------
    private void startCurseSpread(LivingEntity entity) {

        NamespacedKey activeKey = new NamespacedKey(ServerPlugin.getInstance(), "murasame_curse_active");

        // Already cursed → do nothing
        if (entity.getPersistentDataContainer().has(activeKey, PersistentDataType.BYTE)) {
            return;
        }

        // Mark as cursed
        entity.getPersistentDataContainer().set(activeKey, PersistentDataType.BYTE, (byte) 1);

        beginCurseTask(entity);
    }

    private void beginCurseTask(LivingEntity entity) {

        NamespacedKey stackKey = new NamespacedKey(ServerPlugin.getInstance(), "murasame_curse_stacks");

        Bukkit.getScheduler().runTaskTimer(ServerPlugin.getInstance(), task -> {

            if (!entity.isValid() || entity.isDead()) {
                task.cancel();
                return;
            }

            int stacks = entity.getPersistentDataContainer().getOrDefault(stackKey, PersistentDataType.INTEGER, 0);

            // Add inscription
            spawnInscription(entity);

            stacks++;
            entity.getPersistentDataContainer().set(stackKey, PersistentDataType.INTEGER, stacks);

            // Fully covered → kill
            if (stacks >= MAX_CURSE_STACKS) {
                killCursedEntity(entity);
                task.cancel();
            }

        }, 0, 10); // every 10 ticks (0.5 seconds)
    }

    private void spawnInscription(LivingEntity entity) {

        Location base = entity.getLocation().add(0, 1.0, 0);

        double x = (Math.random() - 0.5) * 0.6;
        double y = Math.random() * 1.4;
        double z = (Math.random() - 0.5) * 0.6;

        Location loc = base.clone().add(x, y, z);

        ArmorStand stand = loc.getWorld().spawn(loc, ArmorStand.class, as -> {
            as.setInvisible(true);
            as.setMarker(true);
            as.setCustomNameVisible(true);
            as.customName(Component.text("§4§l✦"));
            as.setGravity(false);
            as.setSmall(true);
        });

        // Float upward
        Bukkit.getScheduler().runTaskTimer(ServerPlugin.getInstance(), task -> {
            if (!stand.isValid()) {
                task.cancel();
                return;
            }
            stand.teleport(stand.getLocation().add(0, 0.01, 0));
        }, 1, 1);

        // Remove after 1.5 seconds
        Bukkit.getScheduler().runTaskLater(ServerPlugin.getInstance(), stand::remove, 30);
    }

    private void killCursedEntity(LivingEntity entity) {

        World world = entity.getWorld();

        world.spawnParticle(Particle.SOUL_FIRE_FLAME, entity.getLocation(), 40, 0.5, 1, 0.5, 0.02);
        world.spawnParticle(Particle.SOUL, entity.getLocation(), 40, 0.5, 1, 0.5, 0.02);

        entity.setHealth(0);
    }



    @EventHandler
    public void beaterofdeathdeathcatcher(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;

        // 1. Check if the player is holding the item in EITHER hand
        if (!isHoldingBeater(p)) return;

        // 2. Check if the hit will actually kill them
        // We use getFinalDamage() to account for armor and enchantments
        if (p.getHealth() - e.getFinalDamage() <= 0) {

            // CANCEL the death
            e.setCancelled(true);

            // Set health to a small amount so they don't instantly die to the next tick

            final int duration = 30 * 20; // 30 seconds
            final int amplifier = 2;

            // Apply Effects
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, amplifier));
            p.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, duration, amplifier));
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, duration, amplifier));
            p.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, duration, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, duration, amplifier));
            p.damage(0);
            // Visuals
            World world = p.getWorld();
            world.spawnParticle(Particle.EXPLOSION, p.getLocation(), 1);
            world.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);

            p.sendMessage("§c§lDEATH DEFIED! §7The Beater of Death protects you.");
        }
    }

    // Helper method to check both hands cleanly
    private boolean isHoldingBeater(Player p) {
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "is_beaterofdeath");

        ItemStack main = p.getInventory().getItemInMainHand();
        ItemStack off = p.getInventory().getItemInOffHand();

        boolean mainHas = main != null && main.hasItemMeta() &&
                main.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE);

        boolean offHas = off != null && off.hasItemMeta() &&
                off.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE);

        return mainHas || offHas; // Works if it's in either hand
    }

    private boolean isHoldingMurasame(Player p) {
        NamespacedKey key = new NamespacedKey(ServerPlugin.getInstance(), "is_murasame");

        ItemStack main = p.getInventory().getItemInMainHand();

        boolean mainHas = main != null && main.hasItemMeta() &&
                main.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE);


        return mainHas;// Works if it's in either hand
    }
}

