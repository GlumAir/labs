import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class WordCounter implements ActionListener{

		JFrame f;
	    JPanel p, count_panel, button_panel;
	    JLabel count_text;
	    JTextArea tf;
	    JScrollPane scrollPane;
	    JButton word_count, char_count, paragraph_count;
	
	
    public WordCounter() {
    	 f = new JFrame("WordCounter - Arroyo, Ambrad, Riego");
         p = new JPanel(new BorderLayout()); 
         count_panel = new JPanel(new BorderLayout());
         button_panel = new JPanel();
         count_text = new JLabel("ALL IN ONE COUNTER: Words, Characters, Paragraphs");
         tf = new JTextArea();
         scrollPane = new JScrollPane(tf);
         word_count = new JButton("Count Words");
         char_count = new JButton("Count Characters");
         paragraph_count = new JButton("Count Paragraphs");
        
        
        f.setSize(new Dimension(800,850));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        
        p.setBackground(new Color(141,216,255)); 
        count_panel.setOpaque(false);
        button_panel.setOpaque(false);
  
        count_text.setBackground(new Color(25,25,25));
        count_text.setForeground(new Color(25,255,0));
        count_text.setFont(new Font("Arial", Font.BOLD, 25));
        count_text.setHorizontalAlignment(JLabel.CENTER);
        count_text.setOpaque(true);
        
        
        count_panel.setPreferredSize(new Dimension(f.getWidth(), 50));
        count_panel.add(count_text, BorderLayout.CENTER);
        
        
        tf.setLineWrap(true);
        tf.setWrapStyleWord(true);
        tf.setFont(new Font("Arial", Font.PLAIN, 20));
        

        scrollPane.setPreferredSize(new Dimension(f.getWidth(), f.getHeight() / 2));
        
        
        // Buttons
        word_count.setFocusable(false);
        char_count.setFocusable(false);
        paragraph_count.setFocusable(false);
        
        
        word_count.setFont(new Font("Arial", Font.PLAIN, 30));
        word_count.setBackground(Color.WHITE);
        char_count.setFont(new Font("Arial", Font.PLAIN, 30));
        char_count.setBackground(Color.WHITE);
        paragraph_count.setFont(new Font("Arial", Font.PLAIN, 30));
        paragraph_count.setBackground(Color.WHITE);
   
       
        word_count.addActionListener(this);
        char_count.addActionListener(this);
        paragraph_count.addActionListener(this);
        
        button_panel.setLayout(new FlowLayout());
        button_panel.add(word_count);
        button_panel.add(char_count);
        button_panel.add(paragraph_count);
   
        
        // Adding components
        
        p.add(count_panel, BorderLayout.SOUTH);
        p.add(button_panel);
        p.add(scrollPane, BorderLayout.NORTH);
        f.add(p);
       
        
        f.setVisible(true);
    }
	
    
    public void actionPerformed(ActionEvent e) {
   
    	if(e.getSource() == word_count) {
    		String text = tf.getText();
    		int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
    		count_text.setText("Total Words: " + wordCount);
    	}
    	
    	if(e.getSource() == char_count) {
    		String text = tf.getText();
    		int charCount = text.length();
    		count_text.setText("Total Characters: " + charCount);
    	}
    	
    	if(e.getSource() == paragraph_count) {
    		String text = tf.getText();
    		int paragraphCount = text.trim().isEmpty() ? 0 : text.trim().split("\n+").length;
    		count_text.setText("Total Paragraphs: " + paragraphCount);
    	}
    	 	
    }
   
	
}
