package br.com.ufes.view;

import java.awt.EventQueue;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextPane;

public class View{

	public JFrame frame;
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
	private JTextField textacessm;
	private JTextField textacessalu;
	private JTextField textciclos;
	static int indice = 0;

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
					ramses.carregaDadosMem(mem, "dados.txt",ra,rb,rx,pc);
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
		btnppasso(ramses, microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica);
		btnCarregaMemoria(mem.getDados());
	}
	
	public void btnCarregaMemoria(byte[] dados) {
		btnCarregaMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCarregaMem.setEnabled(false);
				btnCarregaInst.setEnabled(true);
				int i = 0;
				while(i < 256) {
					tableMem.setValueAt(Byte.toString(dados[i]), i, 1);
					i++;
				}
			}
		});
	}
	
	public void btnppasso(ArquiteturaRamses ramses, ArrayList<String> microinstrucoes, Registrador ra, Registrador rb, Registrador rx, Registrador raux, Multiplexador mux,
			RegistradorEstados estados, RegistradorPC pc, Registrador ri, Memoria mem, ULA unidadeAritmetica) {
		btnPasso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ramses.getFim()) {
					ramses.carregarValorpp(indice, microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica, estados);
					textPC.setText(Byte.toString(pc.getConteudo()));
	        		textRA.setText(Byte.toString(ra.getConteudo()));
	        		textRB.setText(Byte.toString(rb.getConteudo()));
	        		textRX.setText(Byte.toString(rx.getConteudo()));
	        		
	        		System.out.println("estado"+estados.getCarga_N());
	        		System.out.println(unidadeAritmetica.getN());
	        		if(estados.getCarga_N() == true)
	        			rdbtnCarry.setSelected(unidadeAritmetica.getN());
	    			if(estados.getCarga_Z() == true)
	    				rdbtnN.setSelected(unidadeAritmetica.getZ());
	    			if(estados.getCarga_C() == true)
	    				rdbtnZ.setSelected(unidadeAritmetica.getC());
	        		
	        		btnCarregaMemoria(mem.getDados());
	        		indice++;
				}
	        	else {
					btnPasso.setEnabled(false);
					btnDireto.setEnabled(false);
	        	}
				textacessm.setText(Integer.toString(mem.getContadorMem()));
				textacessalu.setText(Integer.toString(unidadeAritmetica.getContadorOp()));
				textciclos.setText(Integer.toString(ramses.getContCiclos()));
			}
		});
	}
	
	public void btnResul(ArquiteturaRamses ramses, ArrayList<String> microinstrucoes, Registrador ra, Registrador rb, Registrador rx, Registrador raux, Multiplexador mux,
			RegistradorEstados estados, RegistradorPC pc, Registrador ri, Memoria mem, ULA unidadeAritmetica) {
		btnDireto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	
            	ramses.carregarValor(indice, microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica, estados);
            	System.out.println(Byte.toString(ra.getConteudo()));
            	textPC.setText(Byte.toString(pc.getConteudo()));
        		textRA.setText(Byte.toString(ra.getConteudo()));
        		textRB.setText(Byte.toString(rb.getConteudo()));
        		textRX.setText(Byte.toString(rx.getConteudo()));
        		
        		if(estados.getCarga_N() == true)
        			rdbtnCarry.setSelected(unidadeAritmetica.getN());
    			if(estados.getCarga_Z() == true)
    				rdbtnN.setSelected(unidadeAritmetica.getZ());
    			if(estados.getCarga_C() == true)
    				rdbtnZ.setSelected(unidadeAritmetica.getC());
    			
        		btnCarregaMemoria(mem.getDados());
        		btnDireto.setEnabled(false);
        		btnPasso.setEnabled(false);
        		
        		textacessm.setText(Integer.toString(mem.getContadorMem()));
				textacessalu.setText(Integer.toString(unidadeAritmetica.getContadorOp()));
				textciclos.setText(Integer.toString(ramses.getContCiclos()));
            }
		});
	}
	
	public void btnCarregaInstrucoes(ArquiteturaRamses ramses, ArrayList<String> microinstrucoes) {
		btnCarregaInst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {	
            	btnCarregaInst.setEnabled(false);
            	btnDireto.setEnabled(true);
            	btnPasso.setEnabled(true);
            	ramses.lerArquivo(microinstrucoes, "instrucoes.txt");
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
		scrollPane.setBounds(367, 50, 105, 181);
		
		frame = new JFrame();
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(scrollPane);
		
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnPasso = new JButton(">>");
		btnPasso.setBounds(22, 323, 54, 25);
		frame.getContentPane().add(btnPasso);
		btnPasso.setEnabled(false);
		
		btnDireto = new JButton("=");
		btnDireto.setBounds(94, 323, 54, 25);
		frame.getContentPane().add(btnDireto);
		btnDireto.setEnabled(false);
		
		btnCarregaInst = new JButton("Carregar Instruções");
		btnCarregaInst.setBounds(185, 323, 176, 25);
		frame.getContentPane().add(btnCarregaInst);
		btnCarregaInst.setEnabled(false);
		
		btnCarregaMem = new JButton("Carga Memoria");
		btnCarregaMem.setBounds(351, 234, 141, 25);
		frame.getContentPane().add(btnCarregaMem);
		
		rdbtnN = new JRadioButton("N");
		rdbtnN.setEnabled(false);
		rdbtnN.setBounds(67, 180, 43, 23);
		frame.getContentPane().add(rdbtnN);
		rdbtnN.setEnabled(false);
		rdbtnN.setSelected(false);
		
		rdbtnZ = new JRadioButton("Z");
		rdbtnZ.setContentAreaFilled(false);
		rdbtnZ.setBounds(136, 180, 43, 23);
		frame.getContentPane().add(rdbtnZ);
		rdbtnZ.setEnabled(false);
		rdbtnZ.setSelected(false);
		
		rdbtnCarry = new JRadioButton("Carry");
		rdbtnCarry.setBounds(197, 180, 70, 23);
		frame.getContentPane().add(rdbtnCarry);
		rdbtnCarry.setEnabled(false);
		rdbtnCarry.setSelected(false);
		
		textRA = new JTextField();
		textRA.setEditable(false);
		textRA.setBounds(129, 53, 70, 19);
		frame.getContentPane().add(textRA);
		textRA.setColumns(10);
		
		textRB = new JTextField();
		textRB.setEditable(false);
		textRB.setBounds(129, 81, 70, 19);
		frame.getContentPane().add(textRB);
		textRB.setColumns(10);
		
		textRX = new JTextField();
		textRX.setEditable(false);
		textRX.setBounds(129, 110, 70, 19);
		frame.getContentPane().add(textRX);
		textRX.setColumns(10);
		
		textPC = new JTextField();
		textPC.setEditable(false);
		textPC.setBounds(129, 138, 70, 19);
		frame.getContentPane().add(textPC);
		textPC.setColumns(10);
		
		textacessm = new JTextField();
		textacessm.setHorizontalAlignment(SwingConstants.CENTER);
		textacessm.setEditable(false);
		textacessm.setBounds(206, 225, 114, 19);
		frame.getContentPane().add(textacessm);
		textacessm.setColumns(10);
		
		textacessalu = new JTextField();
		textacessalu.setHorizontalAlignment(SwingConstants.CENTER);
		textacessalu.setEditable(false);
		textacessalu.setBounds(206, 253, 114, 19);
		frame.getContentPane().add(textacessalu);
		textacessalu.setColumns(10);
		
		textciclos = new JTextField();
		textciclos.setHorizontalAlignment(SwingConstants.CENTER);
		textciclos.setEditable(false);
		textciclos.setBounds(206, 282, 114, 19);
		frame.getContentPane().add(textciclos);
		textciclos.setColumns(10);
		
		JLabel lblRegistradores = new JLabel("REGISTRADORES");
		lblRegistradores.setBounds(94, 26, 122, 15);
		frame.getContentPane().add(lblRegistradores);
		
		JLabel lblRa = new JLabel("RA:");
		lblRa.setBounds(75, 55, 48, 15);
		frame.getContentPane().add(lblRa);
		
		JLabel lblRb = new JLabel("RB:");
		lblRb.setBounds(75, 83, 70, 15);
		frame.getContentPane().add(lblRb);
		
		JLabel lblRx = new JLabel("RX:");
		lblRx.setBounds(75, 112, 70, 15);
		frame.getContentPane().add(lblRx);
		
		JLabel lblPc = new JLabel("PC:");
		lblPc.setBounds(75, 140, 48, 15);
		frame.getContentPane().add(lblPc);
		
		JLabel lblMemria = new JLabel("Memória");
		lblMemria.setBounds(388, 26, 70, 15);
		frame.getContentPane().add(lblMemria);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 309, 508, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 12, 508, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 211, 308, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNmeroDeAcessos = new JLabel("Nº de Acessos a Memória:");
		lblNmeroDeAcessos.setBounds(12, 227, 222, 15);
		frame.getContentPane().add(lblNmeroDeAcessos);
		
		JLabel lblNmeroDeOperaes = new JLabel("Nº de Operações na ALU:");
		lblNmeroDeOperaes.setBounds(12, 254, 222, 16);
		frame.getContentPane().add(lblNmeroDeOperaes);
		
		JLabel lblNDeCiclos = new JLabel("Nº de Ciclos simulados:");
		lblNDeCiclos.setBounds(12, 282, 187, 15);
		frame.getContentPane().add(lblNDeCiclos);
	}
}
