import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class Huffmangui {
	
	private JFrame frmTextCompressorBy;
	private JFileChooser fileChooser;
	String fullPath;
	private JTextField textField;
	private JButton btnBrowse,btnClickToCompress,btnClickToDecompress;
	private JLabel lblNewLabel;
    filecompress f;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Huffmangui window = new Huffmangui();
					 window.frmTextCompressorBy.setVisible(true);
				 } catch (Exception e) {
					e.printStackTrace();
				 }
			 }
		});
	}

	public Huffmangui() {
		initialize();
	}

	private void initialize() {
		
		frmTextCompressorBy = new JFrame();
		frmTextCompressorBy.setTitle("Text Compressor ");
		frmTextCompressorBy.getContentPane().setBackground(Color.DARK_GRAY);
		frmTextCompressorBy.setBounds(100, 100, 852, 510);
		frmTextCompressorBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextCompressorBy.getContentPane().setLayout(null);
		frmTextCompressorBy.setLocationRelativeTo(null);
		
		lblNewLabel = new JLabel("                       Text Compressor");
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 32));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBackground(Color.DARK_GRAY);
        lblNewLabel.setBounds(10, 11, 746, 50);
	    frmTextCompressorBy.getContentPane().add(lblNewLabel);
	    
	    textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(10, 173, 696, 42);
		textField.setColumns(10);
		frmTextCompressorBy.getContentPane().add(textField);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser f=new JFileChooser();
				FileTypeFilter filter = new FileTypeFilter(".txt","text");
				f.addChoosableFileFilter(filter);
				int i=f.showOpenDialog(null);    
				    if(i==JFileChooser.APPROVE_OPTION){    
				        File fc=f.getSelectedFile();    
				         fullPath=fc.getPath(); 
				         textField.setText(fullPath);	         
			    }
			}
		});
		btnBrowse.setBackground(Color.LIGHT_GRAY);
		btnBrowse.setBounds(717, 173, 89, 43);
		frmTextCompressorBy.getContentPane().add(btnBrowse);
	        
		btnClickToCompress = new JButton("Click to Compress");
		btnClickToCompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f=new filecompress();
				if(textField.getText().equals(""))
				{
				    JOptionPane.showMessageDialog(null,"Please enter the path");
				}
				else
				{
				    int ans=f.FileCompress(textField.getText());
				    if(ans==2)
				    {
				        JOptionPane.showMessageDialog(null, "Compressed file saved in current directory");
				    }
				    else if(ans ==0)
				    {
					    JOptionPane.showMessageDialog(null, "File not Found");
				    }
				    else
					    JOptionPane.showMessageDialog(null, "Empty File");
				}
			}
		});
		btnClickToCompress.setBackground(Color.ORANGE);
		btnClickToCompress.setBounds(200, 347, 221, 42);
		frmTextCompressorBy.getContentPane().add(btnClickToCompress);
		
        btnClickToDecompress = new JButton("Click to Decompress");
		btnClickToDecompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals(""))
				{
				    JOptionPane.showMessageDialog(null,"Please enter the path");
				}
				else
				{
				    int ans=f.FileDecompress(textField.getText());
				    if(ans==3)
				    {
				        JOptionPane.showMessageDialog(null, "Decompressed File saved in current directory");
				    }
				    else if(ans ==0)
				    {
					    JOptionPane.showMessageDialog(null, "File not Found");
				    }
				    else
					    JOptionPane.showMessageDialog(null, "Empty File");
				}
			}
		});
		btnClickToDecompress.setBackground(Color.ORANGE);
		btnClickToDecompress.setBounds(450, 347, 221, 42);
		frmTextCompressorBy.getContentPane().add(btnClickToDecompress);
	}
}