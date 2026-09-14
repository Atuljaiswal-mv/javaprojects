import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;

class EmployeeManagerGetEmployeeByEmployeeIdTestcase
{
public static void main(String args[])
{
try
{
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
String employeeId="A10000004";
EmployeeManagerInterface employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee=employeeManager.getEmployeeByEmployeeId(employeeId);
System.out.println("employee id.:"+employee.getEmployeeId());
System.out.println("Name :"+employee.getName());
DesignationInterface designation=employee.getDesignation();
System.out.println("Deisgnation code :"+designation.getCode());
System.out.println("Designation title :"+designation.getTitle());
System.out.println("date of birth :"+simpleDateFormat.format(employee.getDateOfBirth()));
System.out.println("Gender :"+employee.getGender());
System.out.println("Is Indian :"+employee.getIsIndian());
System.out.println("Basic salary :"+employee.getBasicSalary());
System.out.println("pan number :"+employee.getPANNumber());
System.out.println("Aadhar card number :"+employee.getAadharCardNumber());
}catch(BLException blException)
{
if(blException.hasGenericException())System.out.println(blException.getGenericException());
List<String>properties=blException.getProperties();
for(String property :properties)
{
System.out.println(blException.getException(property));
}
}
}
}