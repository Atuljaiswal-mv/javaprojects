package com.thinking.machines.hr.bl.managers;

import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.exceptions.*;
import java.util.*;

public class DesignationManager implements DesignationManagerInterface
{
private Map<Integer,DesignationInterface>codeWiseDesignationsMap;
private Map<String,DesignationInterface>titleWiseDesignationsMap;
private Set<DesignationInterface>designationsSet;
private static DesignationManager designationManager=null;
private DesignationManager()throws BLException// for singleton pattern 
{
populateDataStructures();
}
private void populateDataStructures()throws BLException
{
this.codeWiseDesignationsMap=new HashMap<>();
this.titleWiseDesignationsMap=new HashMap<>();
this.designationsSet=new TreeSet<>();
try
{
Set<DesignationDTOInterface>dlDesignations; 
dlDesignations=new DesignationDAO().getAll();
DesignationInterface designation;
for(DesignationDTOInterface dlDesignation: dlDesignations)
{
designation=new Designation();
designation.setCode(dlDesignation.getCode());
designation.setTitle(dlDesignation.getTitle());
this.codeWiseDesignationsMap.put(new Integer(designation.getCode()),designation);
this.titleWiseDesignationsMap.put(designation.getTitle().toUpperCase(),designation);
this.designationsSet.add(designation);
}
}catch(DAOException daoException)
{
BLException blException=new BLException();
blException.setGenericException(daoException.getMessage());
throw blException;
}
}

// followin method is only for same package use .., so that we can store
// the same address of object in all BL level Data structures
DesignationInterface getDSDesignationByCode(int code)
{
DesignationInterface designation=codeWiseDesignationsMap.get(code);
return designation;
}

public static DesignationManagerInterface getDesignationManager()throws BLException
{
if(designationManager==null)designationManager=new DesignationManager();
return designationManager;
}

public void addDesignation(DesignationInterface designation)throws BLException
{
BLException blException=new BLException();
if(designation==null)
{
blException.setGenericException("Designation required");
throw blException;
}
int code=designation.getCode();
String title=designation.getTitle();

if(code!=0)
{
blException.addException("code","Code should be zero");
}
if(title==null)
{
blException.addException("title","title required");
title="";
}
title=title.trim();
if(title.length()==0)
{
blException.addException("title","title required");
}
if(title.length()>0)
{
if(this.titleWiseDesignationsMap.containsKey(title.toUpperCase()))
{
blException.addException("title","Designation :"+title+" exists.");
}
}
if(blException.hasExceptions())
{
throw blException;
}
try
{
DesignationDTOInterface designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
DesignationDAOInterface designationDAO=new DesignationDAO();
designationDAO.add(designationDTO);
code=designationDTO.getCode();
designation.setCode(code);
DesignationInterface dsDesignation=new Designation();
dsDesignation.setCode(code);
dsDesignation.setTitle(title);
codeWiseDesignationsMap.put(new Integer(code),dsDesignation);
titleWiseDesignationsMap.put(title.toUpperCase(),dsDesignation);
designationsSet.add(dsDesignation);
}catch(DAOException daoException)
{
blException.setGenericException(daoException.getMessage());
}
}

public void updateDesignation(DesignationInterface designation)throws BLException
{
BLException blException=new BLException();
if(designation==null)
{
blException.setGenericException("Designation required");
throw blException;
}
int code=designation.getCode();
String title=designation.getTitle();
if(code<=0)
{
blException.addException("code","Invalid code :"+code);
throw blException;
}
if(title==null)
{
blException.addException("title","title required");
title="";
}
title=title.trim();
if(title.length()==0)
{
blException.addException("title","title required");
}

boolean codeExists=codeWiseDesignationsMap.containsKey(code);
if(codeExists==false)
{
blException.addException("code","Invalid code");
}
boolean titleExists=titleWiseDesignationsMap.containsKey(title.toUpperCase());
if(titleExists==true)
{
DesignationInterface           tmpDesignation=titleWiseDesignationsMap.get(title.toUpperCase());
int tmpCode=tmpDesignation.getCode();
if(tmpCode!=code)
{
blException.addException("title","Designation :"+title+" exists with code :"+tmpCode);
}      
}
if(blException.hasExceptions())
{
throw blException;
}
try
{
// this for remove from ds
DesignationInterface dsDesignation=codeWiseDesignationsMap.get(code);
// this for update in file by dl
DesignationDTOInterface dlDesignation=new DesignationDTO();
dlDesignation.setCode(code);
dlDesignation.setTitle(title);
new DesignationDAO().update(dlDesignation);
// now remove
codeWiseDesignationsMap.remove(code);
titleWiseDesignationsMap.remove(dsDesignation.getTitle().toUpperCase());
designationsSet.remove(dsDesignation);

dsDesignation.setTitle(title);// as code was already the same
codeWiseDesignationsMap.put(code,dsDesignation);
titleWiseDesignationsMap.put(title,dsDesignation);
designationsSet.add(dsDesignation);
}catch(DAOException daoException)
{
blException.setGenericException(daoException.getMessage());
}
}

public void removeDesignation(int code)throws BLException
{
BLException blException=new BLException();
if(code<=0)
{
blException.addException("code","Invalid code :"+code);
throw blException;
}
if(this.codeWiseDesignationsMap.containsKey(code)==false)
{
blException.addException("code","Invalid code:"+code);
throw blException;
}
try
{
DesignationInterface designation=codeWiseDesignationsMap.get(code);
new DesignationDAO().delete(code);
codeWiseDesignationsMap.remove(code);
titleWiseDesignationsMap.remove(designation.getTitle().toUpperCase());
designationsSet.remove(designation);
}catch(DAOException daoException)
{
blException.setGenericException(daoException.getMessage());
throw blException;
}
}

public DesignationInterface getDesignationByCode(int code)throws BLException
{
BLException blException=new BLException();
if(code<=0)
{                      
blException.addException("code","Invalid code:"+code);
throw blException;
}
DesignationInterface designation=new Designation();
designation=codeWiseDesignationsMap.get(code);
if(designation==null)
{
blException.addException("code","Invalid Code :"+code);
throw blException;
}
DesignationInterface d=new Designation();
d.setCode(designation.getCode());
d.setTitle(designation.getTitle());
return d;
}


public DesignationInterface getDesignationByTitle(String title)throws BLException
{
BLException blException=new BLException();
if(title==null)
{
blException.addException("title","designation requires");
throw blException;
}
title=title.trim();
if(title.length()==0)
{
blException.addException("title","designation requires");
throw blException;
}
DesignationInterface designation;
designation=titleWiseDesignationsMap.get(title);
if(designation==null)
{
blException.addException("title","Invalid designation :"+title);
throw blException;
}
DesignationInterface d=new Designation();
d.setCode(designation.getCode());
d.setTitle(designation.getTitle());
return d;
}

public int getDesignationCount()	
{
return designationsSet.size();
}

public boolean designationCodeExists(int code)
{
boolean isExists=false;
isExists=codeWiseDesignationsMap.containsKey(code);
return isExists;
}

public boolean designationTitleExists(String title)
{
boolean isExists=titleWiseDesignationsMap.containsKey(title.toUpperCase());
return isExists;
}

public Set<DesignationInterface>getDesignations()
{
Set<DesignationInterface>designations=new TreeSet<>();
designationsSet.forEach((designation)->{
DesignationInterface d=new Designation();
d.setCode(designation.getCode());
d.setTitle(designation.getTitle());
designations.add(d);
});
return designations;
}
}