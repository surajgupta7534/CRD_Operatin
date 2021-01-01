import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Read {

    public void read() {
        File file = new File("./database/data.json");
        Scanner scan = new Scanner(System.in);

        try{

            if(file.createNewFile())
            {
                System.out.println("ERR: Database is not Exists.");
            }
            else
            {
                String readKey;
                System.out.print("Enter the Key: ");
                readKey = scan.nextLine();
                FileReader readData = new FileReader("./database/data.json");
                Object dataObj = new JSONParser().parse(readData);
                JSONArray preData = (JSONArray) dataObj;
                int flag=0;
                for(Object dataKey : preData)
                {
                    JSONObject temp = (JSONObject) dataKey;
                    String tempKey  = (String) temp.get("key");
                    if(tempKey.equals(readKey))
                    {
                        System.out.println(dataKey);
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("ERR: Oops! Key doesn't exists in Database");
                }
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
