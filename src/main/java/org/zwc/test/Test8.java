package org.zwc.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by zhangwenchao on 2017/12/26.
 */
public class Test8 {

    public static void main(String[] args) {
        Path logfilePath = Paths.get("E:/data/logs/webApp.log");

        ByteBuffer buffer = ByteBuffer.allocate(1024);  //读写缓冲区

        try {
            FileChannel channel = FileChannel.open(logfilePath, StandardOpenOption.READ);

            channel.read(buffer,channel.size()-1024);

         //   buffer.flip();

            System.out.println(new String(buffer.array(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
