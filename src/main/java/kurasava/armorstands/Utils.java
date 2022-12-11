package kurasava.armorstands;

import kurasava.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

public class Utils implements Listener {

    //Геттер индекса позы
    public int getPoseIndex(ArmorStand armorStand) {
        return armorStand.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "PoseIndex"), PersistentDataType.INTEGER);
    }

    public boolean exists(ArmorStand armorStand) {
        if(armorStand.getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "PoseIndex"), PersistentDataType.INTEGER)) {
            return true;
        } else {
            return false;
        }
    }

    //Сеттер индекса позы
    public void setPoseIndex(ArmorStand armorStand, int index) {
        armorStand.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "PoseIndex"), PersistentDataType.INTEGER, index);
    }
}
