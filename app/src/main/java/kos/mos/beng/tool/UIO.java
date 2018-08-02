package kos.mos.beng.tool;

import java.io.File;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月03日 00:14
 * @Email: KosmoSakura@foxmail.com
 */
public class UIO {
    public static boolean checkFolderExists(String path) {
        File file = new File(path);
        return file.exists() || file.mkdir();
    }
}
