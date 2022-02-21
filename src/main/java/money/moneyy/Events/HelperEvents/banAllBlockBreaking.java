package money.moneyy.Events.HelperEvents;

import money.moneyy.Class.Classes;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class banAllBlockBreaking implements Listener {

    @EventHandler
    public void onPlayerInteract(BlockBreakEvent event,String Class){
        final Player p = (Player) event.getPlayer();
        Classes meslek = new Classes();
        if (meslek.whatisMyClass(event.getPlayer()).equalsIgnoreCase(Class) && !event.getPlayer().isOp()){
            if (event.getBlock().getType().isBlock() || event.getBlock().getType().isItem()){
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED+ Class +" mesleğinde olan biri, hiçbir şey kıramaz!");
            }
        }


    }
}
