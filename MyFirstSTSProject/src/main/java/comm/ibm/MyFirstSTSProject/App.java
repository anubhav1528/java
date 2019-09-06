package comm.ibm.MyFirstSTSProject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
try {
        	
        	ClassPathXmlApplicationContext context=new 
        			ClassPathXmlApplicationContext("appplication_context.xml");
//        	baseballCoach myCoach=context.getBean("theCoach",baseballCoach.class);
//        	myCoach.getDailyRouting();
//        	System.out.println(myCoach.getName()+" "+myCoach.getteamName());
//        	System.out.println(myCoach.getFortuneForToday());
//        	coach myCoach1=context.getBean("theCoachs",cricketCoach.class);
//        	myCoach1.getDailyRouting();
//        	ClassPathXmlApplicationContext contextt=new 
//        			ClassPathXmlApplicationContext("appplication_context.xml");
//        	employeeClass obj =contextt.getBean("theCoachss",employeeClass.class);
//        	System.out.println(obj.getEmpDetails());
//        	context.close();
//			contextt.close();
        	employeeDao dao=context.getBean("eDao",employeeDao.class);
            dao.createEmployee(new employeeClass(2,"SACHINN"));
            ClassPathXmlApplicationContext contextt=new 
        			ClassPathXmlApplicationContext("applicationContext.xml");
            employeeDao daoo=contextt.getBean("eDao",employeeDao.class);
            daoo.createeEmployee(new employeeClass(3,"SACHINNN"));
            daoo.updateEmployee(3,"anubhav");
            daoo.deleteEmployee(2);
            daoo.getAllEmpployee();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
