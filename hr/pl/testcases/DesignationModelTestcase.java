import java.awt.*;
import javax.swing.*;
import com.thinking.machines.hr.pl.model.*;
import com.thinking.machines.hr.bl.exceptions.*;

class DesignationModelTestcase extends JFrame
{
private JTable tb;
private DesignationModel designationModel;
private Container container;
private JScrollPane jsp;
DesignationModelTestcase()
{
designationModel=new DesignationModel();
tb=new JTable(designationModel);
jsp=new JScrollPane(tb,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
container=getContentPane();
container.setLayout(new BorderLayout());
if(designationModel!=null)
// without jsp
//container.add(tb.getTableHeader(), BorderLayout.NORTH);
//container.add(tb, BorderLayout.CENTER);

container.add(jsp);
setSize(400,500);
setLocation(100,200);
setVisible(true);
}

public static void main(String gg[])
{
DesignationModelTestcase dmtc=new DesignationModelTestcase();
}
}
