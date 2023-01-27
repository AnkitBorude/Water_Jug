package files;
import javax.swing.*;
import java.awt.event.*;
class MainFrame extends JFrame implements ActionListener
{
	JTextField total;
	JButton jb;
	MainFrame()
	{
		total=new JTextField();
		jb=new JButton("Submit");
		total.setBounds(20,20,200,20);
		jb.setBounds(250,20,100,20);
		jb.addActionListener(this);
		add(total);
		add(jb);
		
	}
	void generateBoxes(int box)
	{
		JTextField f1,f2;
		JPanel panel=new JPanel();
		for(int i=0;i<box;i++)
		{
			f1=new JTextField();
			f2=new JTextField();
			f1.setBounds(20,80+(i*30),80,20);
			f2.setBounds(200,80+(i*30),80,20);
			panel.add(f1);
			panel.add(f2);
		}
		panel.setLayout(null);
		panel.setSize(200,200);
		add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb))
		{
			int totalb=Integer.parseInt(total.getText());
			generateBoxes(totalb);
		}
	}
}
public class Frontend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame=new MainFrame();
		frame.setLayout(null);
		frame.setSize(480,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
