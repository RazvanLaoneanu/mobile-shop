package SDAcademy.mobile.shop.service;

import SDAcademy.mobile.shop.entity.Phone;
import SDAcademy.mobile.shop.entity.User;


import java.util.List;

public interface UserService  {

    public List<User> getUser();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);

}
