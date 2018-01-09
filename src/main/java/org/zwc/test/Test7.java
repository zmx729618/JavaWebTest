package org.zwc.test;

import java.io.IOException;
import java.nio.file.*;

/**
 * 测试 WatchService，检测目录的变化通知事件
 * Created by zhangwenchao on 2017/12/26.
 */
public class Test7 {

    public static void main(String[] args) {
        try{

            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path dir = Paths.get("E:/data/logs");

            dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE);

            while(true){

                WatchKey key = watchService.take();
                for(WatchEvent<?> event : key.pollEvents()){
                    if(event.kind() == StandardWatchEventKinds.ENTRY_MODIFY){
                        System.out.println("目录已经改变");
                    }
                }

                key.reset();  //重置key等待下一个事件

            }


        }catch(IOException | InterruptedException e){

            e.printStackTrace();

        }

    }
}
