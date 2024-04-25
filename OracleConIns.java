import java.sql.*;  
import javax.swing.JOptionPane;
class OracleConIns{  

    public static void main(String args[])
    { 
	try
	{ 
 		//step1 load the driver class   
		Class.forName("oracle.jdbc.driver.OracleDriver");    

		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  		JOptionPane.showMessageDialog(null, "successfully Connected to Database");
		//step3 create the statement object  
		Statement stmt=con.createStatement();   

 		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from emp"); 
		System.out.println("Details of Emp Tables\n"+"ID\tName\t age");
 		while(rs.next())   
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));    
		JOptionPane.showMessageDialog(null, "Dispaly successfully");

		PreparedStatement statement1 = null;
		String insertQ ="INSERT INTO emp(ID,name,age)VALUES (6,'dsdas',29)"; 
        
            	statement1 = con.prepareStatement(insertQ);

            	statement1.execute();

		JOptionPane.showMessageDialog(null, "successfully inserted a new Food Type");

		rs=stmt.executeQuery("select * from emp"); 

 		while(rs.next())   
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)); 

            	
		
		//step5 close the connection object   
		con.close();    
	}
	catch(Exception e)
	{ 
		System.out.println(e);
	}    
     }  
}  

