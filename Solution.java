package test_classes;

import java.io.*;

/*
Задача: Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
    -e fileName fileOutputName
    -d fileName fileOutputName
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input_file = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
        BufferedWriter output_file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[2])));
        String line;
        if (args[0].equals("-e")) {
            while ((line = input_file.readLine()) != null) {
                String mdf = "";
                for (int i = 0; i < line.length(); i++) {
                    mdf += '|';
                    mdf += line.charAt(i);
                }
                output_file.write(mdf);
                output_file.newLine();
            }
        }
        else {
            while ((line = input_file.readLine()) != null) {
                String mdf = "";
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i)!='|') {
                        mdf += line.charAt(i);
                    }
                }
                output_file.write(mdf);
                output_file.newLine();
            }
        }
    input_file.close();
    output_file.close();
    }
}