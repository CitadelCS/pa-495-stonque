package edu.citadel;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
// testIsEmpty* 5
// testSize* 5
// testPush* 5
// testEnqueue* 5
// testPeek* 5
// testToString* 5
// testPop* 10
// testIteratorMethod* 10



public class StonqueTest {

    Stonque<String> s;
    Stonque<Integer> tq;

    @org.junit.Before
    public void setUp() {
        s = new Stonque<>();
        tq = new Stonque<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue("expect empty to be true for size 0", tq.empty());
    }

    @Test
    public void testIsEmptyAfterPush() {
        assertTrue("expect empty to be true for size 0", tq.empty());
        tq.push(1);
        assertFalse("expect empty to be false after push", tq.empty());
    }

    @Test
    public void testIsEmptyAfterEnqueue() {
        assertTrue("expect empty to be true for size 0", tq.empty());
        tq.enqueue(1);
        assertFalse("expect empty to be false after enqueue", tq.empty());
    }

    @Test
    public void testIsEmptyAfterPushPop() {
        assertTrue("expect empty to be true for size 0", tq.empty());
        tq.push(1);
        assertFalse("expect empty to be false after push", tq.empty());
        tq.pop();
        assertTrue("expect empty to be true for size 0 after pop", tq.empty());
    }

    @Test
    public void testSizeZero() {
        assertEquals("expect size 0 for new stonque", 0, tq.size());
    }

    @Test
    public void testSizeAfterPush() {
        assertEquals("expect size 0 for new twoQueue", 0, tq.size());
        tq.push(1);
        assertEquals("expect size 1 after push", 1, tq.size());
    }

    @Test
    public void testSizeAfterEnqueue() {
        assertEquals("expect size 0 for new twoQueue", 0, tq.size());
        tq.enqueue(1);
        assertEquals("expect size 1 after enqueue", 1, tq.size());
    }

    @Test
    public void testSizeAfterPushPop() {
        assertEquals("expect size 0 for new twoQueue", 0, tq.size());
        tq.push(1);
        assertEquals("expect size 1 after addFirst", 1, tq.size());
        tq.pop();
        assertEquals("expect size 0 after removeFirst", 0, tq.size());
    }

    @Test
    public void testPush() {
        assertEquals("expect new twoQueue to be empty", "", show());
        tq.push(3);
        assertEquals("expect 1 item after 1x push", "3", show());
        tq.push(2);
        assertEquals("expect 2 items LIFO after 2x push", "2 3", show());
        tq.push(1);
        assertEquals("expect 3 items LIFO after 3x push", "1 2 3", show());
    }

    @Test
    public void testEnqueue() {
        assertEquals("expect new twoQueue to be empty", "", show());
        tq.enqueue(1);
        assertEquals("expect 1 item after 1x enqueue", "1", show());
        tq.enqueue(2);
        assertEquals("expect 2 items FIFO after 2x enqueue", "1 2", show());
        tq.enqueue(3);
        assertEquals("expect 3 items FIFO after 3x enqueue", "1 2 3", show());
    }

    @Test
    public void testPeekEmpty() {
        try {
            tq.peek();
            fail("expect exception to be thrown for peek from empty list.");
        } catch (java.util.NoSuchElementException nsee) {
        }
    }

    @Test
    public void testPeekSingleItemPushed() {
        tq.push(1);
        assertTrue("expect peek of only item to match added item", tq.peek().equals(1));
    }

    @Test
    public void testPeekSingleItemEnqueued() {
        tq.enqueue(1);
        assertTrue("expect peek of only item to match added item", tq.peek().equals(1));
    }

    @Test
    public void testPeekMultiItem1() {
        tq.push(3);
        tq.push(2);
        tq.push(1);
        assertTrue("expect peek to return first of multiple items", tq.peek().equals(1));
    }

    @Test
    public void testPeekMultiItem2() {
        tq.push(1);
        tq.enqueue(2);
        assertTrue("expect peek to return first of multiple items", tq.peek().equals(1));
    }

