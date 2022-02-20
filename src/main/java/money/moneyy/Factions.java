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
                    sendMessageToAllRacesonJoin(ChatColor.DARK_GREEN+player.getDisplayName() + " Elflerin arasında yerini aldı.","Elf");

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

    public void addPlayertoFactionofHuman(Player player3,String name) {
        Player player = getServer().getPlayer(name);
        if (player != null){
            try {
                Statement statement = connect().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM factions WHERE uid = '" + player.getUniqueId() + "';");

                if (!(res.next())){
                    statement.executeUpdate("INSERT INTO factions(uid,faction,factionRole,playerName) VALUES ('" + player.getUniqueId() + "','İnsan','İnsan','"+player.getDisplayName()+"');");
                    sendMessageToAllRacesonJoin(ChatColor.DARK_GREEN+player.getDisplayName() + " İnsanların arasında yerini aldı.","İnsan");

                }
                else{

                    player3.sendMessage("Zaten bu kişi bir factiona kayıtlı !");
                }

            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void sendMessageToAllRacesonJoin(String Message,String Faction){
        String playerName;
        try{
            Statement statement = connect().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM factions WHERE faction = '"+Faction+"' ");

            while(res.next()) {

                playerName = res.getString("playerName");
                getServer().getPlayer(playerName).sendMessage(Message);
            }



            }

        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getmyFaction(ChatColor chatcolor,Player player){
        if (player != null) {
            String Fact = "";
            try {
                Statement statement = connect().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM factions WHERE uid = '" + player.getUniqueId() + "' ");

                if (res.next()) {

                    Fact = res.getString("faction");
                    player.sendMessage(chatcolor + Fact + " Krallığına üyesiniz.");

                }

                else{
                    player.sendMessage(chatcolor +"Herhangi bir krallıkta kayıtlı değilsiniz.");
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }
    }


    public String whatismyFaction(Player player){
        String Fact = "";
        if (player != null) {
            try {
                Statement statement = connect().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM factions WHERE uid = '" + player.getUniqueId() + "' ");

                if (res.next()) {

                    Fact = res.getString("faction");
                }


            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }

        return Fact;
    }

}
