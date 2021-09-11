package com.account;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.account.dao.LaptopDao;
import com.account.dao.LaptopDaoImpl;
import com.account.driver.JPAUtil;
import com.account.dto.Laptop;
import com.account.service.LaptopService;
import com.account.service.LaptopServiceImpl;



class TestLaptopService {
static LaptopService laptopService=null;
static LaptopDao mockLaptopDao=null;
private static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mockLaptopDao =Mockito.mock(LaptopDao.class);
		laptopService=new LaptopServiceImpl(mockLaptopDao);
		em=JPAUtil.getEntityManager();		
	}

	@Test
	void test() {
		List<Laptop> allEmployee=laptopService.getAllLaptop();
		assertNotNull(allEmployee);
	
	}
	@Test
	void testNegative()
	{
		List<Laptop> allEmployee=laptopService.getAllLaptop();
		assertNotEquals(9, allEmployee.size());
	}
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@Test
	void textException() {
			exceptionRule.expect(TypeNotFoundException.class);
		    exceptionRule.expectMessage("Type is not available");
			Laptop ls=new Laptop();
			ls.setLapType("Apple");
			ls.setLapSpecification("IOS 4GB RAM");
			LaptopDaoImpl dao=new LaptopDaoImpl();
			LaptopService ls1=new LaptopServiceImpl(dao);
			ls1.addLaptop(ls);
			Mockito.when(mockLaptopDao.getAllLaptop()).thenReturn(Arrays.asList(ls));
		
	}


}
