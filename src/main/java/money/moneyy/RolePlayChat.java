package money.moneyy;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.*;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class RolePlayChat {



    public void sendMessageToNearPlayers(Player player,int radius,String Message){


        List<Entity> nearby =  player.getNearbyEntities(radius,radius,radius);
        for (Entity tmp: nearby)
            if (tmp instanceof Player) {
                Player pl = (Player) tmp;
                pl.sendMessage(Message);

            }


    }




}


