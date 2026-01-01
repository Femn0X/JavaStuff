import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.random.*;
import java.util.ArrayList;
public class GUI {
    JFrame frame;
    JPanel panel;
    GUI(String title,int width,int hieght,Color color){
        frame=new JFrame(title);
        frame.setSize(width,hieght);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        frame.add(panel);
    }
    public void show(){
        frame.setVisible(true);
    }
    public void addButon(String text,Color fg,Color bg,Font font,int x,int y,int width,int hieght,ActionListener action){
        JButton button=new JButton(text);
        button.setBounds(x,y,width,hieght);
        button.addActionListener(action);
        button.setForeground(fg);
        button.setBackground(bg);
        button.setFont(font);
        
        panel.add(button);
    }
    public void addLabel(String text,Font font,Color fg,int x,int y,int width,int hieght){
        JLabel label=new JLabel(text);
        label.setBounds(x,y,width,hieght);
        label.setFont(font);
        label.setForeground(fg);
        panel.add(label);
    }
}
