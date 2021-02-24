package bean;

import dao.ClientesDB;

public class TestaCliente {
	
	public static void main(String[] args) {
		Cliente c = new Cliente("99999999999","Fulano de Tal","99999999999");
		ClientesDB cdb=new ClientesDB();
		cdb.addCliente(c);
	}

}
