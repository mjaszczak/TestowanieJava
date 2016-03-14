package com.example.mockdemo.app;


import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EasyMockTest {

    @Rule
    public EasyMockRule mocks = new EasyMockRule(this);

    @Mock
    private MessageService mock;

    @TestSubject
    private Messenger messenger = new Messenger(mock);

    private final String VALID_SERVER = "inf.ug.edu.pl";
    private final String INVALID_SERVER = "inf.ug.edu.eu";

    private final String VALID_MESSAGE = "some message";
    private final String INVALID_MESSAGE = "ab";

    @Test
    public void checkSending() throws MalformedRecipientException {

        expect(mock.send(INVALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR).anyTimes();
        expect(mock.send(VALID_SERVER, INVALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR).anyTimes();
        expect(mock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT).anyTimes();
        //expect(mock.divide(5.0, 2.0)).andReturn(2.5);
        replay(mock);
       // assertEquals(2.5, myApp.calculateAvg(2.0, 3.0), 0.0001);

        assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE),
                either(equalTo(0)).or(equalTo(1)));
        assertEquals(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE),1);

        verify(mock);
    }

}
