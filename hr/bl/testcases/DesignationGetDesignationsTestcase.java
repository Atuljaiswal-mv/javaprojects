import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.managers.*;
import java.util.*;

class DesignationGetDesignationsTestcase
{
public static void main(String gg[])
{
try
{
Set<DesignationInterface>designations;
DesignationManagerInterface designationManager=DesignationManager.getDesignationManager();
designations=designationManager.getDesignations();
for(DesignationInterface designation :designations)
{
System.out.println("Code :"+designation.getCode()+", Title :"+designation.getTitle());
}
}catch(BLException bl)
{

}
}
}