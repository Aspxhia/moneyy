package money.moneyy.Events.HelperEvents;

import money.moneyy.Class.Classes;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class banAllCrafting implements Listener {

    @EventHandler
    public void onPlayerCraft(CraftItemEvent event,String Class) {
        for (HumanEntity entity : event.getViewers()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                Classes meslek = new Classes();
                if (meslek.whatisMyClass(player).equalsIgnoreCase(Class) && !player.isOp()) {
                    ItemStack[] item = event.getInventory().getMatrix();


                    for (int i = 0; i < 8; i++) {
                        if (item[i].getItemMeta() != null) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.RED+ Class +"mesleğinde olan biri, hiçbir şey üretemez!");
                            break;

                        }
                    }
                }
            }
        }
    }


}

