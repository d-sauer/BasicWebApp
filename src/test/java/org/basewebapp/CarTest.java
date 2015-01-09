package org.basewebapp;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Deprecated
public class CarTest {

    @Mock
    private Engine engine;
    
    @InjectMocks
    private Car car;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testWarning() {
        when(engine.getRpm()).thenReturn(6000); // set custom behavior on mock object 
        car.accelerate();
        
        assertEquals("Slow Down!", car.getWarningMessage());
    }
}
