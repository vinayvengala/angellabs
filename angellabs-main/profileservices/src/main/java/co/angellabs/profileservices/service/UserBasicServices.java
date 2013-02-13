package co.angellabs.profileservices.service;

import co.angellabs.entities.dto.User;

public interface UserBasicServices  {

	public User validateUser(int user_id);
	
	public boolean register( User user);
}
