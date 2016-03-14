package com.example;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;

import org.junit.Before;
import org.junit.Test;
public class BikeManagerMockTest {

    //SUT
    private Bike bike;
    private BikeManager mock;


    @Before
    public void setUp() {
        mock = createMock(BikeManager.class);
        //bike = new Bike(mock);
    }

}
