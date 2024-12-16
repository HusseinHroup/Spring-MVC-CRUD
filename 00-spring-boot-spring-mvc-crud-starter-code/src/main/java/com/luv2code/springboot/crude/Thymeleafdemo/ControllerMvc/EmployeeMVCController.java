package com.luv2code.springboot.crude.Thymeleafdemo.ControllerMvc;
import com.luv2code.springboot.crude.Thymeleafdemo.entity.Employee;
import com.luv2code.springboot.crude.Thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeMVCController {
public EmployeeService Service;

//just i want to Remmebr the proccess.
    @Autowired
    public EmployeeMVCController(EmployeeService service) {
        Service = service;
    }

//for get list not difficult
    @GetMapping("/list")
    public String list_employee(Model themodel){

//get the wmployee from data base
    List<Employee> listEmployee;
    listEmployee =Service.findAll();
//add the employee to html OR add to Spring Model .
    themodel.addAttribute("employees" , listEmployee);
    return "list-employee";
  }


  @GetMapping("/ShowFormForUpdate")
public String ShowFormForUpdate(@RequestParam("employeeId") int theid , Model themodel ){
        //here in update i want to know information very important
      // When you want pass object you must pass same object not another object when edit
        Employee theEmployee =Service.findById(theid);
        themodel.addAttribute("NewObject",theEmployee);
return "Show-Form";
  }

  //we must known the request body in Saving in database not here .

///employees/list

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){

Employee  theEmployee = new Employee();

theModel.addAttribute("NewObject",theEmployee);

    return "Show-Form";
    }


    @PostMapping("/Save")
    public String save(@ModelAttribute("NewObject")  Employee theEmployee ){

        //save the employee
        Service.save(theEmployee);
        //here not be return to another page i want refactor to the page
        //use redirect to prevent dublicate submision
        return "redirect:/employees/list";//so this  reson to called redirect
        //here redirect to point to controller
    }

@GetMapping("/Deleted")
    public String Delete(@RequestParam("ID") int theid) {
Service.deleteById(theid);
    return "redirect:/employees/list";
}


}


