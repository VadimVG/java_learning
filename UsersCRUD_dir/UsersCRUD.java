package test_classes.UsersCRUD_dir;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

public class UsersCRUD {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args[0].equals("-c")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

            String dateInString = args[3].replace('/', '-');
            Date date = formatter.parse(dateInString);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], date));
            }
            else {allPeople.add(Person.createFemale(args[1], date));}
            System.out.println(allPeople.size()-1);
        }
        if (args[0].equals("-r")){
            Person s=allPeople.get(Integer.parseInt(args[1]));
            String fs=s.getName();
            if (s.getSex()==Sex.MALE) fs=fs+" м "+ new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(s.getBirthDate());
            else fs=fs+" ж "+ new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(s.getBirthDate());
            System.out.println(fs);
        }
        if (args[0].equals("-u")){
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals("м")){
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            }
            else {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(args[4].replace('/', '-')));
        }
        if (args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
        }
    }
}
