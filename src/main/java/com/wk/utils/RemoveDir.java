package com.wk.utils;

import java.io.File;

public class RemoveDir {
    public static void remove(File dir) {
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                remove(file);
            } else {
                //删除文件
                System.out.println("deleted  ::  " + file.toString());
                file.delete();
            }
        }
        //删除目录
        dir.delete();
    }
}
