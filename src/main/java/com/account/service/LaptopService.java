package com.account.service;

import java.util.List;

import com.account.dto.Laptop;

public interface LaptopService {
	public void addLaptop(Laptop laptop);
	public abstract long getLaptopCount();
	public abstract List<Laptop> getAllLaptop();
	public abstract Laptop getLaptopById(int id);
	public abstract List<Laptop> getLaptopBySpecification(String Spec);
	public abstract List<Laptop> getLaptopByType(String Type);
}
