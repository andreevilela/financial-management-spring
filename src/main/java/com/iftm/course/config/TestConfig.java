package com.iftm.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.course.entities.Category;
import com.iftm.course.entities.CategoryOut;
import com.iftm.course.entities.Input;
import com.iftm.course.entities.Output;
import com.iftm.course.entities.User;
import com.iftm.course.repositories.CategoryOutRepository;
import com.iftm.course.repositories.CategoryRepository;
import com.iftm.course.repositories.InputRepository;
import com.iftm.course.repositories.OutputRepository;
import com.iftm.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryOutRepository categoryOutRepository;
	
	@Autowired
	private InputRepository inputRepository;
	
	@Autowired
	private OutputRepository outputRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Administrador", java.sql.Date.valueOf("2000-02-01"), "iftmandre@gmail.com", "123456");
		
		userRepository.saveAll(Arrays.asList(u1));
		
		Category cat1 = new Category(null , "Aluguel" );
		Category cat2 = new Category(null , "Bônus" );
		Category cat3 = new Category(null , "Empréstimo" );
		Category cat4 = new Category(null , "Outras rendas" );
		Category cat5 = new Category(null , "Salário" );
		Category cat6 = new Category(null , "Rendimento" );
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		
		CategoryOut catOut1 = new CategoryOut(null , "Bares / restaurantes" );
		CategoryOut catOut2 = new CategoryOut(null , "Compras" );
		CategoryOut catOut3 = new CategoryOut(null , "Contas residenciais" );
		CategoryOut catOut4 = new CategoryOut(null , "Educação" );
		CategoryOut catOut5 = new CategoryOut(null , "Lazer" );
		CategoryOut catOut6 = new CategoryOut(null , "Mercado" );
		CategoryOut catOut7 = new CategoryOut(null , "Moradia" );
		CategoryOut catOut8 = new CategoryOut(null , "Presentes" );
		CategoryOut catOut9 = new CategoryOut(null , "Saúde" );
		CategoryOut catOut10 = new CategoryOut(null , "Serviços" );
		CategoryOut catOut11 = new CategoryOut(null , "Taxas bancarias" );
		CategoryOut catOut12 = new CategoryOut(null , "Transporte" );
		CategoryOut catOut13 = new CategoryOut(null , "TV / Internet / Telefones" );
		CategoryOut catOut14 = new CategoryOut(null , "Viagem" );
		
		categoryOutRepository.saveAll(Arrays.asList(catOut1, catOut2, catOut3, catOut4, catOut5, catOut6, catOut7, catOut8, catOut9, catOut10, catOut11, catOut12, catOut13, catOut14));
		
		Input in1 = new Input(null, "Apartamento", java.sql.Date.valueOf("2020-10-01"), 800.00, u1, cat1);
		Input in2 = new Input(null, "Salário Trabalho", java.sql.Date.valueOf("2020-10-10"), 1700.00, u1, cat5);
		
		inputRepository.saveAll(Arrays.asList(in1, in2));
		
		Output out1 = new Output(null, "Almoço com Bia", java.sql.Date.valueOf("2020-10-24"), 20.90, u1, catOut1);
		Output out2 = new Output(null, "Compras da semana", java.sql.Date.valueOf("2020-10-17"), 120.53, u1, catOut6);
		Output out3 = new Output(null, "Troca de óleo carro", java.sql.Date.valueOf("2020-10-15"), 60.00, u1, catOut10);
		Output out4 = new Output(null, "Combustível da semana", java.sql.Date.valueOf("2020-10-10"), 50.00, u1, catOut12);
		
		outputRepository.saveAll(Arrays.asList(out1, out2, out3, out4));
		
		
	}

}
