
package util;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class CriteriaEDU implements Criteria{

	@Override
	public List<User> meetCriteria(List<User> users) {
		List<User> eduUsers = new ArrayList<User>();
		for(User user:users){
			String email = user.getEmail();
			if(email.endsWith(".edu")){
				eduUsers.add(user);
			}
		}
		return eduUsers;
	}

}

