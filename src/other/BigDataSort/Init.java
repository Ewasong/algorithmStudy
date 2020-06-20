package other.BigDataSort;

import java.io.*;
import java.util.Random;

/***
 *
 */
public class Init {



    public static void clearFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * 生成N个数字的文件,一个数字一行
     * @param size
     */
    public static void init(long size, String path)  {
//        clearFile(path);
        Random r = new Random(System.currentTimeMillis());

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path, false);
            while (size-- > 0) {
                Integer per = r.nextInt(Integer.MAX_VALUE);
                fileWriter.write(per.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


