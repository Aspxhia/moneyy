package money.moneyy.newCommandClass;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class RolePlayChatCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){return true;}

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("me")){
            String AllArgs = StringUtils.join(args, " ");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "**" + player.getDisplayName() + "," + AllArgs);
            for(Entity e : player.getNearbyEntities(15, 15, 15)){
                if(e instanceof Player){
                    ((Player)e).sendMessage(ChatColor.LIGHT_PURPLE + "**" + player.getDisplayName() + "," + AllArgs);

                }
            }

        }

        if(cmd.getName().equalsIgnoreCase("do")){
            String AllArgs = StringUtils.join(args, " ");
            player.sendMessage(ChatColor.GREEN + "((" + player.getDisplayName() + "," + AllArgs+"))");
            for(Entity e : player.getNearbyEntities(15, 15, 15)){
                if(e instanceof Player){
                    ((Player)e).sendMessage(ChatColor.GREEN + "((" + player.getDisplayName() + "," + AllArgs+"))");

                }
            }

        }

        if(cmd.getName().equalsIgnoreCase("w")){
            String AllArgs = StringUtils.join(args, " ");
            player.sendMessage(ChatColor.GREEN + player.getDisplayName() + ", fısıldar: " + AllArgs);
            for(Entity e : player.getNearbyEntities(5, 5, 5)){
                if(e instanceof Player){
                    ((Player)e).sendMessage(ChatColor.GREEN + player.getDisplayName() + ", fısıldar: " + AllArgs);

                }
            }

        }

        if(cmd.getName().equalsIgnoreCase("s")){
            String AllArgs = StringUtils.join(args, " ");


            player.sendMessage(ChatColor.GOLD + player.getDisplayName() + ", bağırır: "+AllArgs);
            for(Entity e : player.getNearbyEntities(40, 40, 40)){
                if(e instanceof Player){
                    ((Player)e).sendMessage(ChatColor.WHITE + player.getDisplayName() + ", bağırır: "+AllArgs);

                }
            }

        }

        if(cmd.getName().equalsIgnoreCase("ooc")){
            String AllArgs = StringUtils.join(args, " ");
            player.sendMessage("<"+player.getDisplayName()+">"+ChatColor.ITALIC + "OOC: " + AllArgs);
            for(Entity e : player.getNearbyEntities(15, 15, 15)){
                if(e instanceof Player){
                    ((Player)e).sendMessage("<"+player.getDisplayName()+">"+ChatColor.ITALIC + "OOC: " + AllArgs);

                }
            }

        }

        return false;
    }
}
