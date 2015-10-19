package br.com.ufes.view;

import java.awt.EventQueue;

import javax.naming.ldap.Rdn;
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
import java.util.Vector;

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

import javax.swing.JScrollPane;

public class View{

	public JFrame frame;
	public JTextField textNomeDoArquivo;
	public JTextField textRA;
	public JTextField textRB;
	public JTextField textRX;
	public JTextField textPC;
	public JButton btnPasso;
	public JButton btnDireto;
	public JButton btnCarregaInst;
	public JButton btnCarregaMem;
	public JTable tableMem;
	public JScrollPane scrollPane;
	public JRadioButton rdbtnN;
	public JRadioButton rdbtnZ;
	public JRadioButton rdbtnCarry;
	boolean iniciar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<String> microinstrucoes = new ArrayList<String>();
					
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
					ramses.carregaDadosMem(mem, "dados.txt");
					View window = new View(ramses, microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica);
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public View(ArquiteturaRamses ramses, ArrayList<String> microinstrucoes, Registrador ra, Registrador rb, Registrador rx, Registrador raux, Multiplexador mux,
			RegistradorEstados estados, RegistradorPC pc, Registrador ri, Memoria mem, ULA unidadeAritmetica) {
		initialize();
		btnCarregaInstrucoes(ramses, microinstrucoes);
		btnResul(ramses, microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica);
		btnCarregaMemoria(mem.getDados());
	}
	
	public void btnCarregaMemoria(byte[] dados) {
		btnCarregaMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while(i < 256) {
					tableMem.setValueAt(Byte.toString(dados[i]), i, 1);
					i++;
				}
			}
		});
	}
	
	public void btnResul(ArquiteturaRamses ramses, ArrayList<String> microinstrucoes, Registrador ra, Registrador rb, Registrador rx, Registrador raux, Multiplexador mux,
			RegistradorEstados estados, RegistradorPC pc, Registrador ri, Memoria mem, ULA unidadeAritmetica) {
		btnDireto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	ramses.carregarValor(microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica, estados);
            	textPC.setText(Byte.toString(ra.getConteudo()));
        		textRA.setText(Byte.toString(rb.getConteudo()));
        		textRB.setText(Byte.toString(rx.getConteudo()));
        		textRX.setText(Byte.toString(pc.getConteudo()));
        		if(estados.getCarga_C() == true) {
        			rdbtnCarry.setSelected(true);
        		}
        		if(estados.getCarga_N() == true) {
        			rdbtnN.setSelected(true);
        		}
        		if(estados.getCarga_Z() == true) {
        			rdbtnZ.setSelected(true);
        		}
        		
        		btnCarregaMemoria(mem.getDados());
            }
		});
	}
	
	public void btnCarregaInstrucoes(ArquiteturaRamses ramses, ArrayList<String> microinstrucoes) {
		btnCarregaInst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	ramses.lerArquivo(microinstrucoes, textNomeDoArquivo.getText());
            }
		});
	}
	

	private void initialize() {
		
		Vector<String> nomeColuna = new Vector<String>();
	    nomeColuna.addElement("Indices");
	    nomeColuna.addElement("Valores");
		
		tableMem = new JTable(256, 2);
		int i = 0;
		int j = 0;
		while(i < 256) {
			tableMem.setValueAt(Integer.toString(j), i, 0);
			i++;
			j++;
		}
		
		scrollPane = new JScrollPane(tableMem);
		scrollPane.setBounds(376, 102, 105, 162);
		
		frame = new JFrame();
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(scrollPane);
		
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnPasso = new JButton(">>");
		btnPasso.setBounds(162, 323, 54, 25);
		frame.getContentPane().add(btnPasso);
		
		btnDireto = new JButton("=");
		btnDireto.setBounds(317, 323, 54, 25);
		frame.getContentPane().add(btnDireto);
		
		btnCarregaInst = new JButton("Carregar");
		btnCarregaInst.setBounds(421, 25, 99, 25);
		frame.getContentPane().add(btnCarregaInst);
		
		textNomeDoArquivo = new JTextField();
		textNomeDoArquivo.setBounds(227, 28, 182, 19);
		frame.getContentPane().add(textNomeDoArquivo);
		textNomeDoArquivo.setColumns(10);

		textRA = new JTextField();
		textRA.setEditable(false);
		textRA.setBounds(129, 101, 70, 19);
		frame.getContentPane().add(textRA);
		textRA.setColumns(10);
		
		textRB = new JTextField();
		textRB.setEditable(false);
		textRB.setBounds(129, 129, 70, 19);
		frame.getContentPane().add(textRB);
		textRB.setColumns(10);
		
		textRX = new JTextField();
		textRX.setEditable(false);
		textRX.setBounds(129, 158, 70, 19);
		frame.getContentPane().add(textRX);
		textRX.setColumns(10);
		
		textPC = new JTextField();
		textPC.setEditable(false);
		textPC.setBounds(129, 186, 70, 19);
		frame.getContentPane().add(textPC);
		textPC.setColumns(10);

		JLabel lblNomeDoArquivo = new JLabel("Nome do Arquivo de Entrada:");
		lblNomeDoArquivo.setBounds(12, 30, 220, 15);
		frame.getContentPane().add(lblNomeDoArquivo);
		
		JLabel lblRegistradores = new JLabel("REGISTRADORES");
		lblRegistradores.setBounds(94, 74, 122, 15);
		frame.getContentPane().add(lblRegistradores);
		
		JLabel lblRa = new JLabel("RA:");
		lblRa.setBounds(75, 103, 48, 15);
		frame.getContentPane().add(lblRa);
		
		JLabel lblRb = new JLabel("RB:");
		lblRb.setBounds(75, 131, 70, 15);
		frame.getContentPane().add(lblRb);
		
		JLabel lblRx = new JLabel("RX:");
		lblRx.setBounds(75, 160, 70, 15);
		frame.getContentPane().add(lblRx);
		
		JLabel lblPc = new JLabel("PC:");
		lblPc.setBounds(75, 188, 48, 15);
		frame.getContentPane().add(lblPc);
		
		JLabel lblMemria = new JLabel("Memória");
		lblMemria.setBounds(397, 78, 70, 15);
		frame.getContentPane().add(lblMemria);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 309, 508, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 60, 508, 2);
		frame.getContentPane().add(separator_1);
		
		rdbtnN = new JRadioButton("N");
		rdbtnN.setEnabled(false);
		rdbtnN.setBounds(64, 245, 43, 23);
		frame.getContentPane().add(rdbtnN);
		rdbtnN.setEnabled(false);
		rdbtnN.setSelected(false);
		
		rdbtnZ = new JRadioButton("Z");
		rdbtnZ.setContentAreaFilled(false);
		rdbtnZ.setBounds(133, 245, 43, 23);
		frame.getContentPane().add(rdbtnZ);
		rdbtnZ.setEnabled(false);
		rdbtnZ.setSelected(false);
		
		rdbtnCarry = new JRadioButton("Carry");
		rdbtnCarry.setBounds(194, 245, 70, 23);
		frame.getContentPane().add(rdbtnCarry);
		rdbtnCarry.setEnabled(false);
		rdbtnCarry.setSelected(false);
		
		btnCarregaMem = new JButton("Carga");
		btnCarregaMem.setBounds(376, 264, 105, 25);
		frame.getContentPane().add(btnCarregaMem);
	}
}
