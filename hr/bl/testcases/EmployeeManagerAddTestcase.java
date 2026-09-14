import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;

class EmployeeManagerAddTestcase
{
public static void main(String args[])
{
try
{
String name="Naman";
DesignationInterface designation=new Designation();
designation.setCode(5);
Date dateOfBirth=new Date();// set current date
boolean isIndian=true;
BigDecimal basicSalary=new BigDecimal(30000);
String panNumber="P2345";
String aadharCardNumber="A2345";
EmployeeInterface employee=new Employee();

employee.setName(name);
employee.setDesignation(designation);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(GENDER.MALE);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
EmployeeManagerInterface employeeManager=EmployeeManager.getEmployeeManager();
employeeManager.addEmployee(employee);
System.out.println("Employee added with employee id. :"+employee.getEmployeeId());
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