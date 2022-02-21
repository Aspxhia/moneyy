package money.moneyy.Class;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.Statement;

public class Classes {

    public void yeniMeslek(Player player,String jobClass){

        Factions faction = new Factions();
        faction.connect();

        try {

            Statement statement = faction.connect().createStatement();
            String selectQuery = "SELECT * FROM minecraft.classes WHERE uid = '"+player.getUniqueId()+"'";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            if (resultSet.next()){

                player.sendMessage("Zaten bir mesleğiniz var. Mesleğiniz: "+resultSet.getString("class"));
            }
            else {

                String insertQuery = "INSERT INTO minecraft.classes(uid,playerName,class,classLevel) VALUES ('"+player.getUniqueId()+"','"+player.getDisplayName()+"','"+jobClass+"',1)";
                statement.executeUpdate(insertQuery);
                dashboardForPlayer dashboard = new dashboardForPlayer();
                dashboard.playerScoreboard(player);
                player.sendMessage(ChatColor.GREEN+"Mesleğiniz artık: "+ChatColor.RED+jobClass);

            }

        }

        catch (Exception ex){
            System.out.println(ex.getMessage());
        }



    }

    public String whatisMyClass(Player player){
        String myClass = "";
        Factions faction = new Factions();


        try {
            Statement statement = faction.connect().createStatement();
            String selectQuery = "SELECT * FROM minecraft.classes WHERE uid = '"+player.getUniqueId()+"'";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            if (resultSet.next()){

                myClass =  resultSet.getString("class");



            }
            else{
                myClass = "Herhangi bir mesleğiniz bulunamamaktadır.";
            }

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        return myClass;
    }
}
