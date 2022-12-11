package kurasava.armorstands;

import kurasava.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ConfigReload implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("bas.ConfigReload")){
            sender.sendMessage(ChatColor.RED + "You don`t have permission to do this");
            return true;
        }

        Main.getInstance().reloadConfig();
        sender.sendMessage(ChatColor.GOLD + "Config BedrockArmorStands reloaded");
        return true;
    }
}
