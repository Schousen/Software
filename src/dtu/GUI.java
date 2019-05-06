package dtu;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame implements ActionListener
{

    private static GUI window;
    public JTextArea textLogin, textProject;
    public JButton ButtonLogin, ButtonProject, button1, button2, button3, button4;
    public JPanel paneLogin, paneproject, paneSproject, panebuttons;
    private DefaultListModel<String> listProject, listAktivity;
    public JList<String> projectList, aktivityList;
    public JScrollPane scrollpane, scrollpane1;
    public int ww;

    Dimension textAreasize = new Dimension(300,30);
    Dimension buttonsize = new Dimension(150,70);
    Dimension scrollsize = new Dimension(300,300);

    public GUI()
    {
        drawlogin();
    }

    public void drawlogin()
    {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout(1,5));


        textLogin = new JTextArea();
        textLogin.setEditable(true);
        textLogin.setMaximumSize(textAreasize);
        textLogin.setAlignmentX(Component.CENTER_ALIGNMENT);


        ButtonLogin = new JButton("Login");
        ButtonLogin.addActionListener(this);
        ButtonLogin.setMaximumSize(buttonsize);
        ButtonLogin.setAlignmentX(Component.RIGHT_ALIGNMENT);

        paneLogin = new JPanel();
        paneLogin.setLayout(new BoxLayout(paneLogin, BoxLayout.X_AXIS));
        paneLogin.add(Box.createRigidArea(new Dimension(60,5)));
        paneLogin.add(textLogin);
        paneLogin.add(Box.createRigidArea(new Dimension(20,5)));
        paneLogin.add(ButtonLogin);
        paneLogin.add(Box.createRigidArea(new Dimension(20,5)));

        getContentPane().add(paneLogin, BorderLayout.CENTER);
        getContentPane().revalidate();
    }

    public void drawGUI()
    {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout(1,5));

        window.setSize(400,600);

        listProject = new DefaultListModel<>();
        listAktivity = new DefaultListModel<>();

        projectList = new JList<>(listProject);
        projectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //projectList.addListSelectionListener(mailSelection);

        aktivityList = new JList<>(listAktivity);
        aktivityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //aktivityList.addListSelectionListener(mailSelection);

        scrollpane = new JScrollPane(projectList);
        scrollpane.setMaximumSize(scrollsize);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollpane1 = new JScrollPane(aktivityList);
        scrollpane1.setMaximumSize(scrollsize);
        scrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textProject = new JTextArea();
        textProject.setEditable(true);
        textProject.setMaximumSize(textAreasize);
        textProject.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonProject = new JButton("Search Projects");
        ButtonProject.addActionListener(this);
        ButtonProject.setMaximumSize(buttonsize);
        ButtonProject.setAlignmentX(Component.RIGHT_ALIGNMENT);

        paneSproject = new JPanel();
        paneSproject.setLayout(new BoxLayout(paneSproject, BoxLayout.X_AXIS));
        paneSproject.add(Box.createRigidArea(new Dimension(60,5)));
        paneSproject.add(textProject);
        paneSproject.add(Box.createRigidArea(new Dimension(20,5)));
        paneSproject.add(ButtonProject);
        paneSproject.add(Box.createRigidArea(new Dimension(20,5)));

        paneproject = new JPanel();
        paneproject.setLayout(new BoxLayout(paneproject, BoxLayout.Y_AXIS));
        paneproject.add(Box.createRigidArea(new Dimension(5,60)));
        paneproject.add(paneSproject);
        paneproject.add(Box.createRigidArea(new Dimension(5,20)));
        paneproject.add(scrollpane);
        paneproject.add(Box.createRigidArea(new Dimension(5,20)));
        paneproject.add(scrollpane1);
        paneproject.add(Box.createRigidArea(new Dimension(5,60)));

        button1 = new JButton("button1");
        button1.addActionListener(this);
        button1.setMaximumSize(buttonsize);
        button1.setAlignmentX(Component.RIGHT_ALIGNMENT);

        button2 = new JButton("button1");
        button2.addActionListener(this);
        button2.setMaximumSize(buttonsize);
        button2.setAlignmentX(Component.RIGHT_ALIGNMENT);

        button3 = new JButton("button1");
        button3.addActionListener(this);
        button3.setMaximumSize(buttonsize);
        button3.setAlignmentX(Component.RIGHT_ALIGNMENT);

        button4 = new JButton("button1");
        button4.addActionListener(this);
        button4.setMaximumSize(buttonsize);
        button4.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panebuttons = new JPanel();
        panebuttons.setLayout(new BoxLayout(panebuttons, BoxLayout.Y_AXIS));
        panebuttons.add(Box.createRigidArea(new Dimension(5,60)));
        panebuttons.add(button1);
        panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
        panebuttons.add(button2);
        panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
        panebuttons.add(button3);
        panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
        panebuttons.add(button4);
        panebuttons.add(Box.createRigidArea(new Dimension(5,60)));

        getContentPane().add(paneproject, BorderLayout.CENTER);
        getContentPane().add(panebuttons, BorderLayout.EAST);
        getContentPane().revalidate();





    }
	/*
	ListSelectionListener mailSelection = new ListSelectionListener()
	{
		public void valueChanged(ListSelectionEvent listSelectionEvent)
		{

			ww =mailList.getSelectedIndex();
			if (ww >=0)
			{

				String[] mailContent =fileToString(klientPath+"\\"+mailList.getModel().getElementAt(ww)+".txt").split("---");
				buttonSendMail.setEnabled(false);
				textAreaMail.setText("");
				textFieldReceiver.setText("");
				textFieldCC.setText("");
				textFieldTopic.setText("");
				textAreaMail.append("Sent at "+mailContent[mailContent.length-3]+"\n"+"\n");

				textFieldReceiver.setText(mailContent[0].substring(6));
				textFieldTopic.setText(mailContent[3].substring(9));
				for (int j = 4;j<mailContent.length;j++)
				{
					textAreaMail.append(mailContent[j].replaceAll(":::", "\n"));
				}

			}

		}
	};
	*/

    public static void main(String[] args)
    {
        window = new GUI();

        window.setTitle("Login");
        window.setSize(600,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);


        setup();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ButtonLogin)
        {
            drawGUI();
        }
    }
    private static String userDataPath = System.getProperty("user.home") + "\\Desktop\\Java filer\\ServerDir\\users";
    public static void setup()
    {
        new File(userDataPath).mkdirs();
    }

}
