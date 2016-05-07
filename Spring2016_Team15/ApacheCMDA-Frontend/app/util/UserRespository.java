package util;
import models.User;
import java.util.List;
public class UserRespository implements Container {
    public List<User> users;
    public UserRespository(List<User> users) {
           this.users = users;
    }
    @Override
    public Iterator getIterator() {
        return new UserIterator();
    }
    private class UserIterator implements Iterator { 
       int index;
	@Override
        public boolean hasNext() {
            if (index < users.size()) {
		return true;
	    }
	    return false;
	}
	@Override
	public User next() {
	    if (this.hasNext()) {
	       return users.get(index++);
            }
	    return null;
	}
    }
}
