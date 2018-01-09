package org.zwc.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhangwenchao on 2017/12/22.
 */
public class Test5 {

    public static void main(String[] args) {

        Path path = Paths.get("E:/test/sss");

        System.out.println(FileSystems.getDefault());

        try {
            if(!Files.isDirectory(path)){
                Files.createDirectory(path);
            }

            System.out.println(path.getFileName());
            System.out.println(path.getNameCount());
            System.out.println(path.getParent());
            System.out.println(path.getRoot());
            System.out.println(path.subpath(0,2));

            path.resolve("/a");


            path = Paths.get("E:\\app_projects");
            try(DirectoryStream<Path>  stream =  Files.newDirectoryStream(path,"*.js")){

               for(Path p : stream ){

                   System.out.println(p.getFileName());

               }

            }catch (IOException e){
               e.printStackTrace();
            }


            Files.walkFileTree(path,new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException
                {
                    if(file.toString().endsWith(".js")){

                        System.out.println(file.getFileName());

                    }
                    return FileVisitResult.CONTINUE;
                }

            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
