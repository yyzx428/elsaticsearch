package com.yyzx.elasticsearch.plugin;

import org.apache.curator.framework.CuratorFramework;
import org.apache.lucene.util.SetOnce;
import org.elasticsearch.common.network.NetworkService;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.SeedHostsProvider;
import org.elasticsearch.plugins.DiscoveryPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.transport.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ZookeeperPlugin extends Plugin implements DiscoveryPlugin {

    private final Logger logger = LoggerFactory.getLogger(ZookeeperPlugin.class);

    private Settings settings;

    private SetOnce<CuratorFramework> client;

    public ZookeeperPlugin(Settings settings) {
        this.settings = settings;
        logger.trace("starting zk discovery plugin...");
    }

    @Override
    public NetworkService.CustomNameResolver getCustomNameResolver(Settings settings) {
        return null;
    }

    @Override
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {
        return new HashMap<>();
    }
}
