package money.moneyy;


import com.sun.tools.javac.util.Convert;
import money.moneyy.Events.onJoin;
import money.moneyy.Events.whilePlayerEatApple;
import money.moneyy.newCommandClass.*;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Pluginler Başladı");
        getServer().getPluginManager().registerEvents(new whilePlayerEatApple(),this);
        getServer().getPluginManager().registerEvents(new onJoin(),this);
        getCommand("dinar_dagit").setExecutor(new DinarCommands());
        getCommand("dinar_goster").setExecutor(new DinarCommands());
        getCommand("dinar_ver").setExecutor(new DinarCommands());
        getCommand("zar").setExecutor(new zarCommands());
        getCommand("krallik_elf_yeniuye").setExecutor(new FactionsCommands());
        getCommand("krallik_insan_yeniuye").setExecutor(new FactionsCommands());
        getCommand("krallik").setExecutor(new FactionsCommands());
        getCommand("me").setExecutor(new RolePlayChatCommands());
        getCommand("do").setExecutor(new RolePlayChatCommands());
        getCommand("s").setExecutor(new RolePlayChatCommands());
        getCommand("w").setExecutor(new RolePlayChatCommands());
        getCommand("meslek_sec").setExecutor(new ClassesCommands());
        getCommand("meslek").setExecutor(new ClassesCommands());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}


