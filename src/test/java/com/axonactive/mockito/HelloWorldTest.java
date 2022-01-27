package com.axonactive.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


class HelloWorldTest {
    @Mock
    HelloWorld helloWorld;

    @Test
    public void getGreet_ShouldReturnHelloWorld(){
        when(helloWorld.getGreet()).thenReturn("Hello World");
        assertEquals("Hello World", helloWorld.getGreet());
    }

}