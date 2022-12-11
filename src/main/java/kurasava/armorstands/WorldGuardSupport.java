package kurasava.armorstands;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import kurasava.Main;
import org.bukkit.entity.Player;

public class WorldGuardSupport {

    public boolean checkPlayerIsMemberOrOwner(Player player) {
        Location loc = BukkitAdapter.adapt(player.getLocation());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery regions = container.createQuery();
        ApplicableRegionSet region = regions.getApplicableRegions(loc);
        if(region.size() == 0) {
            return true;
        }
        for(final ProtectedRegion reg : region) {
            if(reg.getOwners().contains(player.getUniqueId()) || reg.getMembers().contains(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkFlag(Player player) {
        RegionQuery query = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
        Location loc = BukkitAdapter.adapt(player.getLocation());
        ApplicableRegionSet set = query.getApplicableRegions(loc);
        for(ProtectedRegion region : set) {
            StateFlag.State flag = region.getFlag(Main.armorStandUse);
            if(flag == StateFlag.State.ALLOW) {
                return true;
            }
        }
        return false;
    }

}

