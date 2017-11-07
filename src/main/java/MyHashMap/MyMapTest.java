package MyHashMap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMapTest {
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testMapMap() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Lars", 1);
        map.put("Lars", 2);
        map.put("Lars", 1);
        assertEquals(map.get("Lars"), 1, 0);
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), i);
        }
        assertEquals(map.size(), 101);
        assertEquals(map.get("51"), 51, 0);
        map.remove("Lars");
        assertEquals(map.size(), 100);
        assertEquals(map.keySet().size(),100);
    }
}
