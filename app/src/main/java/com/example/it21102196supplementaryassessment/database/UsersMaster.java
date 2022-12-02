package com.example.it21102196supplementaryassessment.database;

import android.provider.BaseColumns;

public class UsersMaster {

    private UsersMaster(){}

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_CONTACTNUMBER = "contactnumber";


    }

}
