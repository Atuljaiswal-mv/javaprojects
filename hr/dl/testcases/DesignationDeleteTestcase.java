import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import java.util.*;
class DesignationDeleteTestcase
{
public static void main(String gg[])
{
int code=Integer.parseInt(gg[0]);
try
{
DesignationDAOInterface designationDAO=new DesignationDAO();
DesignationDTOInterface designationDTO=new DesignationDTO();

designationDAO.delete(code);
Set<DesignationDTOInterface>designations;
designations=designationDAO.getAll();
designations.forEach((designation)->{
System.out.printf("code :%d , title :%s\n",designation.getCode(),designation.getTitle());
});
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}

}
}