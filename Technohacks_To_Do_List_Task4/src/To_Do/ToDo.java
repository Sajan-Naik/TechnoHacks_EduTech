package To_Do;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDo extends JFrame implements ActionListener {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel taskPanel,taskComponentPanel;
    public ToDo(){
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstant.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        addGuiComponents();
    }

    private void addGuiComponents() {
        JLabel bannerLabel= new JLabel("To Do-List");
        bannerLabel.setBounds((CommonConstant.GUI_SIZE.width-bannerLabel.getPreferredSize().width)/2, 15, CommonConstant.BANNER_SIZE.width, CommonConstant.BANNER_SIZE.height);
        taskPanel=new JPanel();
        taskComponentPanel=new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        JScrollPane scrollPane=new JScrollPane(taskPanel);
        scrollPane.setBounds(8,70,CommonConstant.TASKPANEL_SIZE.width,CommonConstant.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(CommonConstant.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        JButton addTaskButton=new JButton("Add Task");
        addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addTaskButton.setBounds(-5,CommonConstant.GUI_SIZE.height-88,CommonConstant.ADDTASK_BUTTONSIZE.width,CommonConstant.ADDTASK_BUTTONSIZE.height);
        addTaskButton.addActionListener(this);
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if (command.equalsIgnoreCase("Add Task")){
            TaskComponent taskComponent=new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);
            if(taskComponentPanel.getComponentCount()>1){
                TaskComponent previousTask=(TaskComponent)taskComponentPanel.getComponent(taskComponentPanel.getComponentCount()-2);
                previousTask.getTaskField().setBackground(null);
            }
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }
    }
}