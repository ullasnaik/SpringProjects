package net.codejava.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.MutaionEntryDAO;
import net.codejava.spring.model.MutaionEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MutaionEntryDAO mutationEntryDao;

	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<MutaionEntry> listUsers = mutationEntryDao.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new MutaionEntry());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {		
		String userId = request.getParameter("id");
		MutaionEntry user = mutationEntryDao.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		String userId = request.getParameter("id");
		mutationEntryDao.delete(userId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute MutaionEntry user,@RequestParam CommonsMultipartFile[] fileUpload) {
		  if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){	                  
	                System.out.println("Saving file: " + aFile.getOriginalFilename());	                 
	                user.setFileContent(aFile.getBytes());             
	            }
	        }  
		mutationEntryDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
	
}
