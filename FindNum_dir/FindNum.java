package test_classes.FindNum_dir;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FindNum {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in))){
            BufferedReader fileReader= new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter fileWriter= new BufferedWriter(new FileWriter(bufferedReader.readLine()));
            String s= "";
            while (fileReader.ready()){
                s+=fileReader.readLine();
            }
            s=s.replace("\n", "");
            ArrayList<String> total= new ArrayList<>(Arrays.asList(s.split(" ")));
            String wr="";
            for(String i: total){
                boolean flag= true;
                for (int j = 0; j < i.length(); j++) {
                    if (!Character.isDigit(i.charAt(j))) flag=false;
                }
                if (flag) wr+=i+" ";
            }
            fileWriter.write(wr.trim());
            fileReader.close();
            fileWriter.close();
        }
    }
}
