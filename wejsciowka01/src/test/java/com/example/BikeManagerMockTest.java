package com.example;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BikeManagerMockTest {

    //SUT
    private BikeManager bike;
    private IMyList mock;


    @Before
    public void setUp() {
        mock = createMock(IMyList.class);
        bike = new BikeManager(mock);
    }

    private final static long ID=1234;
    private final static String NAZWA="Rowerek";
    private final static int NUMER=12;
    Bike rower = new Bike(ID, NAZWA, NUMER);
    List<Bike> jakaslista = new ArrayList<Bike>();
    jakaslista.  add(rower);
    @Test
    public void ListCheck() {
        expect(mock.add(rower)).andReturn(true).times(1);
        expect(mock.remove(rower)).andReturn(true).atLeastOnce();
        expect(mock.getall()).andReturn(jakaslista).anyTimes());
        replay(mock);
        assertEquals(true, bike.dodawanie(rower));
        assertEquals(true, bike.usuwanie(rower));

        verify(mock);
    }

}
