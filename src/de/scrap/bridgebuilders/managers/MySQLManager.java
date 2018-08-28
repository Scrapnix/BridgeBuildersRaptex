package de.scrap.bridgebuilders.managers;

import java.sql.Connection;    
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;

import de.orochimaruu.bridgebuilders.Main;
import lombok.Data;

@Data
public class MySQLManager {

	private ExecutorService executor;
	
	private Plugin plugin;
	
	private MySQL sql;
	
	private Connection connection;

	public MySQLManager(Plugin plugin, String host, int port, String user, String password, String database) {
		try {
			sql = new MySQL(host, port, user, password, database);
			executor = Executors.newCachedThreadPool();
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    	Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cEin Fehler während des Verbindens mit MYSQL ist aufgetreten!");
	    	System.out.println("plug " + plugin + "; host " + host + "; port " + port + "; user" + user + "; password " + password + "; database " + database);
	    }
		
		this.plugin = plugin;
	
	}
	   
	public void update(PreparedStatement statement) {
		executor.execute(() -> sql.queryUpdate(statement));
	}
	
	public void update(String statement) {
		executor.execute(() -> sql.queryUpdate(statement));
	}
	   
	public void query(PreparedStatement statement, Consumer<ResultSet> consumer) {
		executor.execute(() -> {
			ResultSet result = sql.query(statement);
			Bukkit.getScheduler().runTask(plugin, () -> consumer.accept(result));
		}
		);
	}
	   
	public void query(String statement, Consumer<ResultSet> consumer) {
		executor.execute(() -> {
			ResultSet result = sql.query(statement);
			Bukkit.getScheduler().runTask(plugin, () -> consumer.accept(result));
		});
	}
	   
	public PreparedStatement prepare(String query) {
		try {
			return sql.getConnection().prepareStatement(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	   
	public MySQL getMySQL() {
		return sql;
	}
	
	public Connection getConnection() {
		executor.execute(() -> connection = sql.getConnection());
		return connection;
	}
	
	public void closeConnection() {
		executor.execute(() -> sql.closeConnection());
	}
	   
	public static class MySQL {
	      
		private String host, user, password, database;
		private int port;
	      
		private Connection conn;
	      
		public MySQL(String host, int port, String user, String password, String database) throws Exception {
			this.host = host;
			this.port = port;
			this.user = user;
	        this.password = password;
	        this.database = database;
	         
	        this.openConnection();
		}
	      
		public void queryUpdate(String query) {
			checkConnection();
			try (PreparedStatement statement = conn.prepareStatement(query)) {
				queryUpdate(statement);
	        } catch (Exception e) {
	        	e.printStackTrace();
	       		Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDie angegebene Database existiert nicht oder die Verbindung ist abgebrochen!");
	        }
	     }
	      
	    public void queryUpdate(PreparedStatement statement) {
	        checkConnection();
	        try {
	        	statement.executeUpdate();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDie angegebene Database existiert nicht oder die Verbindung ist abgebrochen!");
	        } finally {
	           try {
	        	   statement.close();
	           } catch (Exception e) {
	        	   e.printStackTrace();
	           }
	        }
	    }
	      
	    public ResultSet query(String query) {
	        checkConnection();
	        try {
	           return query(conn.prepareStatement(query));
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return null;
	    }
	      
	    public ResultSet query(PreparedStatement statement) {
	        checkConnection();
	        try {
	           return statement.executeQuery();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return null;
	    }
	      
	    public Connection getConnection() {
	        return this.conn;
	    }
	      
	    private void checkConnection() {
	    	try {
	           if (this.conn == null || !this.conn.isValid(10) || this.conn.isClosed()) openConnection();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	    }
	      
	    public Connection openConnection() throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        try {
	        	return this.conn = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?user=" + this.user + "&password=" + this.password + "&autoReconnect=true");
			} catch (MySQLNonTransientConnectionException e) {
				System.out.println(this.database);
				e.printStackTrace();
				return null;
			}	    
	    }
	      
	    public void closeConnection() {
	       try {
	          this.conn.close();
	       } catch (SQLException e) {
	          e.printStackTrace();
	       } finally {
	          this.conn = null;
	       }
	    }
	}
	
}
