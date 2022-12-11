package kurasava;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import kurasava.armorstands.ConfigReload;
import kurasava.armorstands.InvisibleArmorStand;
import kurasava.armorstands.PoseApply;
import kurasava.armorstands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public final class Main extends JavaPlugin {

    public static StateFlag armorStandUse;

    @Override
    public void onLoad() {
        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            StateFlag flag = new StateFlag("armorStandUse", true);
            registry.register(flag);
            armorStandUse = flag;
        } catch (FlagConflictException e) {
            Flag<?> existing = registry.get("armorStandUse");
            if(existing instanceof StateFlag) {
                armorStandUse = (StateFlag) existing;
            } else {
                Bukkit.getLogger().info("Some other plugins conflict with you");
            }
        }
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PoseApply(), this);
        Bukkit.getPluginManager().registerEvents(new Utils(), this);
        Bukkit.getPluginManager().registerEvents(new InvisibleArmorStand(), this);
        getCommand("reloadConfig").setExecutor(new ConfigReload());
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            getLogger().info( "Creating config file...");
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        Bukkit.getLogger().info("BedrockArmorStands 1.1 plugin enabled");
    }

    @NotNull
    public static Main getInstance() {
        return JavaPlugin.getPlugin(Main.class);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("BedrockArmorStands 1.1 plugin disabled");
    }
}
