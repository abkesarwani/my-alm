package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.UserGroup;
import com.cybage.model.UserGroupPermissions;
import com.cybage.model.UserPassword;
import com.cybage.model.UserRolePermissions;
import com.cybage.domainObjects.ClientDomain;
import com.cybage.model.Client;
import com.cybage.model.Permission;
import com.cybage.model.Role;
import com.cybage.model.User;
import com.cybage.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userserviceObj;
	//add new user
	@RequestMapping(value = "/add",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@RequestBody User userObj)
 	{
	 System.out.println(userObj.toString());
	 String response=userserviceObj.addNewUser(userObj);
	System.out.println(response);	
	 return response;
    }
	//add new permission
	@RequestMapping(value = "/addpermissions",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public String getUserPermissions(@RequestBody Permission permiObj)
 	{
	 System.out.println(permiObj.toString());
	 String response=userserviceObj.addNewPermission(permiObj);
	System.out.println(response);	
	 return response;
    }
	//add new group
	@RequestMapping(value = "/addgroup",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public String getGroup(@RequestBody UserGroup grpObj)
 	{
	 System.out.println(grpObj.toString());
	 String response=userserviceObj.addNewGroup(grpObj);
	System.out.println(response);	
	 return response;
    }
	//add new role
		@RequestMapping(value = "/addrole",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	    public String getGroup(@RequestBody Role roleObj)
	 	{
		 System.out.println(roleObj.toString());
		 String response=userserviceObj.addNewRole(roleObj);
		System.out.println(response);	
		 return response;
	    }
		
		//add new rolepermissions
				@RequestMapping(value = "/addrolepermissions",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
			    public String getGroup(@RequestBody UserRolePermissions urpObj)
			 	{
				 System.out.println(urpObj.toString());
				 String response=userserviceObj.addRolePermission(urpObj);
				System.out.println(response);	
				 return response;
			    }
				
				//add new grouppermissions
				@RequestMapping(value = "/addgrouppermissions",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
			    public String getGroup(@RequestBody UserGroupPermissions ugpObj)
			 	{
				 System.out.println(ugpObj.toString());
				 String response=userserviceObj.addGroupPermission(ugpObj);
				System.out.println(response);	
				 return response;
			    }
				//send all permissions
				@RequestMapping(value = "/getpermissions",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<String> sendPermissions()
			 	{
					List<String> li;
				 //System.out.println(ugpObj.toString());
				 li=userserviceObj.sendPermissions();
				//System.out.println(response);	
				 return li;
			    }
				
				//send all roles
				@RequestMapping(value = "/getroles",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<String> sendRoles()
			 	{
					List<String> li;
				
				 li=userserviceObj.sendRole();
				
				 return li;
			    }
				
				//send all group
				@RequestMapping(value = "/getgroup",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<String> sendGroups()
			 	{
					List<String> li;
				 //System.out.println(ugpObj.toString());
				 li=userserviceObj.sendGroup();
				
				 return li;
			    }
				
				//send all Users
				@RequestMapping(value = "/getallusers",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<User> sendUsers()
			 	{
					List<User> li;
				 
				 li=userserviceObj.sendUsers();
			
				 return li;
			    }
				
				//search User
				@RequestMapping(value = "/searchuser/{name}",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public User searchUser( @PathVariable("name") String name)
			 	{
					User userObj;
				
				 userObj=userserviceObj.searchUser(name);
				
				 return userObj;
			    }
				
				// deleteUser
				@RequestMapping(value = "/deleteuser/{name}",method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
			    public String deleteUser( @PathVariable("name") String name)
			 	{
					 String response=userserviceObj.deleteUser(name);
					 System.out.println(response);	
					 return response;
			    }
				
				//update user
				@RequestMapping(value = "/update",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
			
				    public String updateUsers(@RequestBody User userObj)
				    {
					 String response=userserviceObj.updateUser(userObj);
					
					 return response;
				    }	
				
				
				//send all permissions
				@RequestMapping(value = "/getallpermissions",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<Permission> sendlistPermission()
			 	{
					List<Permission> li;
				
				 li=userserviceObj.sendlistPermission();
				
				 return li;
			    }
				
				//search deletePermission
				@RequestMapping(value = "/deletepermission/{name}",method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
			    public String deletePermission( @PathVariable("name") String name)
			 	{
					 String response=userserviceObj.deletePermission(name);
					 System.out.println(response);	
					 return response;
			    }
				
				//update permission
				@RequestMapping(value = "/updatepermission",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
			     public String updatePermission(@RequestBody Permission perObj)
				 {
					 String response=userserviceObj.updatePermission(perObj);
					
					 return response;
				 }
				
				//send all roles
				@RequestMapping(value = "/getallroles",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<Role> sendlistRoles()
			 	{
					List<Role> li;
				   
				    li=userserviceObj.sendAllRole();
				   //System.out.println(response);	
				    return li;
			    }
				
				
				//search deleteRole
				@RequestMapping(value = "/deleterole/{name}",method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
			    public String deleteRole( @PathVariable("name") String name)
			 	{
					 String response=userserviceObj.deleteRole(name);
					 System.out.println(response);	
					 return response;
			    }
				
				
				//check password
				@RequestMapping(value = "/checkuserpass",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
			
				    public User checkUsersPasswords(@RequestBody UserPassword userObj)
				    {
					User response=userserviceObj.checkUsersPasswords(userObj);
					
					 return response;
				    }	
				
				//send all users name
				@RequestMapping(value = "/getusersname",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
			    public List<String> sendAllUnames()
			 	{
					List<String> li;
				
				 li=userserviceObj.sendAllUname();
				
				 return li;
			    }
				
				
				//update user
				@RequestMapping(value = "/updaterole",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
			
				    public String updateUsers(@RequestBody Role userObj)
				    {
					   String response=userserviceObj.updateRole(userObj);
					
					    return response;
				    }
				
				
				
				
				
				
				
	
	
	

}
