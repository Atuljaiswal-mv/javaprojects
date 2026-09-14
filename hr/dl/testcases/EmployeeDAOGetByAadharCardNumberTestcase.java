import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import java.text.*;
import java.math.*;

class EmployeeDAOGetByAadharCardNumberTestcase
{
public static void main(String gg[])
{
String  aadharCardNumber=gg[0];
try
{
EmployeeDTOInterface employeeDTO;
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDTO=employeeDAO.getByAadharCardNumber(aadharCardNumber);
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");

System.out.println("Employee id.: "+employeeDTO.getEmployeeId());
System.out.println("Name :"+employeeDTO.getName());
System.out.println("Designation code : "+employeeDTO.getDesignationCode());
System.out.println("Date of birth : "+simpleDateFormat.format(employeeDTO.getDateOfBirth()));
System.out.println("Gender :"+employeeDTO.getGender());
System.out.println("Is Indian :"+employeeDTO.getIsIndian());
System.out.println("Basic salary :"+employeeDTO.getBasicSalary().toPlainString());
System.out.println("PANNumber :"+employeeDTO.getPANNumber());
System.out.println("Aadhar card Number :"+employeeDTO.getAadharCardNumber());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}
