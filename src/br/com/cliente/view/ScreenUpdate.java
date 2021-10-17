package br.com.cliente.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.cliente.dao.ClienteDAO;
import br.com.cliente.model.Cliente;

public class ScreenUpdate extends JFrame {

	ImageIcon img;
	JLabel lblNome;
	JTextField txtNome;
	JLabel lblID;
	JTextField txtID;
	JButton btnDelete;
	JButton btnBack;

	public ScreenUpdate() {

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

		lblID = new JLabel("ID");
		lblID.setBounds(10, 40, 200, 20);
		add(lblID);

		txtID = new JTextField(9);
		txtID.setBounds(220, 40, 200, 20);
		add(txtID);

		btnDelete = new JButton("Confirmar");
		btnDelete.setBounds(10, 340, 200, 30);
		btnDelete.addActionListener(delete);
		add(btnDelete);

		btnBack = new JButton("Voltar");
		btnBack.setBounds(220, 340, 200, 30);
		btnBack.addActionListener(back);
		add(btnBack);

		setVisible(true);

	}

	ActionListener delete = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			String erros = "";

			if (txtNome.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Nome \n";

			}

			if (txtID.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo ID \n";

			}

			if(erros.equalsIgnoreCase("")) {

				Cliente c = new Cliente();

				c.setNome(txtNome.getText());
				c.setID(Integer.parseInt(txtID.getText()));

				ClienteDAO cDAO = new ClienteDAO();
				
				if(cDAO.update_verificar(c)) {
					
					setVisible(false);
					
					new ScreenUpdate_2(c);
					
				}

			} else {

				JOptionPane.showMessageDialog(null, erros);

			}

		}

	};

	ActionListener back = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new ScreenCRUD();

		}

	};

	public static void main(String[] args) {

		new ScreenUpdate();

	}

}
