


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;



 public class SomeTest{



    @Test
     public void testLa(){
        int i = new ToBeTested().increment(2);
        assertEquals(3, i);
    }

    @Test
     public void testSum(){
        Integer[] integers = {1,2,3,4,5};
        List<Integer> integerList =Arrays.asList(integers);
        assertEquals(Integer.valueOf(15), new ToBeTested().sum(integerList));
    }

}
