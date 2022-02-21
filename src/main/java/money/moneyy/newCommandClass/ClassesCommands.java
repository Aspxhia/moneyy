package money.moneyy.newCommandClass;

import money.moneyy.Class.Classes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClassesCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(!(sender instanceof Player)){return true;}

        Player player = (Player) sender;


        if(command.getName().equalsIgnoreCase("meslek_sec")){
            Classes meslek = new Classes();
            meslek.yeniMeslek(player,args[0]);

        }

        if(command.getName().equalsIgnoreCase("meslek")){
            Classes meslek = new Classes();
            player.sendMessage(meslek.whatisMyClass(player));

        }

        return false;
    }
}
