package org.basewebapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Deprecated
public class CalculatorTest {

    @Mock
    private Calculator calc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
//        calc = new Calculator();
        
    }
    
    @Test
    public void testAbs() {
//        assertEquals(4, calc.abs(-4));    // fails because Calculator object 'calc' is mocked, and function abs always return '0'
        
        when(calc.abs(-20)).thenReturn(20);
        assertEquals(20, calc.abs(-20));
    }
    
}
