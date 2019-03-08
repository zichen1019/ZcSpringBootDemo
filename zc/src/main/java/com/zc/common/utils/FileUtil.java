package com.zc.common.utils;

import java.io.*;
import java.util.List;

/**
 * 采用字符流读取写入文本文件
 */
public class FileUtil {

    /**
     * PrintWriter是JDK1.1版增加了与字节流I/O相对应的字符流I/O。但是，为了保持兼容性，原先的类几乎没有改动。
     * 再加之调试的需要，PrintStream类被保留，并且System类中的成员变量out、err仍作为它的对象。
     * 然而，PrintWriter用于大多数输出比PrintStream更为合适。
     * 因此1.1版的API中建议新开发的代码使用PrintWriter类，并将PrintStream类的两个构造函数标记为过时。
     * 这样，虽然使用System.out输出不会产生问题，在程序中创建新的PrintStream对象时却会产生编译时的警告。
     *
     * 换行：write(System.getProperty("line.separator"));
     *
     */

    /**
     * PrintWriter
     * @param fileName 文件名
     * @param contentList 内容List
     * @param autoNewLine 自动换行：是否每行都需要换行
     * @param append 是否是追加数据
     * @param autoFlush 自动清空缓存：PrintWriter类与PrintStream类的方法是对应的。有一个不同之外需提请读者注意，就是当PrintWriter的自动清空缓冲区的功能被使用时(构造函数中autoFlush置为true)，
     *                  仅当println()方法被调用时才自动清缓冲区，而不是像PrintStream一样遇到一个换行符就清缓冲。
     */
    public static void PrintWriter(String fileName, List<String> contentList, boolean autoNewLine, boolean append, boolean autoFlush){
        checkFloadExists(fileName.substring(0, fileName.lastIndexOf("\\")));
        PrintWriter pw  = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, append)), autoFlush);
            for (String content : contentList) {
                if(autoNewLine) {
                    pw.println(content);
                }else{
                    pw.print(content);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pw != null){
                pw.close();
            }
        }
    }

    public static void PrintWriter(String fileName, String toast, boolean autoNewLine, boolean append, boolean autoFlush){
        checkFloadExists(fileName.substring(0, fileName.lastIndexOf("\\")));
        PrintWriter pw  = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, append)), autoFlush);
            pw.println(toast);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pw != null){
                pw.close();
            }
        }

    }

    /**
     * PrintStream
     * @param fileName 文件名
     * @param contentList 内容List
     * @param autoNewLine 自动换行：是否每行都需要换行
     * @param append 是否是追加数据
     * @param autoFlush 自动清空缓存：autoFlush置为true时，每当输出遇到换行符，缓冲区的内容就被强制全部输出，如同调用了一次flush()。但要注意，如果没遇到换行符，还是会有数据“憋”在缓冲区里
     */
    public static void PrintStream(String fileName, List<String> contentList, boolean autoNewLine, boolean append, boolean autoFlush){
        checkFloadExists(fileName.substring(0, fileName.lastIndexOf("\\")));
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(fileName, append), autoFlush);
            for(String content : contentList) {
                if (autoNewLine) {
                    ps.println(content);
                } else {
                    ps.print(content);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ps != null){
                ps.close();
            }
        }
    }

    public static void PrintStream(String fileName, String toast, boolean autoNewLine, boolean append, boolean autoFlush){
        checkFloadExists(fileName.substring(0, fileName.lastIndexOf("\\")));
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(fileName, append), autoFlush);
            ps.println(toast);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ps != null){
                ps.close();
            }
        }
    }

    /**
     * 读文件
     * @param fileName
     * @return
     */
    public static String readFile(String fileName){
        StringBuffer sb = new StringBuffer("");
        FileReader input = null;
        BufferedReader reader = null;
        try{
            input = new FileReader(fileName);
            reader = new BufferedReader(input);
            String line = null;
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(null != input){
                try {
                    input.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /**
     * 检查路径是否存在，然后创建层级文件夹
     * @param path 路径
     */
    public static void checkFloadExists(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }

}