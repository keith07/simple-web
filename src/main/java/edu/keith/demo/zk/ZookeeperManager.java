package edu.keith.demo.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by keith on 2016/8/31.
 */
public class ZookeeperManager {
    private final String connectString = "192.168.1.21:2181";
    private final int sessionTimeout = 3000;
    private final String rootDir = "/manager";
    private ZooKeeper zk;

    public ZookeeperManager(Watcher watcher) throws IOException, KeeperException, InterruptedException {
        zk = new ZooKeeper(connectString, sessionTimeout, watcher);
        if(!exist(rootDir))
            zk.create(rootDir, rootDir.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public boolean exist(String path) throws KeeperException, InterruptedException {
        return zk.exists(path,false) != null;
    }

    public boolean validPath(String path) {
        if(path == null || "".equals(path =path.trim()) || !path.startsWith("/"))
            return false;

        return true;
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        ZookeeperManager zookeeperManager = new ZookeeperManager(new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("watchedEvent:"+watchedEvent);
            }
        });
    }
}
