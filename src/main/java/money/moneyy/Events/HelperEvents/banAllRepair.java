package money.moneyy.Events.HelperEvents;

import money.moneyy.Class.Classes;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class banAllRepair implements Listener {

    @EventHandler
    public void onPlayerCraft(InventoryClickEvent event,String Class) {
        Player player = (Player) event.getWhoClicked();
        Classes meslek = new Classes();
        if (meslek.whatisMyClass(player).equalsIgnoreCase(Class)){
            if (event.getInventory().getType() == InventoryType.ANVIL){
                player.sendMessage(ChatColor.RED+Class+" mesleğine sahip olan biri, tamir yapamaz!");
                event.setCancelled(true);
            }
        }

    }
}
