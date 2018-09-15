package SDAcademy.mobile.shop.repository;

import SDAcademy.mobile.shop.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);
}