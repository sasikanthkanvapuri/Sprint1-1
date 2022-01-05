package com.example.MiniProject;

import static org.assertj.core.api.Assertions.assertThat;
/*import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MiniProject.dao.AccountsRepository;
import com.example.MiniProject.dao.CustomerRepository;
import com.example.MiniProject.dao.LoggerRepository;
import com.example.MiniProject.model.Accounts;
import com.example.MiniProject.model.Customer;
import com.example.MiniProject.model.Logger;

@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class Sprint11ApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */

	@Autowired
	AccountsRepository aRepo;

	@Autowired
	CustomerRepository cRepo;

	@Autowired
	LoggerRepository lRepo;

	@Test
	// @Order(1)
	public void testCreate() {
		Accounts a = new Accounts();
		a.setAcctID(1);
		a.setBalance(2000);
		a.setAcctStatus("Active");
		aRepo.save(a);
		assertNotNull(aRepo.findById(1).get());
	}

	@Test
	// @Order(2)
	public void testReadAll() {
		List<Accounts> list = aRepo.findAll();

		assertThat(list).size().isGreaterThan(0);
		// assertThat(list.size()).isGreaterThan(0);
	}

	@Test
	// @Order(3)
	public void testSingleAccount() {

		Accounts a = new Accounts();
		a.setAcctID(1);
		a.setBalance(2000);
		a.setAcctStatus("Active");
		aRepo.save(a);

		Accounts account = aRepo.findById(1).get();
		assertEquals(2000, account.getBalance());
	}

	@Test
	// @Order(4)
	public void testUpdate() {

		Accounts a = new Accounts();
		a.setAcctID(1);
		a.setBalance(2000);
		a.setAcctStatus("Active");
		aRepo.save(a);

		Accounts account = aRepo.findById(1).get();
		account.setBalance(3000);
		aRepo.save(account);
		assertEquals(3000, aRepo.findById(1).get().getBalance());

	}

	@Test
	// @Order(5)
	public void testDelete() {
		aRepo.deleteById(1);
		assertThat(aRepo.existsById(1)).isFalse();
	}

	@Test
	// @Order(6)
	public void testCreate1() {
		Customer c = new Customer();
		c.setAcctID(1);
		c.setCity("LA");
		c.setCountry("America");
		c.setCustName("Michael");
		c.setPassword("michael");
		c.setPhoneNo(12345);
		c.setState("NY");
		cRepo.save(c);
		assertNotNull(cRepo.findById(1).get());
	}

	@Test
	// @Order(7)
	public void testReadAll1() {
		Iterable<Customer> list = cRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	// @Order(8)
	public void testUpdate1() {

		Customer c = new Customer();
		c.setAcctID(1);
		c.setCity("LA");
		c.setCountry("America");
		c.setCustName("Michael");
		c.setPassword("michael");
		c.setPhoneNo(12345);
		c.setState("NY");
		cRepo.save(c);

		Customer customer = cRepo.findById(1).get();
		customer.setPhoneNo(45678);
		customer.setCountry("ÏNDIA");
		cRepo.save(customer);
		assertEquals(45678, cRepo.findById(1).get().getPhoneNo());
	}

	@Test
	// @Order(9)
	public void testDelete1() {
		cRepo.deleteById(1);
		assertThat(cRepo.existsById(1)).isFalse();
	}

	@Test
	// @Order(10)
	public void testCreate2() {
		Logger l = new Logger();
		l.setAcctID(1);
		l.setInitBal(1000);
		l.setFinalBal(2000);
		l.setTransacStatus("success");
		l.setTransacType("transferred/received");
		lRepo.save(l);
		assertNotNull(lRepo.findById(1).get());
	}

	@Test
	// @Order(11)
	public void testReadAll2() {
		Iterable<Logger> list = lRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	// @Order(12)
	public void testUpdate2() {

		Logger l = new Logger();
		l.setAcctID(1);
		l.setInitBal(1000);
		l.setFinalBal(2000);
		l.setTransacStatus("success");
		l.setTransacType("transferred/received");
		lRepo.save(l);

		Logger logger = lRepo.findById(1).get();
		logger.setFinalBal(3000);
		lRepo.save(logger);
		assertEquals(3000, lRepo.findById(1).get().getFinalBal());
	}

	@Test
	// @Order(13)
	public void testDelete2() {
		lRepo.deleteById(1);
		assertThat(lRepo.existsById(1)).isFalse();
		
	}

}

//Test commit
