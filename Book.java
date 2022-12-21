

import java.util.Scanner;

public class Book{
    //variable declaration
    static int n;
    int id=0;
    private String title;
    private String cat;
    private int price;
    private int quan;
    private int reve;
    static  int amount;

// this is the constructur of the book class
    public Book()

    {

        cat="Not Available";

    }

    Scanner s= new Scanner(System.in);
    public static void main(String [] arg)
    {
        // this is the main menu of the program
        Scanner s=new Scanner(System.in);
        String t,x;
        Book b[]=new Book[30];
        char a;
        do
        {
            System.out.println("\n----------Welcome to Book Shop Management System-----------\n");
            System.out.println("\tTo Register any book enter a");
            System.out.println("\tTo dis1play your book records enter b");
            System.out.println("\tTo search a book in stock enter c");
            System.out.println("\tTo buy a book enter d");
            System.out.println("\tTo see total revenue enter e");
            System.out.println("\tEnter q to quite\n");
            System.out.print(">>");

            a=s.next().charAt(0);
            switch(a)
            {
                case 'a':
                    System.out.println("How many books do you want to record?");
                    System.out.print(">>");
                    n =s.nextInt();
                    for(int i=0;i<n;i++)
                    {
                        b[i]=new Book();
                        System.out.println("Enter the detail for Book\n"+(i+1)+"\n");
                        b[i].setName();
                        b[i].setId((i+1));
                        b[i].setCategory();
                        b[i].setPrice();
                         System.out.println("\n");}
                    break;
                case 'b':
                    for (int i=0;i<n;i++)
                    {  System.out.println("Enter Book detail "+(i+1)+"\n");
                        System.out.println(b[i].toString());

                        // b[i].display();
                        System.out.println("\n");
                    }
                    break;
                case 'c':
                { System.out.println("Please enter the title of book you want to search");
                    System.out.print(">>");
                    t=s.next();
                    System.out.println("Please enter the category of book you want to search");
                    System.out.print(">>");

                    x=s.next();
                    int f=0;
                    for(int i=0;i<n;i++)
                    {
                        if((t.equals(b[i].title) && x.equals(b[i].cat)))
                        {
                            System.out.println("Book  found");
                            System.out.println("detail of the book is");
                            System.out.println("\n");

                            b[i].display();
                            System.out.println("\n");
                            break;
                        }
                        else
                        {
                             System.out.println("Book not found");
                        }

                    }


                    break;
                }
                case 'd':
                    System.out.println("Please enter the title of the book you want to buy");
                    System.out.print(">>");
                    String titkey=s.next();

                    for(int i=0;i<n;i++)
                    {
                        if(titkey.equals(b[i].title))
                        {
                            System.out.println("Book  found");
                            System.out.println("Detail of the book is");
                            System.out.println("\n");


                            b[i].display();
                            System.out.println("\n");
                            b[i].isAvailable();
                            //b[i].saleBook();
                            System.out.println("To see total revenues press 1");
                            int y=s.nextInt();
                            if(y==1)
                            { b[i].totalRevenue();}

                            b[i].quan=b[i].quan-amount;
                            System.out.println("\n");

                            break;}

                        else
                        {
                            System.out.println("Book not found");
                        }
                    }
                    break;


                case 'e':
                    for(int i=0;i<n;i++)
                    {   System.out.println("Your total revenue is " + b[i].totalRevenue());}
                    break;
                case 'q':
                    System.out.println("Thank you and Good bye");
                    break;

                default:
                    System.out.println("invalid input");
            }
        }while(a!='q');



    }
    //set method for id
    public void setId(int id)
    {

        this.id=id;


    }

//set method for name
    public void setName()
    {String name;
        System.out.println("Book title");
        System.out.print(">>");
        name=s.nextLine();
        title=name;
    }
//set method for category
    public void setCategory()
    {String categ;
        System.out.println("Book category");
        System.out.print(">>");
        categ=s.nextLine();
        cat=categ;
    }
//set method for price
    public void setPrice()
    {int bprice;
        System.out.println("Book price");
        System.out.print(">>");
        bprice=s.nextInt();
        price=bprice;
    }
//set method for quantity
    public void setQuan()
    {int quant;
        System.out.println("Book quantity");
        System.out.print(">>");
        quant=s.nextInt();
        quan=quant;
    }
//set method for revenue
    public void setREVE(int reven)
    {
        reve=reven;
    }
//get method for retriving the tittle
    public String getName(){

        return title;

    }
//get method for retriving the id
    public int getId(){
        return id;
    }
//get method for retriving the category
    public String getCat(){
        return cat;
    }
//get method for retriving the price
    public int getPrice(){
        return price;
    }
//get method for retriving the quantity
    public int getQuantity(){
        return quan;
    }
//get method for retriving the Revenue
    public int getRevenue(){
        return reve;
    }

    public void isAvailable()
    {
        Book a=new Book();


        System.out.println("How many do you want");
        amount=s.nextInt();

        if(amount>quan)
        { System.out.println("Book out of Stock\n");
        }
        else
        {

            System.out.println("Book in Stock");
            a.saleBook();

        }
    }


    public void saleBook(){
        System.out.println("To confirm buy press 1 and to cancel press 0 ");
        int confirm=s.nextInt();
        if(confirm==1)
            System.out.println("Book Successfully bought thank you for shopping with us");
        else
            System.out.println("thank you for visiting");

    }
    public int totalRevenue(){
        reve+=amount*price;
        System.out.println("the total revenue is " +reve);
        return reve;

    }


    public void display(){

        System.out.println("book id= "+id);
        System.out.println("book title= "+title);
        System.out.println("book category= "+cat);
        System.out.println("unit price "+price);
        System.out.println("quantity in stock "+quan);
    }
    @Override
    public String toString(){
        return     String.format  ( "%s%s%n%s%s%n%s%s%n%s%d%n%s%n%s%n",
                "Book Id= ",id,
                "Book Title= ",title,
                "Book Category= ",cat,
                "Unit price= ",price,
                "Quantity in stock= ",quan);


    }

}



