package money.moneyy;


import com.sun.tools.javac.util.Convert;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.OfflinePlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public final class Main extends JavaPlugin implements CommandExecutor, Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Pluginler Başladı");
        getServer().getPluginManager().registerEvents(this,this);
        getCommand("dinar_dagit").setExecutor(this);
        getCommand("dinar_goster").setExecutor(this);
        getCommand("dinar_ver").setExecutor(this);
        getCommand("zar").setExecutor(this);
        getCommand("krallik_elf_yeniuye").setExecutor(this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        moeymodule mm = new moeymodule();
        mm.searchUser(event.getPlayer(),50);


    }


    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){return true;}

        Player player = (Player) sender;
        Player toPlayer;
        UUID toPlayerUUID;

        //MoneySet
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

            if (cmd.getName().equalsIgnoreCase("zar")){


                zar oZar = new zar();
                String zarSayi = String.valueOf(oZar.zarr(Integer.parseInt(args[0])));



                for (Player p : getServer().getOnlinePlayers()){
                    p.sendMessage(ChatColor.LIGHT_PURPLE + player.getDisplayName()+" Adlı kişinin "+args[0]+" zar türünden attığızı zar: "+zarSayi);

                }
            }

            if (cmd.getName().equalsIgnoreCase("krallik_elf_yeniuye")){


                Factions faction = new Factions();
                faction.addPlayertoFactionofElves(player,args[0]);
            }


        return false;
    }

}


