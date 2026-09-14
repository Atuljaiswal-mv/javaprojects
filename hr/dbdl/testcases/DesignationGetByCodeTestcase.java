import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;

class DesignationGetByCode
{
public static void main(String gg[])
{
int code;
try {
           code = Integer.parseInt(gg[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid code format. Please enter a numeric value.");
            return;
        }
try
{
DesignationDTOInterface designationDTO;
DesignationDAO designationDAO=new DesignationDAO();
designationDTO=designationDAO.getByCode(code);
System.out.printf("code :%d , title :%s\n",designationDTO.getCode(),designationDTO.getTitle());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}

}
}