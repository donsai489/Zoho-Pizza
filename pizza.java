/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoho.intern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author saiiyer23
 */
public class pizza {
    public static void menu()
    {
        System.out.println("PIZZA KADAI !!!");
        System.out.println("Choose the option:");
        System.out.println("1. ORDER");
        System.out.println("2. VIEW CART");
        System.out.println("3. EXIT");
    }
    public static int menu1()
    {
        
        int r=0;
        System.out.println("Choose Pizza size:");
        System.out.println("1. Regular - Rs.100");
        System.out.println("2. Medium - Rs.120");
        System.out.println("3. Large - Rs.150");
        Scanner s=new Scanner(System.in);
        System.out.println("Choose - ");
        char p=s.next().charAt(0);
        switch(p)
        {
            case '1':
                r+=100;
                break;
            case '2':
                r+=120;
                break;
            case '3':
                r+=150;
                break;
            default:
                System.out.println("Choose properly");
                break;
        }
        System.out.println("Topping Preference");
        System.out.println("1.Yes - y       2.No - n    ");
        char top=s.next().charAt(0);
        if(top=='y')
        {
            int c[]={30,20,40,50,60,40,20};
            System.out.println("Topping Preference");
            System.out.println("       VEG       ");
            System.out.println("1. Olives - Rs.30");
            System.out.println("2. Onions - Rs.20");
            System.out.println("3. Baby Corn - Rs.40");
            System.out.println();
            System.out.println("      NoN VeG     ");
            System.out.println("4. Bbq Chicken - Rs.50");
            System.out.println("5. Spicy Chicken - Rs.60");
            System.out.println("6. Tikka Chicken - Rs.40");
            System.out.println("7. EXTRA CHEESE - Rs.20");

            System.out.println(" Enter desired topping selection numbers in a squence - ");
            System.out.println();
            Scanner sc=new Scanner(System.in);
            String user_input = sc.nextLine();
        
            String[] stringsArray = user_input.split(" ");
            int[] intArray = new int[stringsArray.length];
            for (int i = 0; i < stringsArray.length; i++) 
            {
                intArray[i] = Integer.parseInt(stringsArray[i]);
            }
        // TODO code application logic here
            for(Integer n:intArray)
            {
                System.out.println(n);
            }
            // TODO code application logic here
            for(Integer n:intArray)
            {
                r+=c[n-1];
            }
            
        }
        System.out.println(" CHOOSE BASE ");
        System.out.println("1. Hand Tossed Pizza - Rs.0");
        System.out.println("2. Wheat Crust Pizza - Rs.20");
        System.out.println("3. Cheese Burst Pizza - Rs.40");
        System.out.println("Enter Your Choice - ");
        char p1=s.next().charAt(0);
        switch(p1)
        {
            case '1':
                r+=0;
                break;
            case '2':
                r+=20;
                break;
            case '3':
                r+=40;
                break;
            default:
                System.out.println("Choose Properly");
                break;
        }
        return r;
    }
    public static int mulorder(int p)
    {
        
        int res=0;
        int a[];
        for(int i=0;i<p;i++)
        {
            res+=menu1();
        }
        cart(res);
        return res;
    }
    public static void cart(int r)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("      CART      ");
        System.out.println("OUTSTANDING ORDER TOTAL - "+r);
        System.out.println("1. Proceed ");
        System.out.println("2. Cancel");
        System.out.println("Choose - ");
        char a=s.next().charAt(0);
        int rs = 0;
        switch(a)
        {
            case '1':
                System.out.println("Apply Offer");
                System.out.println("1. YES = y");
                System.out.println("2. NO = n");
                System.out.println("Enter your choice");
                char off=s.next().charAt(0);
                if(off=='y')
                {
                    rs=offer(r);
                }
                System.out.println("Price After Order - "+rs);
                System.out.println("Order Placed");
                break;
            case '2':
                System.out.println("Canceled order");
        }
    }
    
    public static int offer(int r)
    {
        int res=r;
        System.out.println("    PIZZA EXCITING OFFERS   ");
        System.out.println("1. Apply code Offer");
        System.out.println("2. Apply Daily Offer");
        Scanner s=new Scanner(System.in);
        char o=s.next().charAt(0);
        switch(o)
        {
            case '1':
                System.out.println("Enter Code - ");
                Scanner sn=new Scanner(System.in);
                String offf=sn.nextLine();
                
                if(offf.equals("ZOHO")==true && res>=200)
                {
                    if(res*(10/100)>30)
                    {
                        res-=30;
                    }
                    else
                    {
                        res-=(res*(10/100));
                    }
                    
                }
                else if(offf.equals("JUMBO")==true && res>=400)
                {
                    if(res*(20/100)>100)
                    {
                        res-=100;
                    }
                    else
                    {
                        res-=(res*(20/100));
                    }
                
                }
                break;
            case '2':
                res-=100;
                break;
            
        }   
        System.out.println("OFF"+res);
        return res;
    }
    public static void main(String[] args)
    {
        
        System.out.println("---------PIZZA KADAI----------");
        menu();
        System.out.println("Choose Selection - ");
        Scanner sc=new Scanner(System.in);
        char p=sc.next().charAt(0);
        int cartvalue=0;
        switch(p)
        {
            case '1':
                System.out.println("Choose Number of Pizza to order ");
                int p1=sc.nextInt();
                cartvalue=mulorder(p1);
                break;
            case '2':
                cart(cartvalue);
                break;
            case '3':
                System.exit(0);
                break;
            default:
                System.out.println("Choose Properly");
                break;
        }

        

        
        
        
    }
}
