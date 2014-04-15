package gui;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import logic.Stock;

public class StockPanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel btnBuy, btnSell;
	private boolean hasStock = false;
	private Stock selectedStock = null;
	private ArrayList<Stock> stocks;
	private JLabel lblStockName, lblStockPrice, lblDuEjerX, lblDuKanKbe, lblAktiensPrisEr, lblHvisDuSlger;


	/**
	 * Create the panel.
	 */
	public StockPanel() {
		this.setSize(800, 600);
		setLayout(null);

		// For test a fake Stock object
		selectedStock = new Stock("Apple", 120.25);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(13);
		panel_2.setBounds(6, 6, 263, 45);
		add(panel_2);

		JLabel lblDig = new JLabel("Dig:");
		panel_2.add(lblDig);

		JLabel lblYourMoney = new JLabel("$100.000 US");
		lblYourMoney.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_2.add(lblYourMoney);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(13);
		panel_3.setBounds(268, 6, 263, 45);
		add(panel_3);

		JLabel lblModstander = new JLabel("Modstander:");
		panel_3.add(lblModstander);

		JLabel lblOpponentMoney = new JLabel("$87.000 US");
		lblOpponentMoney.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_3.add(lblOpponentMoney);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setVgap(13);
		panel_4.setBounds(531, 6, 263, 45);
		add(panel_4);

		JLabel lblTidTilbage = new JLabel("Tid tilbage:");
		panel_4.add(lblTidTilbage);

		JLabel lblTime = new JLabel("1 time 13 min");
		lblTime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_4.add(lblTime);

		JPanel all = new JPanel();
		all.setBounds(15, 63, 767, 511);
		add(all);
		all.setOpaque(true);
		all.setBackground(new Color(0,0,0,0));
		all.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 255, 499);
		all.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		lblStockName = new JLabel("NameOfStock");		
		lblStockName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblStockName.setBounds(285, 6, 476, 16);
		all.add(lblStockName);

		JLabel lblMarket = new JLabel("");
		lblMarket.setForeground(Color.GRAY);
		lblMarket.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblMarket.setBounds(285, 23, 476, 16);
		all.add(lblMarket);

		btnBuy = new JPanel();
		btnBuy.addMouseListener(this);
		btnBuy.setBackground(ClientWindow.green);
		FlowLayout fl_btnBuy = (FlowLayout) btnBuy.getLayout();
		fl_btnBuy.setVgap(13);
		btnBuy.setBounds(285, 455, 223, 41);
		all.add(btnBuy);

		JLabel lblKbAktie = new JLabel("K\u00F8b Aktier");
		btnBuy.add(lblKbAktie);

		btnSell = new JPanel();
		btnSell.addMouseListener(this);
		
		// If person hasn't got stock set color to gray
		if (this.hasStock) {
			btnSell.setBackground(ClientWindow.red);
		} else {
			btnSell.setBackground(Color.GRAY);
		}
		
		FlowLayout fl_btnSell = (FlowLayout) btnSell.getLayout();
		fl_btnSell.setVgap(13);
		btnSell.setBounds(520, 455, 226, 41);
		all.add(btnSell);

		JLabel lblSlgAktier = new JLabel("S\u00E6lg Aktier");
		btnSell.add(lblSlgAktier);

		JLabel lblPridForAktie = new JLabel("Pris for aktie:");
		lblPridForAktie.setBounds(285, 68, 96, 16);
		all.add(lblPridForAktie);

		lblStockPrice = new JLabel("$25.00");
		lblStockPrice.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStockPrice.setBounds(382, 68, 96, 16);
		all.add(lblStockPrice);


		lblDuEjerX = new JLabel("Du ejer X stk. af denne aktie til en samlet v\u00E6rdi af: $ XX.XX");
		lblDuEjerX.setBounds(285, 105, 461, 16);
		all.add(lblDuEjerX);

		lblDuKanKbe = new JLabel("Du kan k\u00F8be op til: XX stk. af denne aktie med din nuv\u00E6rende saldo.");
		lblDuKanKbe.setBounds(285, 125, 461, 16);
		all.add(lblDuKanKbe);

		lblAktiensPrisEr = new JLabel("Aktiens pris er faldet med XX.XX siden du foretog et k\u00F8b.");
		lblAktiensPrisEr.setBounds(285, 167, 461, 16);
		all.add(lblAktiensPrisEr);

		lblHvisDuSlger = new JLabel("Hvis du s\u00E6lger alle aktierne nu, vil du tabe $ XXX.XX");
		lblHvisDuSlger.setBounds(285, 187, 461, 16);
		all.add(lblHvisDuSlger);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 48, 788, 12);
		add(separator);
		
		// Set values of selected Stock
		if (this.selectedStock != null) {
			this.lblStockName.setText(this.selectedStock.getName());
			this.lblStockPrice.setText(Double.toString(this.selectedStock.getValue()));
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnBuy) {
			btnBuy.setBackground(ClientWindow.hoverGreen);
			btnBuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		if (e.getSource() == btnSell) {
			if (this.hasStock) {
				btnSell.setBackground(ClientWindow.hoverRed);
				btnSell.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnBuy) {
			btnBuy.setBackground(ClientWindow.green);
		}
		if (e.getSource() == btnSell) {
			if (this.hasStock) {
				btnSell.setBackground(ClientWindow.red);
			}
		}
	}
}