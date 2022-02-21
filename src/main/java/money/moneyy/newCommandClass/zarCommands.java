package money.moneyy.newCommandClass;

import money.moneyy.Class.zar;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class zarCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){return true;}

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("zar")){

            zar oZar = new zar();
            String zarSayi = String.valueOf(oZar.zarr(Integer.parseInt(args[0])));

            for (Player p : getServer().getOnlinePlayers()){
                p.sendMessage(ChatColor.LIGHT_PURPLE + player.getDisplayName()+" Adlı kişinin "+args[0]+" zar türünden attığızı zar: "+zarSayi);

            }
        }

        return false;
    }
}
