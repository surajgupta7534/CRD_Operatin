import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Delete {

    public void delete()
    {

        File file = new File("./database/data.json");
        Scanner scan = new Scanner(System.in);
        try
        {
            if(file.createNewFile())
            {
                System.out.println("ERR: Database doesn't Exists");
            }
            else
            {
                String deleteKey;
                System.out.print("Enter the Key: ");
                deleteKey = scan.nextLine();
                int flag=0;
                JSONArray updatedData = new JSONArray();
                FileReader readData = new FileReader("./database/data.json");
                Object dataObj = new JSONParser().parse(readData);
                JSONArray preData = (JSONArray) dataObj;
                for(Object dataKey : preData)
                {
                    JSONObject temp = (JSONObject) dataKey;
                    String tempKey = (String) temp.get("key");
                    if(tempKey.equals(deleteKey))
                    {
                        System.out.print(dataKey);
                        flag=1;
                    }
                    else
                    {
                        updatedData.add(dataKey);
                    }
                }
                if(flag==1)
                {
                    FileWriter fw = new FileWriter("./database/data.json");
                    fw.write(updatedData.toJSONString());
                    fw.flush();
                    fw.close();
                    System.out.println(" --> is deleted from the database.");
                }
                else
                {
                    System.out.println("ERR: Key doesn't exists in the database");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
