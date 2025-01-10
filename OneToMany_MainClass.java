package com.MainClass;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class OneToMany_MainClass {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t =s.beginTransaction();
		
		Department d= new Department() ;
		d.setD_id(1002);
		d.setD_name("Dot net developer");
		s.persist(d);
	
		Employee e1= new Employee();
		e1.setEmp_id(111);
		e1.setEmp_name("Shresha");
		e1.setDept(d);
		s.persist(e1);
		
		Employee e2= new Employee();
		e2.setEmp_id(112);
		e2.setEmp_name("Aishu");
		e2.setDept(d);
		s.persist(e2);
		
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		d.setEmp(list);
		
		s.save(d);
		
		System.out.println("Data is inserted........");
		t.commit();
		s.close();
	}
}
