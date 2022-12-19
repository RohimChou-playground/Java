package com.rohim;

import java.util.ArrayList;

import com.rohim.models.User;

public class FakeDb {
    public static ArrayList<User> Users;

    static {
        Users = new ArrayList<User>();
        Users.add(new User(1, "John"));
        Users.add(new User(2, "Amy"));
    }
}
