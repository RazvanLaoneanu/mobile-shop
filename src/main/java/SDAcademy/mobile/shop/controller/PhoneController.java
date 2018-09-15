package SDAcademy.mobile.shop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import SDAcademy.mobile.shop.entity.Phone;
import SDAcademy.mobile.shop.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/phone")
public class PhoneController {

    public static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static.css/Images";
    // need to inject our customer service
    @Autowired
    private PhoneService phoneService;

//    @Autowired
//    private AuthorizationHelper at;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

            // get customers from the service
            List<Phone> thePhones = phoneService.getPhones();

            // add the customers to the model
            theModel.addAttribute("phones", thePhones);

            return "list-phones";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data///ask about the s at the end
        Phone thePhones = new Phone();

        theModel.addAttribute("phone", thePhones);

        return "phone-form";
    }

    @PostMapping("/savePhone")
    public String saveCustomer(@ModelAttribute("phone") Phone thePhone, @RequestParam("file")MultipartFile file) {

        Path filenameandpath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());


        File myfile = new File(UPLOAD_DIRECTORY+"/" + file.getOriginalFilename());

        try {
            Files.write(filenameandpath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        phoneService.savePhone(thePhone);
        return "redirect:/phone/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("phoneId") int theId,
                                    Model theModel) {

        // get the customer from our service
        Phone thePhone = phoneService.getPhone(theId);


        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("phone", thePhone);

        // send over to our form
        return "phone-form";
    }

    @GetMapping("/delete")
    public String deletePhone(@RequestParam("phoneId")int theId) {

        phoneService.deletePhone(theId);

        return "redirect:/phone/list";
    }

}
