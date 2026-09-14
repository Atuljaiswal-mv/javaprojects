import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import java.util.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;


class Swing1 extends JFrame
{
private JTable table;
private String title[];
private Object data[][];
private Container container;
private JScrollPane jsp;
private Set<DesignationDTOInterface>list;
private DesignationDAOInterface dao;
private int index;
Swing1()
{
populateDataStructure();
table=new JTable(data,title);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
container=getContentPane();
container.add(jsp);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
int width=600;
int height=600;
setSize(width,height);

int x=(d.width/2)-(width/2);
int y=(d.height/2)-(height/2);
setLocation(x,y);
setVisible(true);
}

private void populateDataStructure()
{
title=new String[2];
title[0]="Designation Code";
title[1]="Designation Name";
index=0;
dao=new DesignationDAO();
try
{
list=dao.getAll();
}catch(DAOException exception)
{
System.out.println(exception.getMessage());
}
data=new Object[list.size()][2];
list.forEach((designationDTO)->{
data[index][0]=designationDTO.getCode();
data[index][1]=designationDTO.getTitle();
index++;
});
}
}

class swing1psp
{
public static void main(String gg[])
{
Swing1 sg1=new Swing1();
}
}