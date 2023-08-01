package mainPackage;

import java.util.Scanner;

public class Main{
	
	private static String port = "3306";
	private static String databaseName = "miniproject";
	private static String userName = "root";
	private static String password = "tiger";
	private static int id ; 
	
	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		Main.port = port;
	}

	public static String getDatabaseName() {
		return databaseName;
	}

	public static void setDatabaseName(String databaseName) {
		Main.databaseName = databaseName;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		Main.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Main.password = password;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Main.id = id;
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		boolean status = false;
		while(loop) 
		{
			System.out.println("\n==================================================");
			System.out.println("\t\tLogin");
			System.out.println("==================================================");
			System.out.println("(1) SignIn");
			System.out.println("(2) SignUp");
			System.out.print("Enter option: ");
			String option = input.next(); 
			Sql.LoadingMessage();
			
			
			if( option.equals("1") )
			{
				Login login = new Login(port , databaseName , userName , password) ;
				int result = login.mainLogin() ;
				if( result != 0 )
				{
					id = result ;
					System.out.println("Sucessful");
					status = true ;
				}
				else 
					continue ;
			}
			else if( option.equals("2") )
			{
				SignUp signup = new SignUp(port , databaseName , userName , password) ;
				signup.mainSignUp() ;
				continue ;
			}
			else 
			{
				System.out.println("Invalid Option ");
				continue ;
			}

			if( status )
				break ;
			System.out.println("Invalid UserName or Password ");

		}
		
		loop = true;
		while(loop) 
		{
			System.out.println("\n==================================================");
			System.out.println("\tPersonal Finance Manager");
			System.out.println("==================================================");
			System.out.println("~~ Enter \"X\" for update connection info");
			System.out.println("(1) View Income/Expense");
			System.out.println("(2) Review Income/Expense");
			System.out.println("(3) Add Income/Expense");
			System.out.println("(4) Delete Income/Expense");
			System.out.println("(0) Exit");
			System.out.print("Enter option: ");
			String num = input.next();
			Sql.LoadingMessage();
			
			if(num.equals("X") || num.equals("x"))
				updateConnection();
			else if(num.equals("1")) {
//				Select select = new Select(port, databaseName, userName, password);
				Select select = new Select(port , databaseName , userName , password) ;
				select.mainFunc( id ) ;
				continue ;
				
			}
			else if(num.equals("2")) {
				Survey survey = new Survey(port , databaseName , userName , password) ;
				survey.mainFunc( id ) ;
			}
			else if(num.equals("3")) { 
				Insert insert = new Insert(port, databaseName, userName, password);
				insert.mainFunc( id );
			}
			else if(num.equals("4")) {
				Delete delete = new Delete(port, databaseName, userName, password);
				delete.mainFunc(id);
				System.out.println("Option : 4 ");
			}
			else if(num.equals("0")) 
				loop = false;
			else
				loop = true;
		}	
		System.out.println("\n----------------------[Exit]----------------------\nProgram terminated");	
	}
	
	public static void updateConnection() 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n=================[connection info]=================");
		System.out.print("Enter Port: ");
	    port = input.next();
		System.out.print("Enter database name: ");
		databaseName = input.next();
		System.out.print("Enter User name: ");
		userName = input.next();
		System.out.print("Enter password for Service: ");
	    password = input.next();
	    
//	    Sql update = new Sql(port, databaseName, userName, password);
	}
	
//	public void mainFunc( int id )
//	{
//		return ;
//	}
}
