
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;



public class Test
{

    public static void stringTokenizer()
    {
         StringTokenizer st = new StringTokenizer("Drink catusjuice,It will quench ya|nothing|quenchier?Its the quenchiest", " , |? ");
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }
        Stack mystack = new Stack();
        while(st.hasMoreTokens())
        {
            mystack.push(st.nextToken());
        }
        while(!mystack.isEmpty())
        {
            System.out.println(mystack.pop());
        }
    }
    public static void stringReverse()
    {
        StringBuffer s = new StringBuffer("asdfghj");
        System.out.println(s.reverse());
    }
    public static void regularExpresion()
    {
        String regex = "[abc]";
        System.out.println(Pattern.matches(regex, "c"));
    }
    public static void dateFormat()
    {
        Date currentdate = new Date();
        //Calendar.getInstance().getTime();
        System.out.println(currentdate);
        String stringtodate;
        stringtodate = DateFormat.getInstance().format(currentdate);
        System.out.println(stringtodate);
        stringtodate = DateFormat.getDateInstance().format(currentdate);
        System.out.println(stringtodate);
        stringtodate = DateFormat.getTimeInstance().format(currentdate);
        System.out.println(stringtodate);
        stringtodate = DateFormat.getDateTimeInstance().format(currentdate);
        System.out.println(stringtodate);
        stringtodate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(currentdate);
        System.out.println(stringtodate);
    }
    public static void setDate()
    {
        int year = 2020;
        int month = 7;
        int date = 15;
        int hourOfDay = 12;
        int minute = 30;
        int second = 20;
        Calendar d = Calendar.getInstance();
        d.set(year, month, date, hourOfDay, minute, second);
        System.out.println(d.getTime());
    }
    public static void simpleDateFormat()
    {
        Date date1 =  new Date();//curentdate
        SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//convert a string to date
        try {
            date1 = fomatter.parse("2000-7-15 13:24:30");
            System.out.println(date1);
        } catch (ParseException e) {}
        Date now = new Date();//currentdate
        long result = now.getTime() - date1.getTime();//get millisec between now and 15/jul/2000
        System.out.println(result/(24*60*60*1000) + " Days");
    }
    public static void copyfileCharacterStream(String fileinput, String fileOuput) throws IOException, FileNotFoundException
    {
        FileReader fr = new FileReader(fileinput);
        BufferedReader in = new BufferedReader(fr);
        FileWriter fw = new FileWriter(fileOuput);
        BufferedWriter out = new BufferedWriter(fw);
        copyFile(in, out);
        in.close();
        out.close();
    }
    public static void copyFile(BufferedReader in , BufferedWriter out) throws IOException, FileNotFoundException
    {
        String line;
        while((line = in.readLine()) != null)
        {
            System.out.println(line);
            out.write(line+"\n");
        }
    }
    public static void readingFile()
    {
        try {
            FileReader filereader = new FileReader("C:/Users/PC/Desktop/korra.txt");
            BufferedReader bf = new BufferedReader(filereader);
            while(bf.readLine() != null)
            {
                System.out.println(bf.readLine());
            }
            filereader.close();
            bf.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void converterFile() throws IOException, FileNotFoundException
    {
        FileInputStream f = new FileInputStream("C:/Users/PC/Desktop/kanji.txt");//connect to byteStream file
        InputStreamReader convert = new InputStreamReader(f, "UTF8");//convert byte stream to character stream
        BufferedReader b = new BufferedReader(convert);//read character stream
        System.out.println(b.readLine());

    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        //Test.stringReverse();
        //Test.stringTokenizer();
        //regularExpresion();
        //dateFormat();
        //setDate();
        //simpleDateFormat();
        //readingFile();
        // copyfileCharacterStream("C:/Users/PC/Desktop/korra.txt",  "C:/Users/PC/Desktop/genji.txt");
        // converterFile();
        

        
        
        

    }
    
}