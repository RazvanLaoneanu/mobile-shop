package SDAcademy.mobile.shop.controller;

import java.util.List;

import SDAcademy.mobile.shop.entity.Phone;
import SDAcademy.mobile.shop.entity.User;
import SDAcademy.mobile.shop.repository.PhoneRepository;
import SDAcademy.mobile.shop.service.PhoneService;
import SDAcademy.mobile.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/user")
public class UserController {

    // need to inject our customer service
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the service
        List<User> theUsers = userService.getUser();

        // add the customers to the model
        theModel.addAttribute("users", theUsers);

        return "list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        User theUsers = new User();

        theModel.addAttribute("user", theUsers);

        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveCustomer(@ModelAttribute("user") User theUser) {

        // save the customer using our service
        userService.saveUser(theUser);
        return "redirect:/user/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model theModel) {

        // get the customer from our service
        User theUser = userService.getUser(theId);


        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("user", theUser);

        // send over to our form
        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId")int theId) {

        userService.deleteUser(theId);

        return "redirect:/user/list";
    }

}
