package test_classes.ProductCRUD_dir;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductCRUD {
    public static void main(String[] args) throws Exception {
        if (args.length==0) return;
        else {
            String file_path=new Scanner(System.in).nextLine();
            BufferedReader file= new BufferedReader(new InputStreamReader(new FileInputStream( file_path))); // получение содержимого файла
            String id=args[1]; // получение id
            String line;
            ArrayList<String> total= new ArrayList<>();
            if (args[0].equals("-d")){ // проверка на флаг
                while ((line=file.readLine())!=null){ // если id из файла не равен id из входящих параметров, то добавляем в массив строку
                    if (Integer.parseInt(line.substring(0, 8).replace(" ", ""))!=Integer.parseInt(id.replace(" ", ""))) {
                        total.add(line);
                    }
                }
                FileWriter wr= new FileWriter(file_path);
                String for_wr="";
                for (String i: total) for_wr+=i+"\n";
                wr.write(for_wr.substring(0, for_wr.length()-1)); // запись данных в файл
                wr.close();
            }
            else {
                String name="";
                for (int i = 2; i < args.length-2; i++) {
                    name+=args[i]+" ";
                }
                name=name.substring(0, name.length()-1);
                String price=args[args.length-2];
                if (price.length() > 8) { // проверка содержимого из входящих параметров на кол-во символов
                    price = price.substring(0, 8);
                }
                String cnt=args[args.length-1];
                if (cnt.length() > 4) {
                    cnt = cnt.substring(0, 4);
                }
                String upd= String.format("%-8d%-30s%-8s%-4s", Integer.parseInt(id.replace(" ", "")), name, price, cnt); // преобразование строки в нужный формат
                while ((line=file.readLine())!=null){
                    if (Integer.parseInt(line.substring(0, 8).replace(" ", ""))!=Integer.parseInt(id.replace(" ", ""))) {
                        total.add(line);
                    }
                    else total.add(upd);
                }
                FileWriter wr= new FileWriter(file_path);
                String for_wr="";
                for (String i: total) for_wr+=i+"\n";
                wr.write(for_wr.substring(0, for_wr.length()-1));
                wr.close();
            }
            file.close(); // закрытие файлового потока
        }
    }
}
