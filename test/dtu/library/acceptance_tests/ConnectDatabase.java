package dtu.library.acceptance_tests;

import cucumber.api.java.Before;
import dtu.library.app.LibraryApp;
import dtu.library.persistence.InMemoryRepository;
import dtu.library.persistence.SqliteRepository;

public class ConnectDatabase {
	LibraryApp libraryApp;
	
	public ConnectDatabase(LibraryApp libraryApp) {
		this.libraryApp = libraryApp;
	}
	
	@Before
	public void connectDatabase() {
//		SqliteRepository repo = new SqliteRepository();
		InMemoryRepository repo = new InMemoryRepository();
		libraryApp.setRepositories(repo,repo);
		libraryApp.clearDatabase();
		
	}
}
