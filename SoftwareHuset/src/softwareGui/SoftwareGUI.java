package softwareGui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import softwareApp.*;
import softwarePersistence.*;
@SuppressWarnings("serial")
public class SoftwareGUI extends JFrame implements ActionListener
{
	private static SoftwareGUI window;
	public  static JTextArea textLogin, textProject, textProjectName;
	public static JTextArea textUsername, textEx,textStartDay, textStartMonth, textStartYear,textEndDay, textEndMonth, textEndYear;
	public static JLabel labelLogin, labelExpected, labelEndDate,labelStartDate, labelAddProjectError;
	public static JLabel labelLoginError, labelRegister, labelRegiError,labelActName;
	public static JButton buttonLogin, buttonProject, buttonAddUser, buttonAddProject, button3, button4, buttonAdd, buttonAddUserGui;
	public static JButton buttonAddProjQ, buttonAddUsertoActQuit, button5, buttonAddUsertoAct, buttonAddProject1, buttonAddUserQuit, buttonAddActivity1, buttonAddActQ;
	public static JPanel paneAddProject, paneAddButtons, paneEnd, paneStart, paneLogin, paneproject, paneSproject, panebuttons, paneAdd, paneLoginText, paneRegiText;
	private static DefaultListModel<String> listProjectGUI, listAktivityGUI;
	private static JTextArea textActStartDay, textUsernameToAdd, textActName, textActStartMonth, textActStartYear, textActEx, textActEndYear, textActEndMonth, textActEndDay;
	public static JList<String> projectListGUI, aktivityListGUI;
	public static JScrollPane scrollpane, scrollpane1;	
	private static JPanel paneActStart, paneActEnd;
	private static JLabel labelActStartDate, labelAddActError, labelActEndDate, labelActExpected, labelAddActivityError;
	static Dimension textAreasize = new Dimension(300,30);
	static Dimension buttonsize = new Dimension(150,70);
	static Dimension scrollsize = new Dimension(300,300);
	static Dimension textDaysize = new Dimension(40,30);
	static Dimension textYearsize = new Dimension(80,30);
	int ww, w;
	
	public SoftwareGUI() 
	{
		drawlogin();
	}
	
	public void drawAdduserToActivity()
	{
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(1,5));
		window.setTitle("Add user to activity");
		window.setSize(800,300);
		
		textUsernameToAdd = new JTextArea();
		textUsernameToAdd.setEditable(true);
		textUsernameToAdd.setMaximumSize(textAreasize);
		textUsernameToAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel labelAddUserToAct = new JLabel("Type username of new user");
		labelAddUserToAct.setMaximumSize(textAreasize);
		labelAddUserToAct.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelAddActError = new JLabel("");
		labelAddActError.setMaximumSize(textAreasize);
		labelAddActError.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		buttonAddUsertoAct = new JButton("Add User");
		buttonAddUsertoAct.addActionListener(this);
		buttonAddUsertoAct.setMaximumSize(buttonsize);
		buttonAddUsertoAct.setAlignmentX(Component.CENTER_ALIGNMENT);

		buttonAddUsertoActQuit = new JButton("Back");
		buttonAddUsertoActQuit.addActionListener(this);
		buttonAddUsertoActQuit.setMaximumSize(buttonsize);
		buttonAddUsertoActQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel paneAddButtons1 = new JPanel();
		paneAddButtons1.setLayout(new BoxLayout(paneAddButtons1, BoxLayout.X_AXIS));
		paneAddButtons1.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButtons1.add(buttonAddUsertoAct);
		paneAddButtons1.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButtons1.add(buttonAddUsertoActQuit);
		paneAddButtons1.add(Box.createRigidArea(new Dimension(20,5)));
		
		JPanel paneAddtoActText = new JPanel();
		paneAddtoActText.setLayout(new BoxLayout(paneAddtoActText, BoxLayout.Y_AXIS));
		paneAddtoActText.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddtoActText.add(labelAddUserToAct);
		paneAddtoActText.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddtoActText.add(textUsernameToAdd);
		paneAddtoActText.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddtoActText.add(labelAddActError);
		paneAddtoActText.add(Box.createRigidArea(new Dimension(20,5)));
		
