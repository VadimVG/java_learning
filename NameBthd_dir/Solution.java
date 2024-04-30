package test_classes.NameBthd_dir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String file_path= args[0];
        BufferedReader bufferedReader= new BufferedReader(new FileReader(file_path));
        while (bufferedReader.ready()){
            ArrayList<String> lst= new ArrayList<>(Arrays.asList(bufferedReader.readLine().split(" ")));
            String name= "";
            String brth="";
            for (int i = lst.size()-1; i >=0 ; i--) {
                if (i<lst.size()-3){
                    name=lst.get(i)+" "+name;
                }
                else brth=lst.get(i)+" "+brth;
            }
            name=name.trim();
            brth=brth.trim();
            DateFormat dateFormat=new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date=dateFormat.parse(brth);
            PEOPLE.add(new Person(name, date));
        }
        bufferedReader.close();
        for (Person p: PEOPLE){
            System.out.println(String.format("%s %s", p.getName(), p.getBirthDate()));
        }
    }
}
