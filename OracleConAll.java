import java.sql.*; 
import java.util.Scanner;  
import javax.swing.JOptionPane; 

class OracleConAll{  

    public static void main(String args[])
    { 
	try
	{ 
 		//step1 load the driver class   
		Class.forName("oracle.jdbc.driver.OracleDriver");    

		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
		//step3 create the statement object  
		Statement stmt=con.createStatement();   

 		//step4 execute query
		PreparedStatement statement1 = null;
		Scanner sc=new Scanner (System.in);
		ResultSet rs; 
		int ch,ch1,i,a;
		String n; 
		do
		{
		System.out.println("\t\t**********####***********\n\n");
		System.out.println("\n\t\t1.\tINSERT\n\t\t2.\tDELETE \n\t\t3.\tUpdate\n\t\t4.\tSelect");
		System.out.println("\t\t**********####***********\n\n");
		System.out.print("\tEnter the choice\t>>");
		ch=sc.nextInt();
		switch(ch)
		{
			case 1:
				String insertQ ="INSERT INTO emp(ID,name,age)"+"VALUES (?,?,?)"; 
				statement1 = con.prepareStatement(insertQ);
				System.out.print("Enter the emp Id>>>\t");
				statement1.setInt(1,sc.nextInt()); 
				System.out.print("Enter the emp Name>>>\t");
				statement1.setString(2,sc.next()); 
				System.out.print("Enter the emp Age>>>\t");
				statement1.setInt(3,sc.nextInt());
				statement1.execute();

		 		JOptionPane.showMessageDialog(null, "successfully inserted");
				break;
			case 2:
				System.out.print("Enter the emp Id\t>>>");
				i=sc.nextInt();
		
				String deleteQuery = "delete from emp where id="+i;
            			statement1 = con.prepareStatement(deleteQuery);
            			statement1.execute();
            			JOptionPane.showMessageDialog(null, "Deleted");
				break;
			case 3:
				System.out.print("Enter the emp Id\t>>>");
				i=sc.nextInt();
				System.out.print("Enter the emp Name\t>>>");
				n=sc.next();
				System.out.print("Enter the emp Age\t>>>");
				a=sc.nextInt();
				String updateF = "update emp set name= '" + n + "', age= " + a + " where Id = " + i + "" ;
		
            
            			statement1 = con.prepareStatement(updateF);

            			statement1.execute();

            			JOptionPane.showMessageDialog(null, "successfully update ");
				break;
			case 4:
				rs=stmt.executeQuery("select * from emp"); 
				System.out.println("\t\t**********####***********\n\n");
				System.out.println("\tDetails of Emp Tables\n"+"\n\t\tID\tName\t age");
				System.out.println("\t\t*************************\n\n");
 				while(rs.next())   
				System.out.println("\t\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));  
				System.out.println("\t\t**********####***********\n\n");  
				JOptionPane.showMessageDialog(null, "Dispaly successfully");
				break;
			default:	
				System.out.println("\t\tYou press worng choice");
			break;

		}
			System.out.print("\n\tDo you want Manu\n\tEnter the choice yes or no\t>>");
			ch1=sc.next().charAt(0);
			
		}while(ch1=='Y'||ch1=='y');

		//step5 close the connection object   
		con.close();    
	}
	catch(Exception e)
	{ 
		System.out.println(e);
	}    
     }  
}  

