package me.eric.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    FileConfiguration config = getConfig();
    @Override
    public void onEnable(){
        getLogger().info("Menu plugin has been enabled.");
        getServer().getPluginManager().registerEvents(new ListenerClass(), this);
    }
    @Override
    public void onDisable(){
        getLogger().info("Menu plugin has been disabled.");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if((cmd.getName().equalsIgnoreCase("shadoshi"))||(cmd.getName().equalsIgnoreCase("menu"))||(cmd.getName().equalsIgnoreCase("servermenu"))){
                ItemStack menu = new ItemStack(Material.COMPASS, 1);
                ItemMeta menumeta = menu.getItemMeta();
                menumeta.setDisplayName(ChatColor.BLUE+"Shadoshi伺服器選單");
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.DARK_PURPLE+"服主自己編寫的選單插件");
                lore.add(ChatColor.LIGHT_PURPLE+"右鍵打開~");
                menumeta.setLore(lore);
                menu.setItemMeta(menumeta);
                p.getInventory().addItem(menu);
                return true;
            }
        }
        return false;
    }
}