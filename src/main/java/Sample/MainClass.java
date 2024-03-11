package Sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class MainClass {
public static void main(String[] args) throws IOException {
	EntityManagerFactory f = Persistence.createEntityManagerFactory("Lotus1");
	EntityManager m = f.createEntityManager();
	EntityTransaction t = m.getTransaction();
	
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	while(flag)
	{
		System.out.println("1.Add\n2.Fetch\n3.Update\n4.Remove\n5.Fetch all\n6.Exit");
		switch(sc.nextInt())
		{
		case 1 :{
			Employee e = new Employee();
			System.out.println("Enter Name");
			e.setEname(sc.next());
			System.out.println("Enter Company Name");
			e.setCompanyNmae(sc.next());
			System.out.println("Enter Salary");
			e.setEsalary(sc.nextDouble());
			System.out.println("Enter Address");
			e.setAddress(sc.next());
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter path to add resume");
			FileInputStream fi = new FileInputStream(sc2.nextLine());
			byte[] b = new byte[fi.available()];
			fi.read(b);
			e.setResume(b);
			t.begin();
			m.persist(e);
			t.commit();
			System.out.println("Added");
		}
		break;
		case 2:{
			System.out.println("Enter id");
			Employee e = m.find(Employee.class, sc.nextInt());
			if(e!=null)
			{
				System.out.println("Id: "+e.getEid());
				System.out.println("Name is "+e.getEname());
				System.out.println("Company name is "+e.getCompanyNmae());
				System.out.println("Salary is "+e.getEsalary());
				System.out.println("Address is "+e.getAddress());
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Specify the path to add resume");
				FileOutputStream fs = new FileOutputStream(sc3.nextLine());
				fs.write(e.getResume());
				System.out.println("Added");
				
			}
			else
			{
				System.out.println("Data not found");
			}
		}
		break;
		case 3:
		{
			System.out.println("Enter id");
			Employee e = m.find(Employee.class, sc.nextInt());
			if(e!=null)
			{
				System.out.println("Enter new salary to update");
				e.setEsalary(sc.nextDouble());
				t.begin();
				m.merge(e);
				t.commit();
				System.out.println("Updated");
			}
			else
			{
				System.out.println("Data not found");
			}
		}
		break;
		case 4 :
		{
			System.out.println("Enter id to remove");
			Employee e = m.find(Employee.class, sc.nextInt());
			if(e!=null)
			{
				t.begin();
				m.remove(e);
				t.commit();
				System.out.println("Deleted");
			}
			else
			{
				System.out.println("Data not found");
			}
		}
		break;
		case 5 :
		{
			Query q = m.createQuery("Select a from Employee a");
			List<Employee> z = q.getResultList();
			for(Employee e:z)
			{
				System.out.println("Id: "+e.getEid());
				System.out.println("Name is "+e.getEname());
				System.out.println("Company name is "+e.getCompanyNmae());
				System.out.println("Salary is "+e.getEsalary());
				System.out.println("Address is "+e.getAddress());
		}
		}
		break;
		case 6 :
		{
			flag = false;
			System.out.println("Thank you");
		}
		break;
		default:
		{
			System.out.println("Invalid Input");
			break;
		}
	}
}
}
}
