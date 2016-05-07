package util;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class CriteriaCOM implements Criteria {

	@Override
	public List<User> meetCriteria(List<User> users) {
		List<User> comUsers = new ArrayList<User>();
		for(User user:users){
			String email = user.getEmail();
			if(email.endsWith(".com")){
				comUsers.add(user);
			}
		}
		return comUsers;
	}
}

