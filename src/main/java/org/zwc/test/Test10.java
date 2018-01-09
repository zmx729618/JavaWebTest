package org.zwc.test;

import org.apache.ibatis.annotations.SelectProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.NetworkChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/**
 * Created by zhangwenchao on 2017/12/28.
 * NetworkChannel
 */
public class Test10 {

    public static void main(String[] args) {

        SelectorProvider provider = SelectorProvider.provider();

        try {
            NetworkChannel socketChannel = provider.openSocketChannel();

            SocketAddress address = new InetSocketAddress(3080);

            socketChannel = socketChannel.bind(address);

            Set<SocketOption<?>> socketOptions = socketChannel.supportedOptions();
            System.out.println(socketOptions.toString());


            socketChannel.setOption(StandardSocketOptions.IP_TOS,3);
            System.out.println(socketOptions.toString());


            Boolean keepAlive = socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE);

            System.out.println(keepAlive);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
