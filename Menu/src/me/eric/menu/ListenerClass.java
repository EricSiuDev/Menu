package me.eric.menu;

import org.apache.commons.lang.ObjectUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ListenerClass implements Listener {
    @EventHandler
    public void playerClickEvent(PlayerInteractEvent e){
        Player p = (Player) e.getPlayer();
        Action a = e.getAction();
        if(a.equals(Action.LEFT_CLICK_BLOCK) || a.equals(Action.RIGHT_CLICK_BLOCK) || a.equals(Action.LEFT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_AIR)) {
            if (e.hasItem()){
                if (e.getItem().getType().equals(Material.COMPASS)) {
                    if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Shadoshi伺服器選單")) {
                            Menu.openMain(p);
                            return;
                    }
                }
            }
        }
        return;
    }
    @EventHandler
    public void invDragEvent(InventoryDragEvent e){
        Inventory inv = e.getInventory();
        String name = inv.getName();
        if(name.equals("Shadoshi伺服器選單")){
            e.setCancelled(true);
            return;
        }
    }
    @EventHandler
    public void invClickEvent(InventoryClickEvent e){
        Inventory inv = e.getInventory();
        Player p = (Player) e.getWhoClicked();
        String name = inv.getName();
        if(name.equals("Shadoshi伺服器選單")){
            e.setCancelled(true);
            int slot = e.getSlot();
            if(slot==0){
                p.performCommand("spawn");
                p.closeInventory();
                return;
            }
            if(slot==1){
                p.performCommand("home");
                p.closeInventory();
                return;
            }
            if(slot==8){
                p.performCommand("sethome");
                p.closeInventory();
                return;
            }
            if(slot==3){
                p.performCommand("food");
                p.closeInventory();
                return;
            }
            if(slot==4){
                p.closeInventory();
                p.performCommand("enderchest");
                return;
            }
            if(slot==5){
                p.closeInventory();
                p.performCommand("tpa");
                return;
            }
            if(slot==7){
                p.closeInventory();
                ItemStack rpbottle = new ItemStack(Material.GLASS_BOTTLE);
                ItemMeta rpbottlemeta = rpbottle.getItemMeta();
                rpbottlemeta.setDisplayName(ChatColor.GOLD+"領地魔法瓶子");
                List<String> rpbottlelore = new ArrayList<>();
                rpbottlelore.add("使用方法: ");
                rpbottlelore.add("拿著瓶子左鍵左上角落");
                rpbottlelore.add("再右鍵右下角落");
                rpbottlelore.add("輸入/rp claim <領地名字> <其他成員的名字>");
                rpbottlemeta.setLore(rpbottlelore);
                rpbottle.setItemMeta(rpbottlemeta);
                p.getInventory().addItem(rpbottle);
                return;
            }
            return;
        }
    }
}
