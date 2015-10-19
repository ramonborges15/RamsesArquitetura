package br.com.ufes.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.TextField;
import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;

import br.com.ufes.ramses.ArquiteturaRamses;
import br.com.ufes.ramses.Memoria;
import br.com.ufes.ramses.Multiplexador;
import br.com.ufes.ramses.Registrador;
import br.com.ufes.ramses.RegistradorEstados;
import br.com.ufes.ramses.RegistradorPC;
import br.com.ufes.ramses.ULA;

public class View{

	public JFrame frame;
	public JTextField textNomeDoArquivo;
	public JTextField textRA;
	public JTextField textRB;
	public JTextField textRX;
	public JTextField textPC;
	public JButton btnPasso;
	public JButton btnDireto;
	public JButton btnLoad;
	private JTable tabela;
	boolean iniciar;

	//
	public static void main(String[] args) {
		ArrayList<String> microinstrucoes = new ArrayList<String>();

		View window = new View();
		window.frame.setVisible(true);
		
		Registrador rdm = new Registrador();
		Registrador rem = new Registrador();
		Registrador ri = new Registrador();
		Registrador ra = new Registrador();
		Registrador rb = new Registrador();
		Registrador rx = new Registrador();
		Registrador raux = new Registrador();
		RegistradorEstados estados = new RegistradorEstados();
		RegistradorPC pc = new RegistradorPC();
		Multiplexador mux = new Multiplexador();
		ULA unidadeAritmetica = new ULA();
		Memoria mem = new Memoria(rdm, rem);
		ArquiteturaRamses ramses = new ArquiteturaRamses();
					
	}
	
	
	public View(/*microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica*/) {
		initialize();
		btnLoad();
		
	}
	
	/*
	public void btnResul(ArrayList<String> microinstrucoes, Registrador) {
		btnDireto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	ramses.carregarValor(microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica);
            	textPC.setText(Byte.toString(ra.getConteudo()));
        		textRA.setText(Byte.toString(rb.getConteudo()));
        		textRB.setText(Byte.toString(rx.getConteudo()));
        		textRX.setText(Byte.toString(pc.getConteudo()));
            }
		});
	}
	*/
	public void btnLoad() {
		btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(textNomeDoArquivo.getText());
            	//ramses.lerArquivo(microinstrucoes, textNomeDoArquivo.getText());
            }
		});
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnPasso = new JButton(">>");
		btnPasso.setBounds(257, 320, 54, 25);
		frame.getContentPane().add(btnPasso);
		
		btnDireto = new JButton("=");
		btnDireto.setBounds(358, 320, 54, 25);
		frame.getContentPane().add(btnDireto);
		
		btnLoad = new JButton("Load");
		btnLoad.setBounds(593, 25, 77, 25);
		frame.getContentPane().add(btnLoad);
		
		textNomeDoArquivo = new JTextField();
		textNomeDoArquivo.setBounds(301, 28, 279, 19);
		frame.getContentPane().add(textNomeDoArquivo);
		textNomeDoArquivo.setColumns(10);

		textRA = new JTextField();
		textRA.setBounds(84, 105, 87, 19);
		frame.getContentPane().add(textRA);
		textRA.setColumns(10);
		
		textRB = new JTextField();
		textRB.setBounds(224, 105, 87, 19);
		frame.getContentPane().add(textRB);
		textRB.setColumns(10);
		
		textRX = new JTextField();
		textRX.setBounds(367, 105, 87, 19);
		frame.getContentPane().add(textRX);
		textRX.setColumns(10);
		
		textPC = new JTextField();
		textPC.setBounds(509, 105, 87, 19);
		frame.getContentPane().add(textPC);
		textPC.setColumns(10);

		JLabel lblNomeDoArquivo = new JLabel("Nome do Arquivo de Entrada:");
		lblNomeDoArquivo.setBounds(84, 30, 220, 15);
		frame.getContentPane().add(lblNomeDoArquivo);
		
		JLabel lblRegistradores = new JLabel("REGISTRADORES");
		lblRegistradores.setBounds(280, 65, 122, 15);
		frame.getContentPane().add(lblRegistradores);
		
		JLabel lblRa = new JLabel("RA");
		lblRa.setBounds(84, 92, 70, 15);
		frame.getContentPane().add(lblRa);
		
		JLabel lblRb = new JLabel("RB");
		lblRb.setBounds(225, 92, 70, 15);
		frame.getContentPane().add(lblRb);
		
		JLabel lblRx = new JLabel("RX");
		lblRx.setBounds(367, 92, 70, 15);
		frame.getContentPane().add(lblRx);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(509, 92, 70, 15);
		frame.getContentPane().add(lblPc);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 309, 658, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 60, 658, 2);
		frame.getContentPane().add(separator_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("N");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setBounds(240, 146, 43, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setSelected(false);
		
		JRadioButton rdbtnZ = new JRadioButton("Z");
		rdbtnZ.setContentAreaFilled(false);
		rdbtnZ.setBounds(309, 146, 43, 23);
		frame.getContentPane().add(rdbtnZ);
		rdbtnZ.setEnabled(false);
		rdbtnZ.setSelected(false);
		
		JRadioButton rdbtnCarry = new JRadioButton("Carry");
		rdbtnCarry.setBounds(370, 146, 70, 23);
		frame.getContentPane().add(rdbtnCarry);
		rdbtnCarry.setEnabled(false);
		rdbtnCarry.setSelected(false);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 177, 658, 2);
		frame.getContentPane().add(separator_2);
	}
}
