import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;


class DesignationAddTestcase
{
public static void main(String gg[])
{
String title=gg[0];

try
{
DesignationDTOInterface designationDTO=new DesignationDTO();
DesignationDAOInterface designationDAO=new DesignationDAO(); 
designationDTO.setTitle(title);

designationDAO.add(designationDTO);
System.out.println("Designation :"+title+" added with code :"+designationDTO.getCode());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}

}
}