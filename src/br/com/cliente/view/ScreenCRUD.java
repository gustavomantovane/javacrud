package br.com.cliente.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ScreenCRUD extends JFrame {

	ImageIcon img;
	JButton btnScreenCreate;
	JButton btnScreenRead;
	JButton btnScreenUpdate;
	JButton btnScreenDelete;

	public ScreenCRUD() {

		setTitle("JavaCRUD");
		setLayout(null);
		setResizable(false);
		setSize(430, 130);
		img = new ImageIcon(getClass().getResource("logo.png"));
		setIconImage(img.getImage());
		setVisible(true);

		btnScreenCreate = new JButton("Criar");
		btnScreenCreate.setBounds(10, 10, 200, 30);
		btnScreenCreate.addActionListener(screenCreate);
		add(btnScreenCreate);

		btnScreenRead = new JButton("Ler");
		btnScreenRead.setBounds(220, 10, 200, 30);
		btnScreenRead.addActionListener(screenRead);
		add(btnScreenRead);

		btnScreenUpdate = new JButton("Atualizar");
		btnScreenUpdate.setBounds(10, 50, 200, 30);
		btnScreenUpdate.addActionListener(screenUpdate);
		add(btnScreenUpdate);

		btnScreenDelete = new JButton("Deletar");
		btnScreenDelete.setBounds(220, 50, 200, 30);
		btnScreenDelete.addActionListener(screenDelete);
		add(btnScreenDelete);

	}

	ActionListener screenCreate = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new ScreenCreate();

		}

	};

	ActionListener screenRead = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new ScreenRead();

		}

	};
	
	ActionListener screenUpdate = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new ScreenUpdate();

		}

	};

	ActionListener screenDelete = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new ScreenDelete();

		}

	};

	public static void main(String args[]) {

		new ScreenCRUD();

	}

}
