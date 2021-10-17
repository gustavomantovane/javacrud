package br.com.cliente.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.cliente.dao.ClienteDAO;
import br.com.cliente.model.Cliente;

public class ScreenUpdate_2 extends JFrame {

	ImageIcon img;
	JLabel lblNome;
	JTextField txtNome;
	JLabel lblSexo;
	String sexos[] = {"M", "F", "Outros"};
	JComboBox cboSexo;
	JLabel lblDataNascimento;
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	GregorianCalendar calendar = new GregorianCalendar();
	int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
	int mes = calendar.get(GregorianCalendar.MONTH);
	int ano = calendar.get(GregorianCalendar.YEAR);
	JFormattedTextField txtDataNascimento;
	JLabel lblRG;
	JTextField txtRG;
	JLabel lblCPF;
	JTextField txtCPF;
	JLabel lblEmail;
	JTextField txtEmail;
	JLabel lblTelefone;
	JTextField txtTelefone;
	JLabel lblEndereco;
	JTextField txtEndereco;
	JLabel lblBairro;
	JTextField txtBairro;
	JLabel lblMunicipio;
	JTextField txtMunicipio;
	JLabel lblUF;
	String UF[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	JComboBox cboUF;
	JButton btnUpdate;
	JButton btnBack;
	Cliente c;

	public ScreenUpdate_2(Cliente c) {

		this.c = c; 
		
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
		txtNome.setText(c.getNome());
		txtNome.setBounds(220, 10, 200, 20);
		add(txtNome);

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 40, 200, 20);
		add(lblSexo);

		cboSexo = new JComboBox(sexos);
		cboSexo.setSelectedItem(c.getSexo());
		cboSexo.setBounds(220, 40, 200, 20);
		add(cboSexo);

		lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(10, 70, 200, 20);
		add(lblDataNascimento);

		txtDataNascimento = new JFormattedTextField(format);
		txtDataNascimento.setText((String) format.format(c.getDataNascimento()));
		txtDataNascimento.setBounds(220, 70, 200, 20);
		add(txtDataNascimento);

		lblRG = new JLabel("RG");
		lblRG.setBounds(10, 100, 200, 20);
		add(lblRG);

		txtRG = new JTextField(9);
		txtRG.setText(c.getRG());
		txtRG.setBounds(220, 100, 200, 20);
		add(txtRG);

		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 130, 200, 20);
		add(lblCPF);

		txtCPF = new JTextField(11);
		txtCPF.setText(c.getCPF());
		txtCPF.setBounds(220, 130, 200, 20);
		add(txtCPF);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 160, 200, 20);
		add(lblEmail);

		txtEmail = new JTextField(250);
		txtEmail.setText(c.getEmail());
		txtEmail.setBounds(220, 160, 200, 20);
		add(txtEmail);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 190, 200, 20);
		add(lblTelefone);

		txtTelefone = new JTextField(11);
		txtTelefone.setText(c.getTelefone());
		txtTelefone.setBounds(220, 190, 200, 20);
		add(txtTelefone);

		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 220, 200, 20);
		add(lblEndereco);

		txtEndereco = new JTextField(250);
		txtEndereco.setText(c.getEndereco());
		txtEndereco.setBounds(220, 220, 200, 20);
		add(txtEndereco);

		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 250, 200, 20);
		add(lblBairro);

		txtBairro = new JTextField(250);
		txtBairro.setText(c.getBairro());
		txtBairro.setBounds(220, 250, 200, 20);
		add(txtBairro);

		lblMunicipio = new JLabel("Munícipio");
		lblMunicipio.setBounds(10, 280, 200, 20);
		add(lblMunicipio);

		txtMunicipio = new JTextField(50);
		txtMunicipio.setText(c.getMunicipio());
		txtMunicipio.setBounds(220, 280, 200, 20);
		add(txtMunicipio);

		lblUF = new JLabel("UF");
		lblUF.setBounds(10, 310, 200, 20);
		add(lblUF);

		cboUF = new JComboBox(UF);
		cboUF.setSelectedItem(c.getUF());
		cboUF.setBounds(220, 310, 200, 20);
		add(cboUF);

		btnUpdate = new JButton("Alterar");
		btnUpdate.setBounds(10, 340, 200, 30);
		btnUpdate.addActionListener(create);
		add(btnUpdate);

		btnBack = new JButton("Voltar");
		btnBack.setBounds(220, 340, 200, 30);
		btnBack.addActionListener(back);
		add(btnBack);

		setVisible(true);

	}

	ActionListener create = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			Date dataNascimento = null;

			try {

				dataNascimento = (Date)format.parse(txtDataNascimento.getText());

			} catch (ParseException el) {

				el.printStackTrace();

			}

			String erros = "";

			if (txtNome.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Nome \n";

			}

			if (txtDataNascimento.getText().equalsIgnoreCase("")){

				erros += "Preencha o campo Data de Nascimento \n";

			}

			if (txtRG.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo RG \n";

			}

			if (txtCPF.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo CPF \n";

			}

			if (txtEmail.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Email \n";

			}

			if (txtTelefone.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Telefone \n";

			}

			if (txtEndereco.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Endereco \n";

			}

			if (txtBairro.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Bairro \n";

			}

			if (txtBairro.getText().equalsIgnoreCase("")) {

				erros += "Preencha o campo Município";

			}

			if(erros.equalsIgnoreCase("")) {

				c.setNome(txtNome.getText());
				c.setSexo(cboSexo.getSelectedItem().toString());
				c.setDataNascimento(dataNascimento);
				c.setRG(txtRG.getText());
				c.setCPF(txtCPF.getText());
				c.setEmail(txtEmail.getText());
				c.setTelefone(txtTelefone.getText());
				c.setEndereco(txtEndereco.getText());
				c.setBairro(txtBairro.getText());
				c.setMunicipio(txtMunicipio.getText());
				c.setUF(cboUF.getSelectedItem().toString());

				ClienteDAO cDAO = new ClienteDAO();
				cDAO.update(c);

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



	}

}
