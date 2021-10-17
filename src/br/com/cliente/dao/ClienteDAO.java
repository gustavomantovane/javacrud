package br.com.cliente.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.cliente.factory.ConnectionFactory;
import br.com.cliente.model.Cliente;

public class ClienteDAO {

	/*
	 * CRUD
	 * c: CREATE
	 * r: READ
	 * u: UPDATE
	 * d: DELETE
	 */

	public void create(Cliente cliente) {

		String sql = "INSERT INTO cliente (id, nome, sexo, dataNascimento, RG, CPF, email, telefone, endereco, bairro, municipio, UF) VALUES (DEFAULT, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?);";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySql();

			//Criamos uma PreparedStatement, para executar uma query
			pstm = conn.prepareStatement(sql);

			//Adicionar os valores que são esperados pela query
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getSexo());
			pstm.setDate(3, new Date(cliente.getDataNascimento().getTime()));
			pstm.setString(4,  cliente.getRG());
			pstm.setString(5, cliente.getCPF());
			pstm.setString(6, cliente.getEmail());
			pstm.setString(7, cliente.getTelefone());
			pstm.setString(8, cliente.getEndereco());
			pstm.setString(9, cliente.getBairro());
			pstm.setString(10, cliente.getMunicipio());
			pstm.setString(11, cliente.getUF());

			//Executar a query
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			//Fechar as conexões

			try {

				if(pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

	public ArrayList<Cliente> read() {

		String sql = "SELECT * FROM cliente;";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;

		try {
			
			conn = ConnectionFactory.createConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			if(rs != null) {

				clientes = new ArrayList<Cliente>();

				while (rs.next()) {

					Cliente cliente = new  Cliente();

					cliente.setID(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setSexo(rs.getString("sexo"));
					cliente.setDataNascimento(rs.getDate("dataNascimento"));
					cliente.setRG(rs.getString("RG"));
					cliente.setCPF(rs.getString("CPF"));
					cliente.setEmail(rs.getString("email"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setBairro(rs.getString("bairro"));
					cliente.setMunicipio(rs.getString("municipio"));
					cliente.setUF(rs.getString("UF"));

					clientes.add(cliente);

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return clientes;

	}

	public ArrayList<Cliente> read(String nome) {



		String sql = "SELECT * FROM cliente where nome like ?;";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {
			
			conn = ConnectionFactory.createConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, "%" + nome + "%");

			rs = pstm.executeQuery();

			while (rs.next()) {

				Cliente cliente = new  Cliente();

				cliente.setID(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDataNascimento(rs.getDate("dataNascimento"));
				cliente.setRG(rs.getString("RG"));
				cliente.setCPF(rs.getString("CPF"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setMunicipio(rs.getString("municipio"));
				cliente.setUF(rs.getString("UF"));

				clientes.add(cliente);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return clientes;

	}
	
	public boolean update_verificar(Cliente c) {
		
		String sql = "SELECT * FROM cliente where id = ? and nome = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			
			conn = ConnectionFactory.createConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, c.getID());
			pstm.setString(2, c.getNome());

			rs = pstm.executeQuery();
			
			if (rs != null && rs.next()) {
				
				c.setSexo(rs.getString("sexo"));
				c.setDataNascimento(rs.getDate("dataNascimento"));
				c.setRG(rs.getString("RG"));
				c.setCPF(rs.getString("CPF"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setBairro(rs.getString("bairro"));
				c.setMunicipio(rs.getString("municipio"));
				c.setUF(rs.getString("UF"));
				
				return true;
				
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
		
		return false;
		
	}
	
	public void update(Cliente c)  {
		
		String sql = "UPDATE cliente set nome = ? , sexo = ? , dataNascimento = ? , RG = ? , CPF = ? , email = ? , telefone = ? , endereco = ? , bairro = ? , municipio = ? , UF = ? where id = ? ;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			conn = ConnectionFactory.createConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getSexo());
			pstm.setDate(3, new Date(c.getDataNascimento().getTime()));
			pstm.setString(4, c.getRG());
			pstm.setString(5, c.getCPF());
			pstm.setString(6, c.getEmail());
			pstm.setString(7, c.getTelefone());
			pstm.setString(8, c.getEndereco());
			pstm.setString(9, c.getBairro());
			pstm.setString(10, c.getMunicipio());
			pstm.setString(11, c.getUF());
			pstm.setInt(12, c.getID());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
		
	}

	public void delete(Cliente cliente) {

		String sql = "DELETE FROM cliente where nome = ? and ID = ?;";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			conn = ConnectionFactory.createConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setInt(2,  cliente.getID());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

}
