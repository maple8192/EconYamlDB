package io.github.maple8192.econyamldb;

import io.github.maple8192.economics.EconDatabase;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class YamlDB implements EconDatabase {
    private final Plugin plugin;

    public YamlDB(Plugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    @Override
    public @NotNull String getName() {
        return "EconYamlDB";
    }

    @Override
    public void set(UUID uuid, BigDecimal value) {
        plugin.getConfig().set(uuid.toString(), value.toString());
        plugin.saveConfig();
    }

    @Override
    public @NotNull Optional<BigDecimal> get(UUID uuid) {
        return Optional.ofNullable(plugin.getConfig().getString(uuid.toString(), null)).map(BigDecimal::new);
    }

    @Override
    public @NotNull List<UUID> getKeys() {
        return plugin.getConfig().getKeys(false).stream().map(UUID::fromString).toList();
    }
}
