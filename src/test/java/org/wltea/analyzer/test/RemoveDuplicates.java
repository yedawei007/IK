package org.wltea.analyzer.test;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
        String firstFile = "/Users/yida/Downloads/sougouDicts/company.txt";
        String secondFile = "/Users/yida/Downloads/sougouDicts/main2012.dic";
        String thirdFile = "/Users/yida/Downloads/sougouDicts/main_dic.dic";
        String charset = "utf-8";
        // 打开第一个文件并读取数据到set1中
        InputStreamReader inputStreamReader1 = new InputStreamReader(new FileInputStream(firstFile), charset);
        BufferedReader reader1 = new BufferedReader(inputStreamReader1);
        Set<String> set1 = new LinkedHashSet<>();
        String line = reader1.readLine();
        while (line != null) {
            set1.add(line.trim());
            line = reader1.readLine();
        }
        reader1.close();

        // 打开第二个文件并读取数据到set2中
        InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(secondFile), charset);
        BufferedReader reader2 = new BufferedReader(inputStreamReader2);
        Set<String> set2 = new LinkedHashSet<String>();
        line = reader2.readLine();
        while (line != null) {
            set2.add(line.trim());
            line = reader2.readLine();
        }
        reader2.close();

        // 将两个set合并
        set1.addAll(set2);

        // 打开输出文件并写入去重后的数据
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(thirdFile), charset);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        for (String str : set1) {
            if (str.trim().length() <= 0) {
                continue;
            }
            writer.write(str.trim());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
}
