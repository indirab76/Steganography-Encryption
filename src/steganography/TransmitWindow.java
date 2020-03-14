package steganography;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.DatatypeConverter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextPane;

public class TransmitWindow extends javax.swing.JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param args
	 */

	public TransmitWindow() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 21));
		go();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TransmitWindow().setVisible(true);
			}
		});
	}
	JFrame frame;
	private JLabel label1;
	private JFileChooser filechooser1, filechooser2, filechooser3, filechooser4;
	File tempfilename, selectedFile;
	JTextArea textarea;
	JPanel panel7;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	private String str1 = "",str2 = "",strr="";
	private static String algo="DES";
	private String OK="";
	private JRadioButton b3;
	private JRadioButton b4;
	private JRadioButton rbtn1;
	private JRadioButton rbtn2;
	private JRadioButton rbtn3;
	private JRadioButton rbtn4;
	private JRadioButton rbtn5;
	private JRadioButton rbtn6;
	private JTextPane pnr;
	private JTextPane mse;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button5;
	private JButton jButton6;
	private ButtonGroup buttonGroup1;
	private ButtonGroup buttonGroup2;
	private ButtonGroup buttonGroup3;
	private JButton jButton5;
	private JButton jButton7;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JScrollPane jScroll1;
	private JScrollPane jScroll2;
	private byte[] hiddenBytes;
	private byte[] encryptedMessage;
	private byte[] encryptedMsg;
	private File encryptedFile;
	public JButton button11;
	private static JPasswordField passwordField1;
	private static JPasswordField passwordField2;
	private static JPasswordField passwordField3;
	private static JPasswordField passwordField4;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JLabel label = new JLabel("New label");
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;



	public void go() {

		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.BOLD, 21));
		UIManager.put("OptionPane.buttonFont", new Font("Tahoma", Font.PLAIN, 21));

		buttonGroup1 = new ButtonGroup();
		buttonGroup2 = new ButtonGroup();
		buttonGroup3 = new ButtonGroup();
		
		button11 = new JButton("OK");
		button11.addActionListener(this);


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.PLAIN, 21));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 1249, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(169)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane_1)
					.addContainerGap())
		);
		
		
		jPanel1 = new JPanel();
		 panel1 = new JPanel();
		 panel1.setBackground(SystemColor.controlLtHighlight);
		 panel2 = new JPanel();
		 panel2.setBackground(SystemColor.controlLtHighlight);
		  panel3 = new JPanel();
		  panel3.setBackground(SystemColor.controlLtHighlight);
		  panel4 = new JPanel();
		  panel4.setBackground(SystemColor.controlLtHighlight);
		   pnr = new JTextPane();
		   pnr.setText("PSNR");
		   pnr.setForeground(Color.BLACK);
		   mse = new JTextPane();
		   mse.setText("MSE");
		jScroll1=new JScrollPane(jPanel1);
		jPanel1.setBackground(SystemColor.controlLtHighlight);
		tabbedPane_1.addTab("Encryption", null, jScroll1, null);
		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jLabel2 = new JLabel();
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		b3 = new JRadioButton();
		b3.setBackground(SystemColor.controlLtHighlight);
		b3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		b3.setSelected(true);
		b4 = new JRadioButton();
		b4.setBackground(SystemColor.controlLtHighlight);
		b4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rbtn1 = new JRadioButton();
		rbtn2 = new JRadioButton();
		rbtn3 = new JRadioButton();
		rbtn4 = new JRadioButton();
		rbtn5 = new JRadioButton();
		rbtn6 = new JRadioButton();
		button1 = new JButton();
		button1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button5 = new JButton();
		button5.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jLabel3 = new JLabel();
		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jLabel4 = new JLabel();
		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		passwordField1 = new JPasswordField(12);
		passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		passwordField2 = new JPasswordField(12);
		passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button2 = new JButton();
		button2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button3 = new JButton();
		button3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		
				button1.addActionListener(this);
				button2.setActionCommand(OK);
				button2.addActionListener(this);
				button3.addActionListener(this);
				button5.addActionListener(this);
				passwordField1.setActionCommand(OK);
				passwordField2.setActionCommand(OK);
				
						jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma",Font.BOLD, 36), new java.awt.Color(153, 153, 153)), "")); // NOI18N
						
								jLabel1.setText("Browse Career Image");
												
														jLabel2.setText("Select Message");
														
																buttonGroup2.add(b3);
																b3.setText("Enter Text");
																
																		buttonGroup2.add(b4);
																		b4.setText("Select File");
																		
																				button1.setText("Browse");
																				
																						button5.setText("Next");
																						
																								jLabel3.setText("Enter Password");
																								
																										jLabel4.setText("Re-Enter Password");
																										
																										
																										
																												button2.setText("Encrypt Message");
																												
																														button3.setText("Embed Message");
																																
																																JLabel lblNewLabel = new JLabel("Select Encryption Algorithm\r\n");
																																lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																
																																buttonGroup1.add(rbtn3);
																																rbtn3.setText("DES Encryption");
																																rbtn3.setBackground(SystemColor.controlLtHighlight);
																																rbtn3.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																
																																buttonGroup1.add(rbtn2);
																																rbtn2.setText("Blowfish Encryption");
																																rbtn2.setBackground(SystemColor.controlLtHighlight);
																																rbtn2.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																
																																buttonGroup1.add(rbtn1);
																																rbtn1.setText("AES / Rijndael Encryption");
																																rbtn1.setSelected(true);
																																rbtn1.setBackground(SystemColor.controlLtHighlight);
																																rbtn1.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																
																																
																																panel1.setBorder(new TitledBorder(null, "Original Image", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 21), null));
																																
																																panel2.setBorder(new TitledBorder(null, "Embeded Image", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 21), null));
																																
																																lblNewLabel_1 = new JLabel("PSNR Value");
																																lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																lblNewLabel_2 = new JLabel("MSE Value\r\n");
																																lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																
																																pnr.setEditable(false);
																																pnr.setEnabled(false);
																																pnr.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																
																																
																																mse.setEditable(false);
																																mse.setEnabled(false);
																																mse.setFont(new Font("Tahoma", Font.PLAIN, 21));
																														
																																javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
																																jPanel1Layout.setHorizontalGroup(
																																	jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																		.addGroup(jPanel1Layout.createSequentialGroup()
																																			.addGap(45)
																																			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
																																			.addGap(18)
																																			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
																																			.addContainerGap(52, Short.MAX_VALUE))
																																		.addGroup(jPanel1Layout.createSequentialGroup()
																																			.addGap(34)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																				.addComponent(button3, GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
																																				.addGroup(jPanel1Layout.createSequentialGroup()
																																					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																						.addGroup(jPanel1Layout.createSequentialGroup()
																																							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
																																								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
																																								.addComponent(jLabel1))
																																							.addPreferredGap(ComponentPlacement.RELATED))
																																						.addGroup(jPanel1Layout.createSequentialGroup()
																																							.addComponent(b3, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
																																							.addGap(41))
																																						.addGroup(jPanel1Layout.createSequentialGroup()
																																							.addComponent(jLabel2)
																																							.addPreferredGap(ComponentPlacement.RELATED))
																																						.addGroup(jPanel1Layout.createSequentialGroup()
																																							.addComponent(jLabel3)
																																							.addPreferredGap(ComponentPlacement.RELATED)))
																																					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																						.addGroup(jPanel1Layout.createSequentialGroup()
																																							.addComponent(b4)
																																							.addGap(113)
																																							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
																																								.addComponent(button1, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
																																								.addComponent(button5, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)))
																																						.addGroup(jPanel1Layout.createSequentialGroup()
																																							.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																							.addGap(258)
																																							.addComponent(jLabel4)
																																							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
																																							.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
																																				.addGroup(jPanel1Layout.createSequentialGroup()
																																					.addComponent(lblNewLabel)
																																					.addPreferredGap(ComponentPlacement.RELATED))
																																				.addComponent(rbtn1)
																																				.addComponent(rbtn2)
																																				.addComponent(rbtn3)
																																				.addComponent(button2, GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE))
																																			.addGap(44))
																																		.addGroup(jPanel1Layout.createSequentialGroup()
																																			.addGap(60)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																				.addComponent(lblNewLabel_1)
																																				.addComponent(lblNewLabel_2))
																																			.addGap(78)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
																																				.addComponent(mse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																				.addComponent(pnr, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
																																			.addContainerGap(849, Short.MAX_VALUE))
																																);
																																jPanel1Layout.setVerticalGroup(
																																	jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																		.addGroup(jPanel1Layout.createSequentialGroup()
																																			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
																																			.addGap(30)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
																																				.addComponent(jLabel1)
																																				.addComponent(button1))
																																			.addGap(20)
																																			.addComponent(jLabel2)
																																			.addGap(18)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
																																				.addComponent(b3)
																																				.addComponent(b4)
																																				.addComponent(button5))
																																			.addGap(48)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
																																				.addComponent(jLabel3)
																																				.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																				.addComponent(jLabel4)
																																				.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																																			.addGap(38)
																																			.addComponent(lblNewLabel)
																																			.addGap(26)
																																			.addComponent(rbtn1)
																																			.addPreferredGap(ComponentPlacement.UNRELATED)
																																			.addComponent(rbtn2)
																																			.addPreferredGap(ComponentPlacement.UNRELATED)
																																			.addComponent(rbtn3)
																																			.addGap(18)
																																			.addComponent(button2)
																																			.addGap(18)
																																			.addComponent(button3)
																																			.addPreferredGap(ComponentPlacement.RELATED)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
																																				.addGroup(jPanel1Layout.createSequentialGroup()
																																					.addComponent(lblNewLabel_1)
																																					.addPreferredGap(ComponentPlacement.RELATED)
																																					.addComponent(lblNewLabel_2))
																																				.addGroup(jPanel1Layout.createSequentialGroup()
																																					.addComponent(pnr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																					.addComponent(mse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
																																			.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
																																			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
																																				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																				.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
																																			.addGap(115))
																																);
																																jPanel1.setLayout(jPanel1Layout);
																																jLabel6 = new JLabel();
																																jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																jLabel7 = new JLabel();
																																jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																passwordField3 = new JPasswordField(12);
																																passwordField3.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																passwordField4 = new JPasswordField(12);
																																passwordField4.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																jPanel2 = new JPanel();
																																jPanel2.setBackground(SystemColor.controlLtHighlight);
																																jScroll2=new JScrollPane(jPanel2);
																																tabbedPane_1.addTab("Decryption", null, jScroll2, null);
																																
																																jLabel5 = new JLabel();
																																jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																jButton5 = new JButton();
																																jButton5.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																jButton6 = new JButton();
																																jButton6.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																jButton7 = new JButton();
																																jButton7.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																jButton5.addActionListener(this);
																																jButton6.addActionListener(this);
																																jButton7.addActionListener(this);
																																jButton7.setActionCommand(OK);
																																passwordField3.setActionCommand(OK);
																																passwordField4.setActionCommand(OK);
																																				
																																				
																																				
																																						jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null,"", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", Font.BOLD, 36), new java.awt.Color(153, 153, 153)),"")); // NOI18N
																																						
																																								jLabel5.setText("Browse Encrypted Image");
																																								
																																										jLabel6.setText("Enter Password");
																																										
																																												jLabel7.setText("Re-enter Password");
																																																
																																																		jButton5.setText("Browse");
																																																		
																																																				jButton6.setText("Decode Message");
																																																				
																																																						jButton7.setText("Decrypt Message");
																																																								
																																																								JLabel lblNewLabel_3 = new JLabel("Select Algorithm for Decryption");
																																																								lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																								
																																																								buttonGroup3.add(rbtn4);
																																																								rbtn4.setText("AES / Rijndael Algorithm");
																																																								rbtn4.setBackground(SystemColor.controlLtHighlight);
																																																								rbtn4.setSelected(true);
																																																								rbtn4.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																								
																																																								buttonGroup3.add(rbtn5);
																																																								rbtn5.setText("Blowfish Algorithm");
																																																								rbtn5.setBackground(SystemColor.controlLtHighlight);
																																																								rbtn5.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																								
																																																								buttonGroup3.add(rbtn6);
																																																								rbtn6.setText("DES Algorithm");
																																																								rbtn6.setBackground(SystemColor.controlLtHighlight);
																																																								rbtn6.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																								
																																																								
																																																								panel3.setBorder(new TitledBorder(null, "Encrypted Image", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 21), null));
																																																								
																																																								
																																																								panel4.setBorder(new TitledBorder(null, "Decrypted Message", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 21), null));
																																																						
																																																								javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
																																																								jPanel2Layout.setHorizontalGroup(
																																																									jPanel2Layout.createParallelGroup(Alignment.LEADING)
																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																											.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																													.addGap(27)
																																																													.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
																																																													.addGap(51)
																																																													.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE))
																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																													.addContainerGap()
																																																													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
																																																														.addComponent(rbtn6)
																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																															.addComponent(jLabel6)
																																																															.addGap(96)
																																																															.addComponent(passwordField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																																															.addGap(229)
																																																															.addComponent(jLabel7)
																																																															.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																															.addComponent(passwordField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																															.addComponent(jLabel5)
																																																															.addGap(195)
																																																															.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
																																																														.addComponent(lblNewLabel_3)
																																																														.addComponent(rbtn5)
																																																														.addComponent(rbtn4)
																																																														.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																														.addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																																																											.addContainerGap(578, Short.MAX_VALUE))
																																																								);
																																																								jPanel2Layout.setVerticalGroup(
																																																									jPanel2Layout.createParallelGroup(Alignment.LEADING)
																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																											.addGap(36)
																																																											.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
																																																												.addComponent(jLabel5)
																																																												.addComponent(jButton5))
																																																											.addGap(50)
																																																											.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
																																																												.addComponent(jLabel6)
																																																												.addComponent(passwordField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																																												.addComponent(jLabel7)
																																																												.addComponent(passwordField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																																																											.addGap(56)
																																																											.addComponent(lblNewLabel_3)
																																																											.addPreferredGap(ComponentPlacement.UNRELATED)
																																																											.addComponent(rbtn4)
																																																											.addPreferredGap(ComponentPlacement.RELATED)
																																																											.addComponent(rbtn5)
																																																											.addPreferredGap(ComponentPlacement.RELATED)
																																																											.addComponent(rbtn6)
																																																											.addGap(37)
																																																											.addComponent(jButton6)
																																																											.addGap(18)
																																																											.addComponent(jButton7)
																																																											.addGap(45)
																																																											.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
																																																												.addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																												.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
																																																											.addContainerGap())
																																																								);
																																																								//jScroll1=new JScrollPane(jPanel1);
																																																								jPanel2.setLayout(jPanel2Layout);
		getContentPane().setLayout(layout);

		pack();

		// file chooser
		
		UIManager.put("FileChooser.listFont",new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 21));
		filechooser1 = new JFileChooser();
		filechooser1.setPreferredSize(new Dimension(800, 600));
		filechooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filechooser2 = new JFileChooser();
		filechooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filechooser3 = new JFileChooser();
		filechooser3.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filechooser4 = new JFileChooser();
		filechooser4.setFileSelectionMode(JFileChooser.FILES_ONLY);


	}

	public static String bytesToString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			sb.append((char) (bytes[i] + 128));
		}
		return sb.toString();
	}

	public static byte[] stringToBytes(String str) {
		int length = str.length();
		byte[] b = new byte[length];
		for (int i = 0; i < length; i++) {
			b[i] = (byte) (str.charAt(i) - 128);
		}
		return b;
	}


	public File hideMessage(byte[] msg, File imgFile) {
		BufferedImage im = null;
		BufferedImage im1 = null;
		int r=filechooser4.showSaveDialog(null);
		File encryptedFile = null;
		if (r==JFileChooser.APPROVE_OPTION){
			encryptedFile = filechooser4.getSelectedFile();
		}
		
		try {
			im = ImageIO.read(imgFile);
			im1=ImageIO.read(imgFile);
			WritableRaster raster = im.getRaster();
			DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();

			byte[] writableBytes = buffer.getData();

           // msg=0;
			System.out.println("msgBytes : "+msg);

			int header = msg.length;
			byte[] lenBytes = intToBytes(header, 4);
			int totalLen = 4 + msg.length;
			byte[] bytesToHide = new byte[totalLen];

			System.arraycopy(lenBytes, 0, bytesToHide, 0, lenBytes.length);
			System.arraycopy(msg, 0, bytesToHide, lenBytes.length,
					msg.length);

			if (bytesToHide.length * 8 > writableBytes.length) {
				throw new RuntimeException("Image too small to hide message");
			}

			System.out.println("Writing bytes:");
			int offset = 0;
			for (int i = 0; i < bytesToHide.length; i += 1) {
				byte b = bytesToHide[i];
				System.out.print(b);
				System.out.print(' ');
				for (int j = 0; j < 8; j += 1) {
					int bit = (b >> j) & 1;
					writableBytes[offset] = (byte) ((writableBytes[offset] & 0xFE) | bit);
					offset += 1;
				}
			}
			System.out.println();
			System.out.println("Message length: " + msg.length);
			ImageIO.write(im, "png", encryptedFile);
	
			mse.setText(PSNRandMSE.printMSE(im1,im));
			pnr.setText(PSNRandMSE.printPSNR());
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return encryptedFile;
	}

	public byte[] showMessage(File imgFile) {
		BufferedImage im = null;
		try {
			im = ImageIO.read(imgFile);
			WritableRaster raster = im.getRaster();
			DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
			byte[] data = buffer.getData();

			int len = 0;
			int offset = 0;

			System.out.println("Message header is:");
			for (int i = 0; i < 4; i += 1) { // read length header (4 bytes)
				byte b = 0;
				for (int j = 0; j < 8; j += 1) {
					b |= (data[offset] & 1) << j;
					offset += 1;
				}
				System.out.print(b);
				System.out.print(' ');
				len |= b << (8 * i);
			}
			System.out.println();

			System.out.println("Decoding message:");
			hiddenBytes = new byte[len];
			for (int i = 0; i < len; i += 1) {
				byte b = 0;
				for (int j = 0; j < 8; j += 1) {
					b |= (data[offset] & 1) << j;
					offset += 1;
				}
				hiddenBytes[i] = b;
				System.out.print(b);                
				System.out.print(' ');
			}


			System.out.println();
			System.out.println("Encrypted data length is: " + len);
			System.out.println("hiddenbytes"+hiddenBytes);

		} catch (Exception e) {
			Component veiw = null;
			JOptionPane.showMessageDialog(veiw,
					"Selected file has no hidden meassage", "Error!",
					JOptionPane.ERROR_MESSAGE);
			throw new NegativeArraySizeException("ERROR! Please Try Again");
		}
		return hiddenBytes;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == button1) {
			
				FileFilter filter = new FileNameExtensionFilter("PNG", "PNG");
				filechooser1.addChoosableFileFilter(filter);
				int r = filechooser1.showDialog(null, "Open file");
				if (r == JFileChooser.APPROVE_OPTION) {
					selectedFile = filechooser1.getSelectedFile();
			} 
				 BufferedImage image = null;
			       try {                
			          image = ImageIO.read(selectedFile);
			       } catch (IOException ex) {
			            ex.printStackTrace();
			       }
			       JLabel picLabel = new JLabel(new ImageIcon(image));
			       panel1.removeAll();
			       panel1.add(picLabel);
			       panel1.revalidate();
			       panel1.repaint();
			       panel2.removeAll();
			       panel2.revalidate();
			       panel2.repaint();
			       
                  // System.out.println("test1 after browse");
		}
		// for button 5(Next)
		else if (event.getSource() == button5) {
			// for radio button b3
			if (b3.isSelected()) {
				
				MyDialog d = new MyDialog(frame, "Dialog");
				d.setVisible(true);
			        str1 = d.getText();
				System.out.println(str1.getBytes());
				System.out.println(str1);

				
				/* We can use Another way of getting password given bolow 
				 * instead of using the class "MyDialog"
				  
				   str1 = JOptionPane.showInputDialog(null,
				   "Enter your message:",
				   "Message Box",
				   JOptionPane.PLAIN_MESSAGE);*/
				
			} // end of b3

			// for radio button b4
			else if (b4.isSelected()) {
				int p = filechooser2.showDialog(null, "Open file");
				if (p == JFileChooser.APPROVE_OPTION) {
					File selectedFile = filechooser2.getSelectedFile();

					// read file content
					// System.out.println(selectedFile);
					FileReader fin = null;

					try {
						fin = new FileReader(selectedFile);
						StreamTokenizer stok = new StreamTokenizer(fin);
						int tok = stok.nextToken();
						while (tok != StreamTokenizer.TT_EOF) {
							str1 = str1+" "+stok.sval;                            
							tok = stok.nextToken();
						}
						System.out.println(str1);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (fin != null) {
							try {
								fin.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

				}
			}// end of b4

		}// end of button5

		//for Message Encryption
		else if(event.getSource() == button2){
			String cmd = event.getActionCommand();
			if (OK.equals(cmd)) { //Process the password.
				char[] input = passwordField1.getPassword();
				char[] input2 = passwordField2.getPassword();
				String key1= new String(input);
				Component view = null;
				if (isPasswordCorrect(input,input2)) {
					if(input.length<6){
						JOptionPane.showMessageDialog(view,
								"Password must contain atleast 6 characters.",
								"Weak Password",
								JOptionPane.INFORMATION_MESSAGE);		
					}
					else
					{
						if(rbtn1.isSelected()) {
							AES obj1=new AES();
							encryptedMsg=obj1.encryptMessage(str1,key1);
						}
						else if(rbtn2.isSelected()) {
							Blowfish obj2=new Blowfish();
							encryptedMsg=obj2.encryptMessage(str1,key1);
						}
						else if(rbtn3.isSelected()) {
							DES obj3=new DES();
							encryptedMsg=obj3.encryptMessage(str1,key1);
						}
						else
							encryptedMsg=stringToBytes(str1);
						}
				} else {
					JOptionPane.showMessageDialog(view,
							"Passwords entered does not match. Try again.",
							"Error Message",
							JOptionPane.ERROR_MESSAGE);
					passwordField1.setText("");
					passwordField2.setText("");
				}
			}

		}

		else if (event.getSource() == button3) {

			File encryptedFile = this.hideMessage(encryptedMsg ,this.selectedFile);
			 BufferedImage image = null;
		       try {                
		          image = ImageIO.read(encryptedFile);
		       } catch (IOException ex) {
		            ex.printStackTrace();
		       }
		       JLabel picLabel = new JLabel(new ImageIcon(image));
		       panel2.add(picLabel);
		       panel2.revalidate();
		       panel2.repaint();
		}

		else if (event.getSource() == jButton5) {
			
				FileFilter filter = new FileNameExtensionFilter("PNG", "PNG");
				filechooser3.addChoosableFileFilter(filter);
				int r = filechooser1.showDialog(null, "Open file");
				if (r == JFileChooser.APPROVE_OPTION) {
					encryptedFile = filechooser1.getSelectedFile();
					/* FileFilter filter = new FileNameExtensionFilter("PNG", "PNG");
                filechooser1.addChoosableFileFilter(filter);
                int r = filechooser1.showDialog(null, "Open file");
                if (r == JFileChooser.APPROVE_OPTION) {
                    selectedFile = filechooser1.getSelectedFile();*/
					BufferedImage image = null;
				       try {                
				          image = ImageIO.read(encryptedFile);
				       } catch (IOException ex) {
				            ex.printStackTrace();
				       }
				       JLabel picLabel = new JLabel(new ImageIcon(image));
				       panel3.removeAll();
				       panel3.add(picLabel);
				       panel3.revalidate();
				       panel3.repaint();
				       panel4.removeAll();
				       panel4.revalidate();
				       panel4.repaint();

				
			} 
		}


		else if (event.getSource()== jButton6){


			encryptedMessage = this.showMessage(encryptedFile);
			System.out.println("msbBytes : "+encryptedMessage);

		}

		else if (event.getSource () == jButton7){
			String cmd = event.getActionCommand();
			if (OK.equals(cmd)) { //Process the password.
				char[] input = passwordField3.getPassword();
				char[] input2 = passwordField4.getPassword();
				String key1= new String(input);
				Component view = null;
				if (isPasswordCorrect(input,input2)) {
					//String str=bytesToString(encryptedMessage);
					//strr=decryptMessage(str,key1);
						try {
							if(rbtn4.isSelected()) {
								AES obj1=new AES();
								strr=obj1.decryptMessage(encryptedMessage,key1);
							}
							else if(rbtn5.isSelected()) {
								Blowfish obj2=new Blowfish();
								strr=obj2.decryptMessage(encryptedMessage,key1);
							}
							else if(rbtn6.isSelected()) {
								DES obj3=new DES();
								strr=obj3.decryptMessage(encryptedMessage,key1);
							}
							else
								strr=bytesToString(encryptedMessage);
							
						} catch (BadPaddingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					 JLabel stringLabel = new JLabel(strr);
					 stringLabel.setFont(new Font("Tahoma", Font.BOLD, 21) );
					 
				       panel4.add(stringLabel);
				       panel4.revalidate();
				       panel4.repaint();
				       
					
					System.out.println("message is:" + strr);

				} else {
					JOptionPane.showMessageDialog(view,
							"Passwords entered does not match. Try again.",
							"Error Message",
							JOptionPane.ERROR_MESSAGE);
					passwordField3.setText("");
					passwordField4.setText("");
				}
			}
		}
	}   // end of actionPerformer()

	private static byte[] intToBytes(int num, int numBytes) {
		byte[] bytes = new byte[numBytes];
		for (int i = 0; i < numBytes; i += 1) {
			bytes[i] = (byte) ((num >> (8 * i)) & 0xFF);
		}
		return bytes;
	}

	private static int bytesToInt(byte[] bytes, int numBytes) {
		int num = 0;
		for (int i = 0; i < numBytes; i += 1) {
			num |= (bytes[i] & 0xFF) << (8 * i);
		}
		return num;
	}


	private static boolean isPasswordCorrect(char[] input,char[] input2) {
		boolean isCorrect = true;


		if (input.length != input2.length) {
			isCorrect = false;
			passwordField1.setText("");
			passwordField2.setText("");
		} else {
			isCorrect = Arrays.equals (input, input2);
			Arrays.fill(input, '0');
			Arrays.fill(input2,'0');
			passwordField1.selectAll();
			passwordField2.selectAll();
		}

		//Zero out the password.
		
		return isCorrect;
	}
}// end of Class


