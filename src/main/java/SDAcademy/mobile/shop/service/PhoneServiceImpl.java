package SDAcademy.mobile.shop.service;

import SDAcademy.mobile.shop.entity.Phone;
import SDAcademy.mobile.shop.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getPhones() {
        List<Phone> phones = new ArrayList<>();
        phoneRepository.findAll().forEach(phones::add);

        return phones;
    }

    @Override
    public void savePhone(Phone thePhone) {

        phoneRepository.save(thePhone);

    }

    @Override
    public Phone getPhone(int theId) {

        return phoneRepository.findById(theId).get();
    }

    @Override
    public void deletePhone(int theId) {

        Phone phone = phoneRepository.findById(theId).get();
        phoneRepository.delete(phone);

    }
}
