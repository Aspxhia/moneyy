package money.moneyy.Events;

import money.moneyy.Class.dashboardForPlayer;
import money.moneyy.Class.moeymodule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        moeymodule mm = new moeymodule();
        mm.searchUser(event.getPlayer(),50);

        dashboardForPlayer dashboardd = new dashboardForPlayer();
        dashboardd.playerScoreboard(event.getPlayer());

    }
}
