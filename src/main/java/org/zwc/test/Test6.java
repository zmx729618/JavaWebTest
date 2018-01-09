package org.zwc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by zhangwenchao on 2017/12/25.
 */
public class Test6 {

    public static void main(String[] args) {

        Path  logfilePath = Paths.get("E:/data/logs/webApp.log");

        try(BufferedReader reader = Files.newBufferedReader(logfilePath, StandardCharsets.UTF_8)){

            String line = "";

            while((line=reader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            List<String> lines = Files.readAllLines(logfilePath, StandardCharsets.UTF_8);

            for(String s:lines){
                System.out.println(s);
            }

            byte[] bytes =   Files.readAllBytes(logfilePath);

            System.out.println(new String(bytes,StandardCharsets.UTF_8));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
