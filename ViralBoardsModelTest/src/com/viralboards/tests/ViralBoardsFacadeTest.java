package com.viralboards.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.viralboards.dao.impl.ViralBoardsDAOImpl;
import com.viralboards.model.Account;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;

public class ViralBoardsFacadeTest {
	ViralBoardsFacade facade;

	@Before
	public void setUp() throws Exception {
        facade = new ViralBoardsFacadeImpl();
        ((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsDAOImpl.getViralBoardsDAO());
        
	}

	@Test
	public void testCreateAccount() {
		//fail("Not yet implemented");
		Account ac1 = new Account();
        ac1.setUserName("Random");
        assertTrue(facade.createAccount(ac1));

	}

	@Test
	public void testDoesAccountExist() {
		//fail("Not yet implemented");
		assertTrue(facade.doesAccountExist("Rooney"));
	}

}
