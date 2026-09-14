import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import java.util.*;
class DesignationGetAllTestcase
{
public static void main(String gg[])
{
try
{

DesignationDAOInterface designationDAO=new DesignationDAO();
Set<DesignationDTOInterface>designations=designationDAO.getAll();
designations.forEach((designationDTO)->{
System.out.printf("code : %d , title :%s\n",designationDTO.getCode(),designationDTO.getTitle());
});
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}

}
}