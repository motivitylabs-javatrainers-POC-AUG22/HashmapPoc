package hibernateCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main implements Comparable<Student> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cf=new Configuration();
		
		cf.configure("hibernate.xml");
		 
		SessionFactory sf=cf.buildSessionFactory();
		Session se=sf.openSession();
		Transaction tx=se.beginTransaction();
		
		
		HashMap<Integer,Student> hm=new HashMap<>();
		hm.put(1,new Student(109,"nikhil",600));
		System.out.println("hash code: "+hm.hashCode());
		int Index1 =hm.hashCode() & (16-1);
		System.out.println("student 1: "+Index1);
        hm.put(2,new Student(108,"akhil",800));
        System.out.println("hash code: "+hm.hashCode());
		int Index2 =hm.hashCode() & (16-1);
		System.out.println("student 2: "+Index2);
        hm.put(3,new Student(105,"Ramya",700));
        System.out.println("hash code: "+hm.hashCode());
		int Index3 =hm.hashCode() & (16-1);
		System.out.println("student 3: "+Index3);
        hm.put(4,new Student(107,"venu",900));
        System.out.println("hash code: "+hm.hashCode());
		int Index4 =hm.hashCode() & (16-1);
		System.out.println("student 4: "+Index4);
        hm.put(5,new Student(103,"murali",800));
        System.out.println("hash code: "+hm.hashCode());
		int Index5 =hm.hashCode() & (16-1);
		System.out.println("student 5: "+Index5);
        hm.put(6,new Student(106,"kumar",900));
        System.out.println("hash code: "+hm.hashCode());
		int Index6 =hm.hashCode() & (16-1);
		System.out.println("student 6: "+Index6);
        hm.put(7,new Student(104,"nikki",400));
        System.out.println("hash code: "+hm.hashCode());
		int Index7 =hm.hashCode() & (16-1);
		System.out.println("student 7: "+Index7);
        hm.put(8,new Student(102,"ram charan",900));
        System.out.println("hash code: "+hm.hashCode());
		int Index8 =hm.hashCode() & (16-1);
		System.out.println("student 8: "+Index8);
		hm.put(9,new Student(101,"power star",700));
		System.out.println("hash code: "+hm.hashCode());
		int Index9 =hm.hashCode() & (16-1);
		System.out.println("student 9: "+Index9);
		
		System.out.println("student 9: "+hm.hashCode());
		
		System.err.println("------adding marks by 5-------");
		List<Integer> obj=hm.entrySet().stream().map(e->e.getValue().getMarks()+5).toList();
		obj.forEach(e->{
			System.out.println(e);
		});
		
		
//		List<Student> list=hm.entrySet().stream().filter(e->e.getValue()).sort.Collections(hm,list).compareTo().Collectors.Collect().toList();
//				sorted(Comparator.comparingInt(Student::getMarks));
		
		Stream<Map.Entry<Integer, Student>> entrySet=hm.entrySet().stream();
		
//		List<Integer> sorted =entrySet
//				.sorted(Comparator.comparing(Map.Entry::getValue()))
//	            .map(Map.Entry::getKey)
//	            .collect(Collectors.toList());
//		hm.forEach(System.out.println(e->e.getValue().getName()));
		List<String> uplist = new LinkedList<String>();
		List<Integer> upid = new LinkedList<Integer>();
	    Iterator<Entry<Integer,Student>> iterator=hm.entrySet().iterator();
	 System.out.println( "object is "+hm.putIfAbsent(1,new Student(109,"nikhil",600)));
	    while(iterator.hasNext())
	   {
		   Entry<Integer,Student> st=iterator.next();
		   System.out.println(st);
		   Student st3 = st.getValue();
		   uplist.add(st3.getName().toUpperCase()); 
		   upid.add(st3.getId());
	   }
	   System.out.println(uplist);
	  
	   
	   System.out.println("====name in uppercase======");
	   
	   

		Student s1 = new Student();
		
		Iterator<Integer> id1 = upid.iterator();
		Iterator<String> name2 = uplist.iterator();
		int k=0;
		
	while(id1.hasNext())
	{
		while(name2.hasNext())
		{
		Query q1 = se.createQuery("Update Student s set s.name = ?1 where s.id=?2");
		q1.setParameter(1, name2.next());
		q1.setParameter(2, id1.next());
		k =q1.executeUpdate();
		}
	}
	if(k>0)
	{
		System.out.println("successsssss");
		System.err.println("=====================================================");
	}
	   
	  
	   
	   System.err.println("=====Reverse order=======");
	   
	   hm.entrySet()   
	      .stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))  
	      
	      //Performs an action for each element of this stream  
	      .forEach(System.out::println); 
	   
	   System.out.println("======remove a element from list====");
	   System.out.println(hm.remove(2));
	   System.out.println("updated list of element: "+hm);
	   
//	   System.out.println("====================to uppercase first letter=========================");
	   
	   
	   
	   
       //List<String>lt1= hm.entrySet().stream().map(<Entry<Integer,Student>,String>mapper)e->e.getValue().getName().substring(0,1).toUpperCase()+e.getName().substring(1)).collect(Collectors.toList());
	   //List<String>lt1= hm.entrySet().stream().m
	   //System.out.println(lt1);
//	  HashMap< Integer,Student> newMap = hm.values()
//			  .stream()
//		        .collect(Collectors.toMap(key -> key.toUpperCase(), key -> imap.get(key)));
//       hm.stream().forEach(employee -> System.out.println(employee));
//	   
	   
	   
	   
	
	System.out.println("===================getting sorted list by id==========================");
//  List<Integer> num=li.stream().sorted(Comparator.comparing(Employee::getCity,String.l).collect(Collectors.toList());
//  num.forEach(((e2)-> System.out.println(e2.getId()+" "+e2.getName()+" "+e2.getAge()+" "+e2.getSalary()+" "+e2.getCity());
//  List<Student> em=list.stream().sorted(Comparator.comparingInt(Student::getId)).collect(Collectors.toList());
  //em.forEach((e)->System.out.println(e.getId()+" "+e.getName()+" "+e.getMarks()));

	
		
//        
//        System.out.println("========================printing all objects in the list=====================");
//        
//        System.out.println(hm);
	
	System.out.println("----replace -------");
	
	System.out.println(hm.replace(1,new Student(120,"K.nikhil",600)));
	System.out.println(hm.get(1));
	tx.commit();
		se.close();	
		

		
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
