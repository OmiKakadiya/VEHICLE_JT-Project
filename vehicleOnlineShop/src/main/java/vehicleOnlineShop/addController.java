package vehicleOnlineShop;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class addController {
    
	@RequestMapping("/adduser")
	public ModelAndView adduser(@RequestParam("username") String uname, @RequestParam("phoneno") int phoneno, 
			@RequestParam("password") String password, @RequestParam("cpassword") String cpassword) {
		ModelAndView mv = new ModelAndView();

		if(password.equals(cpassword)) {
			
			Customer c = new Customer();
			c.setName(uname);
			c.setPassword(cpassword);
			c.setPhone_no(phoneno);
//			c.setAddress("abc");
//			c.setRoll_id(2);
//			c.setGender("Female");
			
			Configuration con = new Configuration().configure().addAnnotatedClass(Customer.class);
			SessionFactory sf = con.buildSessionFactory();
			org.hibernate.Session session = sf.openSession();
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(c);
			tx.commit();
			
			String Msg=  "You Registered Successfully.";
			mv.setViewName("index.jsp");
			mv.addObject("Msg", Msg);
		}
		else {
			
			String Msg=  "Password and Confirm Password Are Not Same!!";
			mv.setViewName("Registration.jsp");
			mv.addObject("Msg", Msg );
			
		}
		
		
		
		return mv;
	}
	

	
	@RequestMapping("/verifyUser")
	public ModelAndView verifyUser(@RequestParam("username") String uname,@RequestParam("password") String password ) {
		
		ModelAndView mv = new ModelAndView();	
		int flag=0;
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class);			
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			org.hibernate.Session session = factory.openSession();
			
			
			String name = null;
			Customer c = new Customer();
			int rid = 0 , id = 0;
			java.util.List li = session.createQuery("from Customer where name='" + uname + "' and password='" + password + "'" ).list();
			java.util.Iterator it=li.iterator();
			while(it.hasNext()) {
				Object o = (Object)it.next();
				Customer r = (Customer)o;
			     name = r.getName();
			     rid = r.getRoll_id();
			     id = r.getId();
			     c = r ;
				 System.out.println(r.getId());
				flag++;
			}
			session.close();
			factory.close();
			if(flag==1)
			{
				mv.setViewName("home.jsp");
				mv.addObject("Username",name);
				mv.addObject("rollid",rid);
							}
			else {
				String msg = "Email Or Password Incorrect!";
				mv.setViewName("index.jsp");
				mv.addObject("Msg",msg);
				
			}
							
		}
		catch(Exception ex) {
			System.out.println(ex);	
		}
		return mv;
		
	}
	
	
	@RequestMapping("editData")
	public ModelAndView editData(@RequestParam("un") String un, @RequestParam("pn") int phoneno,
			@RequestParam("g") String g , @RequestParam("address") String address ) {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		return mv ;
	}
	
}
 