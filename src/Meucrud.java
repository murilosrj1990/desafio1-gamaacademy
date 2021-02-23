import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Meucrud {
	
	public static void main(String[] args) {
		/**
		 * O driver do JDBC do MySQL está no seguinte endereço:
		 * https://dev.mysql.com/downloads/connector/j/5.0.html
		 */
		String sql;
		
		//Configuração dos parâmetros de 
		String server = "localhost";
		String port = "3306";
		String database = "teste?useTimezone=true&serverTimezone=UTC";
		
		//Configuração de parâmetros de conexão
		String user = "root";
		String password = "toor";
		
		try {			
			String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
			
			//Abre-se conexão com banco de dados
			Connection con = DriverManager.getConnection( url , user , password);
			
			//Cria-se Stateman com base na conexão con
			Statement stmt = con.createStatement();
			
			//Exemplo cria-se uma tabela no banco de dados teste
			sql = "INSERT INTO `tabela1` (descricao)"
					+ "VALUES ('teste111')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO `tabela1` (descricao)"
					+ "VALUES ('teste222')";
			stmt.executeUpdate(sql);
			
			sql = "SELECT `id` , `descricao` FROM tabela1";
			ResultSet  res = stmt.executeQuery(sql);
			
			while(res.next()) {
				int idCliente = res.getInt("id");
				String descricao = res.getString("descricao");
				System.out.println("Linha = " + idCliente + " - " + descricao);
				
				
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
