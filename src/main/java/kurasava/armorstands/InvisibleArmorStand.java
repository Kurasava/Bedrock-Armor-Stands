package kurasava.armorstands;

import kurasava.Main;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;

public class InvisibleArmorStand implements Listener {

    @EventHandler
    public void invisibleOn(PotionSplashEvent i) {
        ThrownPotion potion = i.getPotion();
        if(Main.getInstance().getConfig().getBoolean("usePotionOfInvisibility")) {
            for (PotionEffect effect : potion.getEffects()) {
                for (Entity entity : potion.getNearbyEntities(2, 2,2)) {
                    if (effect.getType().equals(PotionEffectType.INVISIBILITY) && entity instanceof ArmorStand armorStand) {
                        armorStand.setInvisible(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void invisibleOff(PotionSplashEvent i) {
        ThrownPotion potion = i.getPotion();
        if(Main.getInstance().getConfig().getBoolean("usePotionOfInvisibility")) {
            for (Entity entity : potion.getNearbyEntities(2, 2,2)) {
                if (potion.getEffects().isEmpty() && entity instanceof ArmorStand armorStand && armorStand.isInvisible()) {
                    armorStand.setInvisible(false);
                }
            }
        }
    }
}
