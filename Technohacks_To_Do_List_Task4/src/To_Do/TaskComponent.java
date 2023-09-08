package To_Do;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;
    private JPanel parentPanel;

    public JTextPane getTaskField() {
        return taskField;
    }

    public TaskComponent(JPanel parentPanel){
        this.parentPanel=parentPanel;
        taskField=new JTextPane();
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskField.setPreferredSize(CommonConstant.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
        checkBox=new JCheckBox();
        checkBox.setPreferredSize(CommonConstant.CHECKBOX_SIZE);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(this);
        deleteButton=new JButton("X");
        deleteButton.setPreferredSize(CommonConstant.DELETE_BUTTON_SIZE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);
        add(checkBox);
        add(taskField);
        add(deleteButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            String taskText=taskField.getText().replaceAll("<[^>]*>","");
            taskField.setText("<html><s>"+ taskText +"</s></html>");
        }
        else if(!checkBox.isSelected()){
            String taskText=taskField.getText().replaceAll("<[^>]*>","");
            taskField.setText(taskText);

        }
        if(e.getActionCommand().equalsIgnoreCase("X")){
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }
}