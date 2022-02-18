package money.moneyy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class Factions {

    public Connection connect(){

        try {
            String host = "jdbc:mysql://localhost:3306/minecraft";
            String uName = "sa";
            String uPass = "5943b77d";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            System.out.println("Success");
            return con;


        }
        catch (SQLException err){

            System.out.println(err.getMessage());
        }
        return null;
    }


    public void addPlayertoFactionofElves(Player player2,String name) {
        Player player = getServer().getPlayer(name);
        if (player != null){
            try {
                Statement statement = connect().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM factions WHERE uid = '" + player.getUniqueId() + "';");

                if (!(res.next())){
                    statement.executeUpdate("INSERT INTO factions(uid,faction,factionRole,playerName) VALUES ('" + player.getUniqueId() + "','Elf','Elf','"+player.getDisplayName()+"');");
                    sendMessageToAllElves(player.getDisplayName() + " Elflerin arasında yerini aldı.");

                }
                else{

                    player2.sendMessage("Zaten bu kişi bir factiona kayıtlı !");
                }

            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void sendMessageToAllElves(String Message){
        List<String> list2 = new ArrayList<>();
        try{
            Statement statement = connect().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM factions WHERE faction = 'Elf'");

                while(res.next()){
                    list2.add(res.getString("uid"));
                }

                for (String uids : list2) {
                    Player player = getServer().getPlayer(uids);
                    if (player != null){
                        player.sendMessage(ChatColor.DARK_GREEN + Message);
                    }

                }

                for (String uids : list2) {
                    Player player = getServer().getPlayer(uids);
                    System.out.println(uids);

                }
            }

        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
