package money.moneyy.newCommandClass;

import money.moneyy.Class.Factions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class FactionsCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){return true;}

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("krallik_elf_yeniuye")){


            Factions faction = new Factions();
            faction.addPlayertoFactionofElves(player,args[0]);
            getServer().getPlayer(args[0]).sendMessage("Artık Elf Krallığının Bir Parçasısınız.");
        }
        if (cmd.getName().equalsIgnoreCase("krallik_insan_yeniuye")){

            Factions faction = new Factions();
            faction.addPlayertoFactionofHuman(player,args[0]);
            getServer().getPlayer(args[0]).sendMessage("Artık İnsan Krallığının Bir Parçasısınız.");
        }

        if (cmd.getName().equalsIgnoreCase("krallik")){

            Factions faction = new Factions();
            faction.getmyFaction(ChatColor.GOLD,player);
        }

        return false;
    }
}
