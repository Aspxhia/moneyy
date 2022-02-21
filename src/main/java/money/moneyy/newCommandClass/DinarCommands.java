package money.moneyy.newCommandClass;

import money.moneyy.Class.moeymodule;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DinarCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){return true;}

        Player player = (Player) sender;
        Player toPlayer;
        UUID toPlayerUUID;


        if (cmd.getName().equalsIgnoreCase("dinar_dagit")){
            if (player.isOp()){
                moeymodule sk = new moeymodule();
                toPlayer = Bukkit.getPlayer(args[0]);
                if (toPlayer!=null){
                    sk.setMoney(player, Integer.parseInt(args[1]));
                    player.sendMessage(ChatColor.GREEN + "Başarılı bir şekilde " + player.getDisplayName() + " Adlı kişiye " + args[1] + " Dinar Verdiniz." );

                    toPlayer.sendMessage(ChatColor.GREEN + " Lordunuz tarafından size başlangıç kesesi verildi, kesenizi kontrol ediniz." );
                }
                else{
                    player.sendMessage(ChatColor.RED + "Lordum, başlangıç kesesi vermek istediğiniz kullanıcı şu anda oyunda bulunmamaktadır");

                }

            }
            else {
                player.sendMessage(ChatColor.RED+"Sadece Adminler Dinari Dağıtabilir");
            }



        }
        //Moneyget
        if (cmd.getName().equalsIgnoreCase("dinar_goster")){

            moeymodule sk = new moeymodule();
            player.sendMessage(ChatColor.GREEN + "Şu Anda Kesenizde: "+sk.getMoney(player)+ " Dinar Bulunmaktadır.");

        }

        if (cmd.getName().equalsIgnoreCase("dinar_ver")){

            moeymodule sk = new moeymodule();

            toPlayer = Bukkit.getPlayer(args[0]);

            if (toPlayer != null) {

                String result = sk.sendMoney(player,toPlayer,Integer.parseInt(args[1]));

                if(result.equalsIgnoreCase("1")){
                    player.sendMessage(ChatColor.DARK_GREEN + " Kesenizden "+ args[1] + " Dinar çıkarıp," + toPlayer.getDisplayName() + " Adlı Kişiye Verdiniz.");
                    toPlayer.sendMessage(ChatColor.GOLD + player.getDisplayName() + " Adlı Kişi Size " + args[1] + " Dinar Verdi." );
                }
                else{
                    player.sendMessage(ChatColor.RED +"Yeterli Paranız Bulunmamaktadır!");
                }



            }

        }

        return false;
    }
}
