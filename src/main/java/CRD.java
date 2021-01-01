import java.util.Scanner;

public class CRD {
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int input=0;
        while(true)
        {
            System.out.println("Enter Your Choice : 1. Create 2. Read 3. Delete 4. Exit");
            input = scan.nextInt();
            if(input>=1 && input<=4)
            {
                if(input==1){

                    Create newCreate = new Create(); // creating a object of "Create" class.
                    newCreate.create(); //Calling create method in "Create" class to add new data into database

                }else if(input==2)
                {
                    Read newRead = new Read();
                    newRead.read(); //Calling read method in "Read" class to read key from database

                }else if(input==3)
                {
                    Delete newDelete = new Delete();
                    newDelete.delete(); //Calling delete method in "Delete" class to delete key from database

                }else {
                    System.out.println("You are Exiting from Program.");
                   System.exit(0);
                }
            }
            else
            {
                System.out.println("Please Choose Correct Option from below.");
            }
        }
    }
}
