package money.moneyy;


import money.moneyy.Events.HelperEvents.banAllCrafting;
import money.moneyy.Events.HelperEvents.banAllBlockBreaking;
import money.moneyy.Events.HelperEvents.banAllRepair;
import money.moneyy.Events.onJoin;
import money.moneyy.Events.whilePlayerEatApple;
import money.moneyy.newCommandClass.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Pluginler Başladı");
        getServer().getPluginManager().registerEvents(new whilePlayerEatApple(),this);
        getServer().getPluginManager().registerEvents(new onJoin(),this);
        getServer().getPluginManager().registerEvents(new banAllBlockBreaking(),this);
        getServer().getPluginManager().registerEvents(new banAllCrafting(),this);
        getServer().getPluginManager().registerEvents(new banAllRepair(),this);
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


