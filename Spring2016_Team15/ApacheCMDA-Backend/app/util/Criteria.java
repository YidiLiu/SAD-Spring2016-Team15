package util;

import models.User;
import java.util.List;

public interface Criteria {
   public List<User> meetCriteria(List<User> users);
}
