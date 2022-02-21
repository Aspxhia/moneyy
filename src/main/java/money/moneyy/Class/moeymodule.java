package money.moneyy.Class;

import money.moneyy.Class.dashboardForPlayer;
import org.bukkit.entity.Player;

import java.sql.*;

public class moeymodule {

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

    public void setMoney(Player player, int amount) {

        PreparedStatement pst;
        String uid = "";
        int Money = 0;


        try {
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM playermoney");
            if (resultSet.next()) {

                ResultSet res = statement.executeQuery("SELECT * FROM playermoney WHERE uid = '" + player.getUniqueId() + "';");
                if (res.next()) {

                    if (res.getString("uid") == null) {
                        statement.executeUpdate("INSERT INTO playermoney(uid,Money) VALUES ('" + player.getUniqueId() + "','" + amount + "');");
                    } else {
                        statement.executeUpdate("UPDATE playermoney SET Money = '" + amount + "' WHERE uid = '" + player.getUniqueId() + "';");
                    }

                } else {

                    statement.executeUpdate("INSERT INTO playermoney(uid,Money) VALUES ('" + player.getUniqueId() + "','" + amount + "');");
                }

            } else {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS playermoney(uid NVARCHAR(1000),money INTEGER)");
                statement.executeUpdate("INSERT INTO playermoney(uid,money) VALUES ('" + player.getUniqueId() + "','" + amount + "');");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String getMoney(Player player) {


        String uid = "";



        try {
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM playermoney");
            if (resultSet.next()) {

                ResultSet res = statement.executeQuery("SELECT * FROM playermoney WHERE uid = '" + player.getUniqueId() + "';");
                if (res.next()) {

                    if (res.getString("uid") == null) {
                        return "0";
                    }
                    else{

                        return res.getString("money");
                    }

                } else {

                    return "0";
                }



            } else {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS playermoney(uid NVARCHAR(1000),money INTEGER)");
            }
            return "0";
        }
        catch (Exception ex)
        {
            return "0";
        }


    }

    public String sendMoney(Player fromPlayer,Player toPlayer,int amount) {

        try {
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM playermoney");
            System.out.println("select * from playermoney yapti");
            if (resultSet.next()) {

                ResultSet res = statement.executeQuery("SELECT * FROM playermoney WHERE uid = '" + fromPlayer.getUniqueId() + "';");
                if (res.next()) {

                    if (res.getString("uid") == null) {
                        return "0";
                    }
                    else if(res.getString("uid") != null){
                        if(res.getInt("money") >= amount){

                            statement.executeUpdate("UPDATE playermoney SET Money = money-'" + amount + "' WHERE uid = '" + fromPlayer.getUniqueId() + "';");
                            dashboardForPlayer fromPlayerDasboard = new dashboardForPlayer();
                            fromPlayerDasboard.playerScoreboard(fromPlayer);
                            statement.executeUpdate("UPDATE playermoney SET Money = money+'" + amount + "' WHERE uid = '" + toPlayer.getUniqueId() + "';");
                            dashboardForPlayer toPlayerDasboard = new dashboardForPlayer();
                            toPlayerDasboard.playerScoreboard(toPlayer);

                            return "1";
                        }

                        else{
                            return "3";
                        }
                    }

                }

                else {

                    return "0";
                }
            }


            return "0";
        }
        catch (Exception ex)
        {
            return "0";
        }

    }

    public void searchUser(Player player, int amount) {
        String ival;

        try {
            Statement statement = connect().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM playermoney WHERE uid = '" + player.getUniqueId() + "';");

            if (!(res.next())){
                statement.executeUpdate("INSERT INTO playermoney(uid,Money) VALUES ('" + player.getUniqueId() + "','" + amount + "');");
                player.sendMessage("kayıt eklendi");

            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
