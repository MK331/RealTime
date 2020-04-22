package top.toshokan.yagami.realtime;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Calendar;

public final class Main extends JavaPlugin {
    public void onEnable() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(11);
                int min = calendar.get(12);
                int time = hour * 1000 + min * 16 - 6000;
                if (time < 0) {
                    time = 24000 - time;
                }
                World world = getServer().getWorld("world");
                long FullTime = world.getFullTime();
                long tickTime = world.getTime();
                world.setFullTime(FullTime - tickTime + (long)time);
            }
        }, 0L, 20*60L);
    }
}