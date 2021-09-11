package com.account.driver;

import com.account.dao.LaptopDao;
import com.account.dao.LaptopDaoImpl;
import com.account.dto.Laptop;
import com.account.service.LaptopService;
import com.account.service.LaptopServiceImpl;

public class LaptopDriverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laptop laptopRec =new Laptop();
		laptopRec.setLapSpecification("Linux Intel core i5 8Gb");
		laptopRec.setLapType("LG");
		LaptopDao dao=new LaptopDaoImpl();
		LaptopService ls=new LaptopServiceImpl(dao);
		ls.addLaptop(laptopRec);
		laptopRec=new Laptop();
		laptopRec.setLapSpecification("HP Intel Core i8 16GB");
		laptopRec.setLapType("LG");
		ls.addLaptop(laptopRec);
		System.out.println("**********Listing The Laptop***************");
		System.out.println("Get All books :"+ls.getAllLaptop());
		System.out.println("**********Listing Total number of Laptop***************");
		System.out.println("Total laptop:"+ls.getLaptopCount());
		System.out.println("**********Listing LG Laptops***************");
		System.out.println("Get laptop by Type: "+ls.getLaptopByType("LG"));
		System.out.println("**********Get laptop Specififcation***************");
		System.out.println("Get laptop By spec: "+ls.getLaptopBySpecification("HP Intel Core i8 16GB"));
		System.out.println("**********Laptop Number 1***************");
		System.out.println("Get book by Id: "+ls.getLaptopById(1));

		
		
	}

}
