package com.mercury.dao;

import com.mercury.beans.Person;

public interface PersonDao {
	public Person findByUserName(String username);
}
