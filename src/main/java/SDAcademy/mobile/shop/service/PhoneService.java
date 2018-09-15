package SDAcademy.mobile.shop.service;


import SDAcademy.mobile.shop.entity.Phone;

        import java.util.List;

public interface PhoneService {

    public List<Phone> getPhones();

    public void savePhone(Phone thePhone);

    public Phone getPhone(int theId);

    public void deletePhone(int theId);


}
