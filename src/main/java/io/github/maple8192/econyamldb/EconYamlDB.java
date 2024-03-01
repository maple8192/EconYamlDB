package io.github.maple8192.econyamldb;

import io.github.maple8192.economics.Economics;
import org.bukkit.plugin.java.JavaPlugin;

public final class EconYamlDB extends JavaPlugin {
    @Override
    public void onEnable() {
        Economics.setDatabase(new YamlDB(this));
    }
}
