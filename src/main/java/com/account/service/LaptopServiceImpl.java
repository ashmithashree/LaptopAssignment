package com.account.service;

import java.util.List;

import com.account.TypeNotFoundException;
import com.account.dao.LaptopDao;
import com.account.dao.LaptopDaoImpl;
import com.account.dto.Laptop;

public class LaptopServiceImpl implements LaptopService {
	public LaptopDao dao;
	public LaptopServiceImpl(LaptopDao dao) {
		this.dao=dao;
	}
	@Override
	public void addLaptop(Laptop laptop) {
		try {
			String []str= {"LG","DELL","HP","SONY"};
			boolean count=false;
			for(int i=0;i<str.length;i++)
			{
				
				if(laptop.getLapType().equals(str[i].toUpperCase()))
				{
					count=true;
				}
			}
			if(count==false)
			{
				throw new TypeNotFoundException("Type is not available");
			}
			else
			{
				dao.beginTransation();
				dao.addLaptop(laptop);
				dao.commitTransation();
			}
		}catch(TypeNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public long getLaptopCount() {
		return dao.getLaptopCount();
	}
	@Override
	public List<Laptop> getAllLaptop(){
		return dao.getAllLaptop();
	}
	@Override
	public Laptop getLaptopById(int id) {
		return dao.getLaptopById(id);
	}
	@Override
	public List<Laptop> getLaptopBySpecification(String Spec){
		return dao.getLaptopBySpecification(Spec);
	}
	@Override
	public List<Laptop> getLaptopByType(String Type){
		return dao.getLaptopByType(Type);
	}
}
