import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Create {
    public void create() {

        File file = new File("./database/data.json");
        Scanner scan = new Scanner(System.in);

        try{

            if(file.createNewFile())
            {
                //If file not Exists create new file.

                System.out.println("File Created "+file.getName());
                FileWriter fw = new FileWriter("./database/data.json");
                JSONArray dummy_data = new JSONArray();
                System.out.println(dummy_data);
                fw.write(dummy_data.toJSONString());
                fw.flush();
                fw.close();
            }
            else{
                //Taking user input for "Create" choice.

                System.out.print("Key: ");
                String inputKey;
                inputKey = scan.nextLine();
                System.out.print("Value: ");
                String inputValue;
                inputValue = scan.nextLine();

                //Converting given key value into the JSon object.

                JSONObject data = new JSONObject();
                data.put("value",inputValue);
                data.put("key",inputKey);

                try {
                    FileReader readData = new FileReader("./database/data.json");
                    double size  = ((double)file.length()/(1024*1024));
                    if(size<1024)
                    {
                        Object dataObj = new JSONParser().parse(readData);
                        JSONArray preData = (JSONArray) dataObj;
                        int flag=0;
                        // Checking that inputKey is already Exists or not in database.
                        for(Object dataKey : preData)
                        {
                            JSONObject temp = (JSONObject) dataKey;
                            String tempKey = (String) temp.get("key");
                            if(tempKey.equals(inputKey))
                            {
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0)
                        {
                            preData.add(data);
                            FileWriter fw = new FileWriter("./database/data.json");
                            fw.write(preData.toJSONString());
                            fw.flush();
                            fw.close();
                            System.out.println("Your Data is Successfully Stored into Database");
                        }
                        else
                        {
                            System.out.println("ERR: Key is Already Exists in Database");
                        }
                    }
                    else
                    {
                        System.out.println("ERR: Size of Database exceeded to 1GB!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
