
package util;

import models.User;
import java.util.List;

public class CriteriaOr implements Criteria {
	private Criteria criteriaOne;
	private Criteria criteriaTwo;
	public CriteriaOr(Criteria criteriaOne, Criteria criteriaTwo){
		this.criteriaOne = criteriaOne;
		this.criteriaTwo = criteriaTwo;
	}

	@Override
	public List<User> meetCriteria(List<User> users) {
		List<User> criteriaOneItems = criteriaOne.meetCriteria(users);
		List<User> criteriaTwoItems = criteriaTwo.meetCriteria(users);
		for(User user:criteriaTwoItems){
			if(!criteriaOneItems.contains(user)){
				criteriaOneItems.add(user);
			}
		}
		return criteriaOneItems;
	}
}