    @Test
    public void testToString() {
        assertEquals("expect toString to return a String object.", "".getClass(), tq.toString().getClass());
    }

    @Test
    public void testPopEmpty() {
        try {
            tq.pop();
            fail("expect exception to be thrown for pop from empty list.");
        } catch (java.util.NoSuchElementException nsee) {
        }
    }

    @Test
    public void testPopSingleItem() {
        tq.push(1);
        assertTrue("expect pop of only item to match added item", tq.pop().equals(1));
    }

    @Test
    public void testPopSingleItem2() {
        tq.push(1);
        assertTrue("expect pop of only item to match added item", tq.pop().equals(1));
        assertEquals("expect size to decrement after pop", 0, tq.size());
    }

    @Test
    public void testPopMultiItem1() {
        tq.push(3);
        tq.push(2);
        tq.push(1);
        assertTrue("expect pop to remove first of multiple items", tq.pop().equals(1));
    }

    @Test
    public void testPopMultiItem2() {
        tq.push(3);
        tq.push(2);
        tq.push(1);
        assertTrue("expect pop to remove first of multiple items", tq.pop().equals(1));
        assertEquals("expect size to decrement after pop", 2, tq.size());
    }

    @Test
    public void testPopMultiItem3() {
        tq.push(3);
        tq.push(2);
        tq.push(1);
        assertTrue("expect pop to remove first of multiple items", tq.pop().equals(1));
        assertTrue("expect pop to remove second of multiple items", tq.pop().equals(2));
    }

    @Test
    public void testPopMultiItem4() {
        tq.enqueue(3);
        tq.enqueue(2);
        tq.enqueue(1);
        assertTrue("expect pop to remove first of multiple items", tq.pop().equals(3));
        assertTrue("expect pop to remove second of multiple items", tq.pop().equals(2));
        assertTrue("expect pop to remove third of multiple items", tq.pop().equals(1));
    }

    @Test
    public void testPopMultiItem5() {
        tq.push(3);
        tq.push(2);
        tq.push(1);
        assertTrue("expect pop to remove first of multiple items", tq.pop().equals(1));
        assertTrue("expect pop to remove second of multiple items", tq.pop().equals(2));
        assertTrue("expect pop to remove third of multiple items", tq.pop().equals(3));
        assertEquals("expect size to decrement after pop", 0, tq.size());
    }

    @Test
    public void testIteratorMethod() {
        assertNotNull("expect iterator method to return non-null", tq.iterator());
    }

    @Test
    public void testIteratorRemoveException() {
        try {
            tq.iterator().remove();
            fail("expect exception to be thrown for remove from iterator.");
        } catch (java.lang.UnsupportedOperationException uoe) {
        }

    }

    @Test
    public void testIteratorNextWhenEmpty() {
        tq.push(1);
        Iterator<Integer> i = tq.iterator();
        i.next();
        try {
            i.next();
            fail("expect exception to be thrown for next() from exhausted iterator.");
        } catch (java.util.NoSuchElementException nsee) {
        }

    }

    @Test
    public void testIteratorMultipleItemsPush() {
        tq.push(1);
        tq.push(2);
        tq.push(3);
        assertEquals("expect iterator to go front to back", "3 2 1", show());
    }

    @Test
    public void testIteratorMultipleItemsEnqueue() {
        tq.enqueue(1);
        tq.enqueue(2);
        tq.enqueue(3);
        assertEquals("expect iterator to go front to back", "1 2 3", show());
    }

    @Test
    public void testIteratorIndependent() {
        tq.push(3);
        tq.push(2);
        tq.push(1);
        String s = "";
        for (Integer i : tq) {
            for (Integer j : tq) {
                s += i + " " + j + " ";
            }
        }
        assertEquals("expect nested iterators to report independently",
                "1 1 1 2 1 3 2 1 2 2 2 3 3 1 3 2 3 3", s.trim());
    }

    private String show() {
        String str = "";
        for (Integer i : tq)
            str += i + " ";
        return str.trim();
    }
}