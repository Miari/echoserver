package com.boroday.echoserver;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class ClientTest {
    private Client client = new Client();

    @Test
    public void testReadFromConsole () throws IOException {
        byte[] byteArray = client.readFromConsole();
        assertEquals(116, byteArray[0]);//console input: tyu
    }
}
