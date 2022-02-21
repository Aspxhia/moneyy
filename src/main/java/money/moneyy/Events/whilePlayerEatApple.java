package money.moneyy.Events;


import money.moneyy.Class.Factions;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class whilePlayerEatApple implements Listener {
    @EventHandler
    public void whilePlayerEatApplee(PlayerItemConsumeEvent event) throws InterruptedException {
        Factions fact = new Factions();
        if (fact.whatismyFaction(event.getPlayer()).equalsIgnoreCase("Elf")){
            ItemStack item = event.getItem();

            if (item.getType().equals(Material.APPLE)){
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 720, 0));
            }
        }
    }

}
