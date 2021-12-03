import java.io.*;  
import java.util.*;
/***
 * Main Idea: 
 * -Loop Through CSV file:
 *      1) Use the delimter , to get the Cookie name and Timestamp
 *      2) Split timestamp using T as delimeter
 *      2) Check if cookie timestamp is equal to our date
 *      3) Add cookie to hashmap if we have never seen it or add 1 to its current count if we have seen it previously
 * -After looping thorugh CSV file:
 *  1) Loop through hashmap 
 *  2) If the entrys maximum is greater than our current maximum clear printList and set the only element to cookie name
 *  3) If the entry maximum is the same as our current maximum add its name on to our current printlist
 */

class MostActiveCookie {
   ArrayList <String> printList = new ArrayList <String>();
   HashMap <String,Integer> counts = new HashMap <String,Integer>();
   int maxCount = 0;

public void parseCSV(String fileName, String dateParameter) throws FileNotFoundException{
    Scanner sc = new Scanner(new File(fileName));
    sc.useDelimiter(",");
    while (sc.hasNextLine()){
        String line = sc.nextLine();
        String [] tokensInLine = line.split(",");
        String cookie = tokensInLine[0];
        String timestamp = tokensInLine[1];
        String [] fullTimeStamp = timestamp.split("T");
        String cookieDate = fullTimeStamp[0];
        if (cookieDate.equals(dateParameter)){
            counts.put(cookie, counts.getOrDefault(cookie, 0) + 1);
        }
    }

    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
        String key = entry.getKey();
        int value = entry.getValue();
        if (value > maxCount){
            maxCount = value;
            printList.clear();
            printList.add(key);
        }
        else if (value == maxCount){
            printList.add(key);
        }
    }
    
    for (String str:printList){
        System.out.println(str);
    }

}   
public static void main(String[] args){
    try{
        MostActiveCookie obj = new MostActiveCookie();
        obj.parseCSV(args[0], args[1]);
    } catch(FileNotFoundException E) {
        System.out.print("Could not find file");
        E.printStackTrace();
    }
}


}
