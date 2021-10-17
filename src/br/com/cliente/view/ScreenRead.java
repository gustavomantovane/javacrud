package br.com.cliente.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.cliente.dao.ClienteDAO;
import br.com.cliente.model.Cliente;

public class ScreenRead extends JFrame {

	ImageIcon img;
	JLabel lblNome;
	JTextField txtNome;
	JTable tabela;
	JScrollPane barraRolagem;
	DefaultTableModel modelo = new DefaultTableModel();
	JButton btnSearch;
	JButton btnBack;

	public ScreenRead() {

		criaJTable();

		setTitle("JavaCRUD");
		setLayout(null);
		setResizable(false);
		setSize(430, 420);
		img = new ImageIcon(getClass().getResource("logo.png"));
		setIconImage(img.getImage());

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 10, 200, 20);
		add(lblNome);

		txtNome = new JTextField(250);
		txtNome.setBounds(220, 10, 200, 20);
		add(txtNome);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 40, 400, 290);
		add(barraRolagem);

		btnSearch = new JButton("Pesquisar");
		btnSearch.setBounds(10, 340, 200, 30);
		btnSearch.addActionListener(read);
		add(btnSearch);

		btnBack = new JButton("Voltar");
		btnBack.setBounds(220, 340, 200, 30);
		btnBack.addActionListener(back);
		add(btnBack);

		setVisible(true);

	}

	private void criaJTable() {

		tabela = new JTable(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Sexo");
		modelo.addColumn("Email");
		modelo.addColumn("Telefone");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
		pesquisar(modelo);

	}

	public static void pesquisar(DefaultTableModel modelo) {

		modelo.setRowCount(0);

		ClienteDAO dao = new ClienteDAO();

		for (Cliente c : dao.read()) {

			modelo.addRow(new Object[]{

					c.getID(),
					c.getNome(),
					c.getSexo(),
					c.getEmail(),
					c.getTelefone()

			});

		}
	}

	ActionListener read = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			modelo.setRowCount(0);

			ClienteDAO dao = new ClienteDAO();

			for (Cliente c : dao.read(txtNome.getText())){

				modelo.addRow(new Object[]{

						c.getID(),
						c.getNome(),
						c.getSexo(),
						c.getEmail(),
						c.getTelefone()

				});

			};

		}

	};

	ActionListener back = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new ScreenCRUD();

		}

	};


	public static void main(String[] args) {

		new ScreenRead();

	}

}
