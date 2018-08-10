package me.eric.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void openMain(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, "Shadoshi伺服器選單");
        ItemStack spawn = new ItemStack(Material.BEACON, 1);
        ItemMeta spawnmeta = spawn.getItemMeta();
        List<String> spawnlore = new ArrayList<>();
        spawnlore.add("點我回到重生點");
        spawnmeta.setLore(spawnlore);
        spawnmeta.setDisplayName(ChatColor.GOLD+"回到重生點");
        spawn.setItemMeta(spawnmeta);
        inv.setItem(0, spawn);
        ItemStack home = new ItemStack(Material.OAK_PLANKS, 1);
        ItemMeta homemeta = home.getItemMeta();
        List<String> homelore = new ArrayList<>();
        homelore.add("點我回家");
        homemeta.setLore(homelore);
        homemeta.setDisplayName(ChatColor.BLUE+"回家");
        home.setItemMeta(homemeta);
        ItemStack sethome = new ItemStack(Material.OAK_LOG, 1);
        ItemMeta sethomemeta = sethome.getItemMeta();
        List<String> sethomelore = new ArrayList<>();
        sethomelore.add("點我在當前位置設置家");
        sethomemeta.setLore(sethomelore);
        sethomemeta.setDisplayName(ChatColor.YELLOW+"在當前位置設置家");
        sethome.setItemMeta(sethomemeta);
        inv.setItem(1, home);
        inv.setItem(8, sethome);
        ItemStack pork = new ItemStack(Material.COOKED_PORKCHOP, 1);
        ItemMeta porkmeta = pork.getItemMeta();
        porkmeta.setDisplayName(ChatColor.GOLD+"領取食物");
        List<String> porklore = new ArrayList<>();
        porklore.add("點我領取食物");
        porkmeta.setLore(porklore);
        pork.setItemMeta(porkmeta);
        inv.setItem(3, pork);
        ItemStack enderchest = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta enderchestmeta = enderchest.getItemMeta();
        enderchestmeta.setDisplayName(ChatColor.DARK_GREEN+"隨身終界箱");
        List<String> enderchestlore = new ArrayList<>();
        enderchestlore.add("點我打開隨身的終界箱");
        enderchestmeta.setLore(enderchestlore);
        enderchest.setItemMeta(enderchestmeta);
        inv.setItem(4, enderchest);
        ItemStack tpa = new ItemStack(Material.COMPASS, 1);
        ItemMeta tpameta = tpa.getItemMeta();
        tpameta.setDisplayName(ChatColor.BLUE+"傳送指令: /tpa");
        List<String> tpalore = new ArrayList<>();
        tpalore.add("使用方法: /tpa <玩家名稱>");
        tpameta.setLore(tpalore);
        tpa.setItemMeta(tpameta);
        inv.setItem(5, tpa);
        ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE, 1);
        ItemMeta bottlemeta = bottle.getItemMeta();
        bottlemeta.setDisplayName(ChatColor.GOLD+"領地魔法瓶子");
        List<String> bottlelore = new ArrayList<>();
        bottlelore.add("點我拿取一個用來");
        bottlelore.add("設領地的魔法瓶子");
        bottlemeta.setLore(bottlelore);
        bottle.setItemMeta(bottlemeta);
        inv.setItem(7, bottle);
        p.openInventory(inv);
    }
}
