package money.moneyy.Class;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import static org.bukkit.Bukkit.getServer;

public class dashboardForPlayer {


    public void playerScoreboard(Player player){

        Factions fact = new Factions();
        moeymodule money = new moeymodule();
        Classes meslek = new Classes();

        ScoreboardManager manager = getServer().getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("HubScoreboard-1","dummy","Hakkımda");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score = objective.getScore(ChatColor.GREEN + "Dinar: "+ money.getMoney(player));
        score.setScore(4);
        Score faction = objective.getScore(ChatColor.GREEN + "Krallık: "+ fact.whatismyFaction(player));
        faction.setScore(3);
        Score meslekScore = objective.getScore(ChatColor.GREEN + "Meslek: "+ meslek.whatisMyClass(player));
        meslekScore.setScore(2);
        player.setScoreboard(scoreboard);


    }



}
