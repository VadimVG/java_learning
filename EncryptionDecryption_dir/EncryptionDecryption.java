package test_classes.EncryptionDecryption_dir;

import java.io.*;

public class EncryptionDecryption {
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