		JPanel paneAddtoAct = new JPanel();
		paneAddtoAct.setLayout(new BoxLayout(paneAddtoAct, BoxLayout.X_AXIS));
		paneAddtoAct.add(Box.createRigidArea(new Dimension(60,5)));
		paneAddtoAct.add(paneAddtoActText);
		paneAddtoAct.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddtoAct.add(paneAddButtons1);
		paneAddtoAct.add(Box.createRigidArea(new Dimension(20,5)));
		
		getContentPane().add(paneAddtoAct, BorderLayout.CENTER);
		getContentPane().revalidate();
	}
	
	public void drawAddActivity()
	{
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(1,5));
		
		window.setSize(400,400);
		
		textActStartDay = new JTextArea();
		textActStartDay.setEditable(true);
		textActStartDay.setMaximumSize(textDaysize);
		textActStartDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textActStartMonth = new JTextArea();
		textActStartMonth.setEditable(true);
		textActStartMonth.setMaximumSize(textDaysize);
		textActStartMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textActStartYear = new JTextArea();
		textActStartYear.setEditable(true);
		textActStartYear.setMaximumSize(textYearsize);
		textActStartYear.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		paneActStart = new JPanel();
		paneActStart.setLayout(new BoxLayout(paneActStart, BoxLayout.X_AXIS));
		paneActStart.add(Box.createRigidArea(new Dimension(20,5)));
		paneActStart.add(textActStartDay);
		paneActStart.add(Box.createRigidArea(new Dimension(20,5)));
		paneActStart.add(textActStartMonth);
		paneActStart.add(Box.createRigidArea(new Dimension(20,5)));
		paneActStart.add(textActStartYear);
		paneActStart.add(Box.createRigidArea(new Dimension(20,5)));
		
		labelActStartDate = new JLabel("Start date dd mm yyyy");
		labelActStartDate.setMaximumSize(textAreasize);
		labelActStartDate.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelActEndDate = new JLabel("End date dd mm yyyy");
		labelActEndDate.setMaximumSize(textAreasize);
		labelActEndDate.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelActExpected = new JLabel("Expected time on Activity");
		labelActExpected.setMaximumSize(textAreasize);
		labelActExpected.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelAddActivityError = new JLabel("");
		labelAddActivityError.setMaximumSize(textAreasize);
		labelAddActivityError.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textActEndDay = new JTextArea();
		textActEndDay.setEditable(true);
		textActEndDay.setMaximumSize(textDaysize);
		textActEndDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textActEndMonth = new JTextArea();
		textActEndMonth.setEditable(true);
		textActEndMonth.setMaximumSize(textDaysize);
		textActEndMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textActEndYear = new JTextArea();
		textActEndYear.setEditable(true);
		textActEndYear.setMaximumSize(textYearsize);
		textActEndYear.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		paneActEnd = new JPanel();
		paneActEnd.setLayout(new BoxLayout(paneActEnd, BoxLayout.X_AXIS));
		paneActEnd.add(Box.createRigidArea(new Dimension(20,5)));
		paneActEnd.add(textActEndDay);
		paneActEnd.add(Box.createRigidArea(new Dimension(20,5)));
		paneActEnd.add(textActEndMonth);
		paneActEnd.add(Box.createRigidArea(new Dimension(20,5)));
		paneActEnd.add(textActEndYear);
		paneActEnd.add(Box.createRigidArea(new Dimension(20,5)));
		
		textActEx = new JTextArea();
		textActEx.setEditable(true);
		textActEx.setMaximumSize(textYearsize);
		textActEx.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		buttonAddActivity1 = new JButton("Add Activity");
		buttonAddActivity1.addActionListener(this);
		buttonAddActivity1.setMaximumSize(buttonsize);
		buttonAddActivity1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		buttonAddActQ = new JButton("Back");
		buttonAddActQ.addActionListener(this);
		buttonAddActQ.setMaximumSize(buttonsize);
		buttonAddActQ.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JPanel paneAddButton1 = new JPanel();
		paneAddButton1.setLayout(new BoxLayout(paneAddButton1, BoxLayout.Y_AXIS));
		paneAddButton1.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButton1.add(buttonAddActivity1);
		paneAddButton1.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButton1.add(buttonAddActQ);
		paneAddButton1.add(Box.createRigidArea(new Dimension(20,5)));
		
		textActName = new JTextArea();
		textActName.setEditable(true);
		textActName.setMaximumSize(textAreasize);
		textActName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelActName = new JLabel("Name on activity");
		labelActName.setMaximumSize(textAreasize);
		labelActName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		paneAddProject = new JPanel();
		paneAddProject.setLayout(new BoxLayout(paneAddProject, BoxLayout.Y_AXIS));
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelActName);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(textActName);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelActStartDate);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(paneActStart);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelActEndDate);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(paneActEnd);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelActExpected);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(textActEx);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelAddActivityError);
		
		getContentPane().add(paneAddProject, BorderLayout.CENTER);
		getContentPane().add(paneAddButton1, BorderLayout.EAST);
		getContentPane().revalidate();
		
	}
	
	public void drawAddProject()
	{
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(1,5));
		
		window.setSize(400,400);
		
		textStartDay = new JTextArea();
		textStartDay.setEditable(true);
		textStartDay.setMaximumSize(textDaysize);
		textStartDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textStartMonth = new JTextArea();
		textStartMonth.setEditable(true);
		textStartMonth.setMaximumSize(textDaysize);
		textStartMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textStartYear = new JTextArea();
		textStartYear.setEditable(true);
		textStartYear.setMaximumSize(textYearsize);
		textStartYear.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		paneStart = new JPanel();
		paneStart.setLayout(new BoxLayout(paneStart, BoxLayout.X_AXIS));
		paneStart.add(Box.createRigidArea(new Dimension(20,5)));
		paneStart.add(textStartDay);
		paneStart.add(Box.createRigidArea(new Dimension(20,5)));
		paneStart.add(textStartMonth);
		paneStart.add(Box.createRigidArea(new Dimension(20,5)));
		paneStart.add(textStartYear);
		paneStart.add(Box.createRigidArea(new Dimension(20,5)));
		
		labelStartDate = new JLabel("Start date dd mm yyyy");
		labelStartDate.setMaximumSize(textAreasize);
		labelStartDate.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelEndDate = new JLabel("End date dd mm yyyy");
		labelEndDate.setMaximumSize(textAreasize);
		labelEndDate.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelExpected = new JLabel("Expected time on Project");
		labelExpected.setMaximumSize(textAreasize);
		labelExpected.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelAddProjectError = new JLabel("");
		labelAddProjectError.setMaximumSize(textAreasize);
		labelAddProjectError.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textEndDay = new JTextArea();
		textEndDay.setEditable(true);
		textEndDay.setMaximumSize(textDaysize);
		textEndDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textEndMonth = new JTextArea();
		textEndMonth.setEditable(true);
		textEndMonth.setMaximumSize(textDaysize);
		textEndMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textEndYear = new JTextArea();
		textEndYear.setEditable(true);
		textEndYear.setMaximumSize(textYearsize);
		textEndYear.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		paneEnd = new JPanel();
		paneEnd.setLayout(new BoxLayout(paneEnd, BoxLayout.X_AXIS));
		paneEnd.add(Box.createRigidArea(new Dimension(20,5)));
		paneEnd.add(textEndDay);
		paneEnd.add(Box.createRigidArea(new Dimension(20,5)));
		paneEnd.add(textEndMonth);
		paneEnd.add(Box.createRigidArea(new Dimension(20,5)));
		paneEnd.add(textEndYear);
		paneEnd.add(Box.createRigidArea(new Dimension(20,5)));
		
		textEx = new JTextArea();
		textEx.setEditable(true);
		textEx.setMaximumSize(textYearsize);
		textEx.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		buttonAddProject1 = new JButton("Add project");
		buttonAddProject1.addActionListener(this);
		buttonAddProject1.setMaximumSize(buttonsize);
		buttonAddProject1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		buttonAddProjQ = new JButton("Back");
		buttonAddProjQ.addActionListener(this);
		buttonAddProjQ.setMaximumSize(buttonsize);
		buttonAddProjQ.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JPanel paneAddButton = new JPanel();
		paneAddButton.setLayout(new BoxLayout(paneAddButton, BoxLayout.Y_AXIS));
		paneAddButton.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButton.add(buttonAddProject1);
		paneAddButton.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButton.add(buttonAddProjQ);
		paneAddButton.add(Box.createRigidArea(new Dimension(20,5)));
		
		paneAddProject = new JPanel();
		paneAddProject.setLayout(new BoxLayout(paneAddProject, BoxLayout.Y_AXIS));
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelStartDate);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(paneStart);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelEndDate);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(paneEnd);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelExpected);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(textEx);
		paneAddProject.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddProject.add(labelAddProjectError);
		
		getContentPane().add(paneAddProject, BorderLayout.CENTER);
		getContentPane().add(paneAddButton, BorderLayout.EAST);
		getContentPane().revalidate();
		
	}
	
	public void drawlogin()
	{
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(1,5));
		
		
		textLogin = new JTextArea();
		textLogin.setEditable(true);
		textLogin.setMaximumSize(textAreasize);
		textLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelLogin = new JLabel("Login: Write your User Name");
		labelLogin.setMaximumSize(textAreasize);
		labelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelLoginError = new JLabel("");
		labelLoginError.setMaximumSize(textAreasize);
		labelLoginError.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(this);
		buttonLogin.setMaximumSize(buttonsize);
		buttonLogin.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		paneLoginText = new JPanel();
		paneLoginText.setLayout(new BoxLayout(paneLoginText, BoxLayout.Y_AXIS));
		paneLoginText.add(Box.createRigidArea(new Dimension(20,5)));
		paneLoginText.add(labelLogin);
		paneLoginText.add(Box.createRigidArea(new Dimension(20,5)));
		paneLoginText.add(textLogin);
		paneLoginText.add(Box.createRigidArea(new Dimension(20,5)));
		paneLoginText.add(labelLoginError);
		paneLoginText.add(Box.createRigidArea(new Dimension(20,5)));
		
		paneLogin = new JPanel();
		paneLogin.setLayout(new BoxLayout(paneLogin, BoxLayout.X_AXIS));
		paneLogin.add(Box.createRigidArea(new Dimension(20,5)));
		paneLogin.add(paneLoginText);
		paneLogin.add(Box.createRigidArea(new Dimension(20,5)));
		paneLogin.add(buttonLogin);
		paneLogin.add(Box.createRigidArea(new Dimension(20,5)));
		
		
		
		getContentPane().add(paneLogin, BorderLayout.CENTER);
		getContentPane().revalidate();
	}
	
	private void addElementsProjektList() 
	{
		listProjectGUI.removeAllElements();
		
		for (int i = 0; i<projectManagement.projectList.size();i++)
		{
			String toadd = projectManagement.projectList.get(i).name;
			listProjectGUI.addElement(toadd);
		}
	}
	
	private void addElemtsActivityList(int w)
	{
		listAktivityGUI.removeAllElements();
		
		for (int i = 0; i<projectManagement.projectList.get(w).activities.size();i++)
		{
			String toadd = projectManagement.projectList.get(w).activities.get(i).name;
			listAktivityGUI.addElement(toadd);
		}
	}
	
	public void drawGUI()
	{
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(1,5));
		
		window.setSize(500,600);
		
		listProjectGUI = new DefaultListModel<>();
		listAktivityGUI = new DefaultListModel<>();
		addElementsProjektList();
		
		projectListGUI = new JList<>(listProjectGUI);
		projectListGUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		projectListGUI.addListSelectionListener(projectSelection);
		
		aktivityListGUI = new JList<>(listAktivityGUI);
		aktivityListGUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aktivityListGUI.addListSelectionListener(activitySelection);

		scrollpane = new JScrollPane(projectListGUI);
		scrollpane.setMaximumSize(scrollsize);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollpane1 = new JScrollPane(aktivityListGUI);
		scrollpane1.setMaximumSize(scrollsize);
		scrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		paneproject = new JPanel();
		paneproject.setLayout(new BoxLayout(paneproject, BoxLayout.Y_AXIS));
		paneproject.add(Box.createRigidArea(new Dimension(5,20)));
		paneproject.add(scrollpane);
		paneproject.add(Box.createRigidArea(new Dimension(5,20)));
		paneproject.add(scrollpane1);
		paneproject.add(Box.createRigidArea(new Dimension(5,60)));
		
		buttonAddUserGui = new JButton("Add user");
		buttonAddUserGui.addActionListener(this);
		buttonAddUserGui.setMaximumSize(buttonsize);
		buttonAddUserGui.setAlignmentX(Component.RIGHT_ALIGNMENT);

		buttonAddProject = new JButton("Add project");
		buttonAddProject.addActionListener(this);
		buttonAddProject.setMaximumSize(buttonsize);
		buttonAddProject.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		button3 = new JButton("Add activity");
		button3.setEnabled(false);
		button3.addActionListener(this);
		button3.setMaximumSize(buttonsize);
		button3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		button4 = new JButton("Log out");
		button4.addActionListener(this);
		button4.setMaximumSize(buttonsize);
		button4.setAlignmentX(Component.RIGHT_ALIGNMENT);

		button5 = new JButton("Add user to Activity");
		button5.setEnabled(false);
		button5.addActionListener(this);
		button5.setMaximumSize(buttonsize);
		button5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		panebuttons = new JPanel();
		panebuttons.setLayout(new BoxLayout(panebuttons, BoxLayout.Y_AXIS));
		panebuttons.add(Box.createRigidArea(new Dimension(5,60)));
		panebuttons.add(buttonAddUserGui);
		panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
		panebuttons.add(buttonAddProject);
		panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
		panebuttons.add(button3);
		panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
		panebuttons.add(button5);
		panebuttons.add(Box.createRigidArea(new Dimension(5,20)));
		panebuttons.add(button4);
		panebuttons.add(Box.createRigidArea(new Dimension(5,60)));
		
		getContentPane().add(paneproject, BorderLayout.CENTER);
		getContentPane().add(panebuttons, BorderLayout.EAST);
		getContentPane().revalidate();
	}
	
	ListSelectionListener projectSelection = new ListSelectionListener()
	{
		public void valueChanged(ListSelectionEvent listSelectionEvent)
		{

			ww =projectListGUI.getSelectedIndex();
			if (ww >=0)
			{
				button3.setEnabled(true);
				addElemtsActivityList(ww);
				
			}
			
		}
	};
	
	ListSelectionListener activitySelection = new ListSelectionListener()
	{
		public void valueChanged(ListSelectionEvent listSelectionEvent)
		{

			w =aktivityListGUI.getSelectedIndex();
			if (w >=0)
			{
				button5.setEnabled(true);
			}
			
		}
	};
	
	public void drawAdduser()
	{
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(1,5));
		window.setTitle("Add User");
		window.setSize(800,300);
		
		textUsername = new JTextArea();
		textUsername.setEditable(true);
		textUsername.setMaximumSize(textAreasize);
		textUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelRegister = new JLabel("Type username of new user");
		labelRegister.setMaximumSize(textAreasize);
		labelRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		labelRegiError = new JLabel("");
		labelRegiError.setMaximumSize(textAreasize);
		labelRegiError.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		buttonAddUser = new JButton("Add User");
		buttonAddUser.addActionListener(this);
		buttonAddUser.setMaximumSize(buttonsize);
		buttonAddUser.setAlignmentX(Component.CENTER_ALIGNMENT);

		buttonAddUserQuit = new JButton("Back");
		buttonAddUserQuit.addActionListener(this);
		buttonAddUserQuit.setMaximumSize(buttonsize);
		buttonAddUserQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		paneAddButtons = new JPanel();
		paneAddButtons.setLayout(new BoxLayout(paneAddButtons, BoxLayout.X_AXIS));
		paneAddButtons.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButtons.add(buttonAddUser);
		paneAddButtons.add(Box.createRigidArea(new Dimension(20,5)));
		paneAddButtons.add(buttonAddUserQuit);
		paneAddButtons.add(Box.createRigidArea(new Dimension(20,5)));
		
		paneRegiText = new JPanel();
		paneRegiText.setLayout(new BoxLayout(paneRegiText, BoxLayout.Y_AXIS));
		paneRegiText.add(Box.createRigidArea(new Dimension(20,5)));
		paneRegiText.add(labelRegister);
		paneRegiText.add(Box.createRigidArea(new Dimension(20,5)));
		paneRegiText.add(textUsername);
		paneRegiText.add(Box.createRigidArea(new Dimension(20,5)));
		paneRegiText.add(labelRegiError);
		paneRegiText.add(Box.createRigidArea(new Dimension(20,5)));
		
		paneAdd = new JPanel();
		paneAdd.setLayout(new BoxLayout(paneAdd, BoxLayout.X_AXIS));
		paneAdd.add(Box.createRigidArea(new Dimension(60,5)));
		paneAdd.add(paneRegiText);
		paneAdd.add(Box.createRigidArea(new Dimension(20,5)));
		paneAdd.add(paneAddButtons);
		paneAdd.add(Box.createRigidArea(new Dimension(20,5)));
		
		getContentPane().add(paneAdd, BorderLayout.CENTER);
		getContentPane().revalidate();
	}
	
	public static void main(String[] args) 
	{
		window = new SoftwareGUI();

		window.setTitle("Login");
		window.setSize(500,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		//The project with vacation, courses and sickness activities
		projectManagement.createDefaultProject();
		//Spawning test data. Executing phase shift
		testData.projectData();
		testData.activityData();
		testData.userData();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == buttonLogin)
		{ 
			try {
				UserLogin.loginUser(textLogin.getText());
				drawGUI();
			}
			catch(Exception e1)
			{
				labelLoginError.setText(e1.getMessage());
				
			}	
		}
		if (e.getSource() == buttonAddUserGui)
		{
			drawAdduser();
		}
		if (e.getSource() == buttonAddUser)
		{
			try {
			UserLogin.registerUser(textUsername.getText());
			drawGUI();	
			} catch (Exception e1) 
			{
				labelRegiError.setText(e1.getMessage());
			}
		}
		if (e.getSource() == buttonAddProject)
		{
			drawAddProject();
		}
		if (e.getSource() == buttonAddProjQ)
		{
			drawGUI();
		}
		if (e.getSource() == buttonAddProject1)
		{
			try {
				AddProject.addProjectToSystem(textStartDay.getText(), textStartMonth.getText(),
						textStartYear.getText(),textEndDay.getText(),
						textEndMonth.getText(), textEndYear.getText(), textEx.getText());
				drawGUI();
			} catch (Exception e1)
			{
				labelAddProjectError.setText(e1.getMessage());
			}
		}
		if (e.getSource() == buttonAddUserQuit)
		{
			drawGUI();
		}
		if (e.getSource() == button4)
		{
			drawlogin();
		}
		if (e.getSource() == button3)
		{
			drawAddActivity();
		}
		if (e.getSource() == buttonAddActivity1)
		{
			try {
				AddActivity.addActivityToProject(ww, Integer.parseInt(textActEx.getText()),
						textActName.getText(),textActStartDay.getText(),
						textActStartMonth.getText(), textActStartYear.getText(),
						textActEndDay.getText(), textActEndMonth.getText(),
						textActEndYear.getText());
				drawGUI();
			} catch (Exception e1) {
				labelAddActivityError.setText(e1.getMessage());
			}
		}
		if (e.getSource() == buttonAddActQ)
		{
			drawGUI();
		}
		if (e.getSource() == button5)
		{
			drawAdduserToActivity();
		}
		if (e.getSource() == buttonAddUsertoActQuit)
		{
			drawGUI();
		}
		if (e.getSource() == buttonAddUsertoAct)
		{
			try {
				AddUserToActivity.addUserToActivity(ww, w, textUsernameToAdd.getText());
				drawGUI();
			} catch (Exception e1) {
				labelAddActError.setText(e1.getMessage());
			}
		}
	}
	
}
