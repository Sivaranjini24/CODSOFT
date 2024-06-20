import java.util.Scanner;

//public class for ATM Interface
public class ATMInterface
{
    public static int takeIntInput(int limit)
    {
        int input =0;
        boolean flag = false;

        while(!flag)
        {
            try
            {
                Scanner sc=  new Scanner(System.in);
                input= sc.nextInt();
                flag=true;
                if(flag &&input>limit || input<1)
                {
                    System.out.println("Choose the number betweeb 1 to "+limit);
                    flag= false;
                }
            }
                catch(Exception e)
                {
                    System.out.println("Enter only integer value:  ");
                    flag = false;
                }
            
        }return input;
    }
    //main method calls the required functions to work
    public static void main(String args[])
    {
        System.out.println("\n............WELCOME CGFC BANK............");
        System.out.println("Choose\n   1 - To register\n   2 - To exit");
        int choose = takeIntInput(2);
        if(choose == 1 )
        {
            BankAccount b= new BankAccount();
            b.register();
            while(true)
            {
                System.out.println("Choose\n    1 - To login\n    2 - To exit");
                int ch = takeIntInput(2);
                if(ch==1)
                {
                    if(b.login())
                    {
                        System.out.println("\n............WELCOME BACK "+b.name+"............");
                        boolean isFinished= false;
                        while(!isFinished)
                        {
                            System.out.println("\nChoose\n    1 - To withdraw\n    2 - To deposit    \n    3 - To tranfer    \n    4 - To check balance \n    5 - To check transaction history\n    6 - Exit");
                            int c= takeIntInput(6);
                            switch(c)
                            {
                                case 1:
                                    b.withdraw();       
                                case 2:
                                    b.deposit();
                                case 3:
                                    b.transfer();
                                case 4:
                                    b.checkBalance();
                                case 5:
                                    b.transHistory();
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        else            
        {
            System.exit(0);
        }
    }
}
//creating a class to store informations temporarily
class BankAccount
{   
	
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this.name = sc.nextLine();
		System.out.println("\nEnter your Username: ");
		this.userName = sc.nextLine();
		System.out.println("\nEnter your Password: ");
		this.password = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNo = sc.nextLine();
        System.out.println("\nREGISTRATION SUCCESSFUL. PLEASE LOG IN TO YOUR BANK ACCOUNT");
    }
    public boolean login()
    {
        boolean isLogin=false;
        Scanner sc= new Scanner(System.in);
        while(!isLogin)
        {

            System.out.println("\n Enter your userName: ");
            String Username= sc.nextLine();
            if(Username.equals(userName))       //checks whether userName==Username
            {
                while(!isLogin)
                {
                    System.out.println("\nEnter Your Password: ");
                    String Password= sc.nextLine();
                    if(Password.equals(password))
                    {
                        System.out.println("\nLOGIN SUCCESSFUL");
                        isLogin = true;
                    }
                    else{
                        System.out.println("\n********Incorrect Password********");
                    }

                } 
            }
            else        //if entered username is wrong this code is executed
            {
                System.out.println("\nUsername not found");
            }
        }
            return isLogin;
    }
        //method for withdrawing amount
        public void withdraw()
        {
            System.out.println("\nEnter amount to withdraw: ");
            Scanner sc= new Scanner(System.in);
            float amount= sc.nextFloat();
            try 
               {
                if(balance >= amount)
                {
                    transactions++;
                    balance -= amount;
                    System.out.println("\n your withdraw done successfully!");
                    String str= amount + "Rs withdrawn\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else{
                    System.out.println("\n********insufficient balance********");
                }
               } catch (Exception e)
               {

               }
            
        }
        //method for depositing amount
        public void deposit()
        {
            System.out.println("\nEnter amount to deposite: ");
            Scanner sc= new Scanner(System.in);
            float amount= sc.nextFloat();
            try 
               {
                if(amount <= 10000f )
                {
                    transactions++;
                    balance+= amount;
                    System.out.println("\n********Your deposition done successfully!********");
                    String str= amount + "Rs deposited\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else
                {
                    System.out.println("\nSorry limit is 10000");
                }
               } catch (Exception e)
               {
                
               }
            
        }
        //method for transfering amount
        public void transfer()
        {
            Scanner sc= new Scanner(System.in);
            System.out.println("\nEnter receiver's name: ");
            String receiver = sc.nextLine();
            System.out.println("\nEnter the amount to be transferred: ");
            float amount= sc.nextFloat();
            try 
               {
                if (balance>=amount)
                {
                if(amount <= 40000f )
                {
                    transactions++;
                    balance -= amount;
                    System.out.println("\n********Successfully transferred to "+receiver+"********");
                    String str= amount + "Rs transferred to "+receiver+"\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else{
                    System.out.println("\n********Oops!, limit is 40000********");
                }
               } 
               else
               {
                    System.out.println("\n********Insufficient balance.********");
               }
               }
               catch (Exception e)
               {

               }
            
        }

        //function to check the balance
        public void checkBalance()
        {
            System.out.println("\n"+balance+" Rs");
        }

        public void transHistory()
        {
            if(transactions==0)
            {
                System.out.println("********No Transaction happened********");
            }
            else
            {
                System.out.println("\n"+transactionHistory);
            }
        }
}


//}
