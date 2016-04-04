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

    private final static long ID_2=1235;
    private final static String NAZWA_2="Kolarka";
    private final static int NUMER_2=99;
    Bike rower2 = new Bike(ID_2, NAZWA_2, NUMER_2);

    public List<Bike> jakaslista = new ArrayList<Bike>();

    @Test
    public void addCheck() {
        expect(mock.add(rower)).andReturn(true).times(1);
        replay(mock);
        assertEquals(true, bike.dodawanie(rower));
        verify(mock);
    }

    @Test
    public void removeCheck() {
        jakaslista.add(rower);
        expect(mock.remove(rower)).andReturn(true).atLeastOnce();
        replay(mock);
        assertEquals(true, bike.usuwanie(rower));
        verify(mock);
    }

    @Test
    public void getAllCheck() {
        jakaslista.add(rower);
        jakaslista.add(rower2);
        expect(mock.getall()).andReturn(jakaslista).anyTimes();
        replay(mock);
        assertEquals(jakaslista, bike.zapodaj());
        verify(mock);
    }

    @Test
    public void findByNazwaCheck() {
        jakaslista.add(rower);
        jakaslista.add(rower2);
        expect(mock.findByNazwa(NAZWA)).andReturn(rower).anyTimes();
        replay(mock);
        assertEquals(rower, bike.findByNazwa(NAZWA));
        verify(mock);
    }

    @Test
    public void findByIdCheck() {
        jakaslista.add(rower);
        jakaslista.add(rower2);
        expect(mock.findById(ID)).andReturn(rower).anyTimes();
        replay(mock);
        assertEquals(rower, bike.findById(ID));
        verify(mock);
    }
}
