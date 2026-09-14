import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import java.util.*;
import java.math.*;
import java.text.*;
class EmployeeDAOGetByDesignationCodeTestcase
{
public static void main(String gg[])
{
int designationCode=Integer.parseInt(gg[0]);
try
{
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
Set<EmployeeDTOInterface>employees=employeeDAO.getByDesignationCode(designationCode);
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

for(EmployeeDTOInterface employeeDTO :employees)
{
System.out.println("Employee Id:"+employeeDTO.getEmployeeId());
System.out.println("Name :"+employeeDTO.getName());
System.out.println("Designation code :"+employeeDTO.getDesignationCode());
System.out.println("Date of birth :"+sdf.format(employeeDTO.getDateOfBirth()));
System.out.println("Gender :"+employeeDTO.getGender());
System.out.println("Is Indian :"+employeeDTO.getIsIndian());
System.out.println("PANNumber :"+employeeDTO.getPANNumber());
System.out.println("Aadhar Card Number :"+employeeDTO.getAadharCardNumber());
System.out.println("********************************");
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}

}
}