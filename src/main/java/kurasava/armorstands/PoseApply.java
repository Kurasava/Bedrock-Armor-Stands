package kurasava.armorstands;

import kurasava.Main;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.Listener;

public class PoseApply implements Listener {

    private final ArmorStandPose index = new ArmorStandPose();
    private final Utils utils = new Utils();
    private final WorldGuardSupport wgs = new WorldGuardSupport();

    //Установка индекса позы при спавне арморстенда
    @EventHandler
    public void armorStandSPawn(EntitySpawnEvent s) {
        if(s.getEntity() instanceof ArmorStand armorStand) {
            utils.setPoseIndex(armorStand, 0);
        }
    }
    //Смена позы ПКМ
    @EventHandler(priority = EventPriority.HIGHEST)
    public void rightClickPoseChange(PlayerInteractAtEntityEvent e) {
        final Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.AIR  && p.isSneaking()) {
            final Entity rightClicked = e.getRightClicked();
            if (rightClicked instanceof ArmorStand armorStand) {
                if(!wgs.checkFlag(p)) {
                    if(!wgs.checkPlayerIsMemberOrOwner(p)) {
                        String hey = ChatColor.RED + "Hey!";
                        String hs = ChatColor.RED + hey + ChatColor.DARK_GRAY + " Sorry, but you can't change that here";
                        p.sendMessage(hs);
                        return;
                    }
                }
                if(!utils.exists(armorStand)) {
                    e.setCancelled(true);
                    utils.setPoseIndex(armorStand, 0);
                    armorStand.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_BREAK, 2.0f, 1.0f);
                    return;
                }
                e.setCancelled(true);
                int poseIndex = utils.getPoseIndex(armorStand) + 1;
                index.applyPoseRightClick(armorStand, poseIndex);
                armorStand.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_BREAK, 2.0f, 1.0f);
            }
        }
    }
    //Смена позы редстоуном
    @EventHandler
    public void redstonePoseChange(BlockRedstoneEvent r) {
        if(Main.getInstance().getConfig().getBoolean("useRedstoneForChangePose")) {
            Location blockLoc = r.getBlock().getLocation().toCenterLocation();
            for (Entity entity : r.getBlock().getWorld().getNearbyEntities(blockLoc, 1.5, 0.5, 1.5)) {
                if (entity instanceof ArmorStand armorStand) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                        Location asLoc = armorStand.getLocation();
                        if (asLoc.getBlock().isBlockPowered()) {
                            int poseIndex = asLoc.getBlock().getBlockPower();
                            index.applyPoseRedstone(armorStand, poseIndex);
                            armorStand.getWorld().playSound(asLoc, Sound.ENTITY_ARMOR_STAND_BREAK, 2.0f, 1.0f);
                        }
                    }, 1);
                }
            }
        }
    }
}
