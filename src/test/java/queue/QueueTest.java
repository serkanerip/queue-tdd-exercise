package queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
    // jUnit recreates new instance of QueueTest class for each test
    // therefore, this will be new created queue for each test
    private final Queue queue  = new Queue();

    @Test
    public void canCreateQueue() throws Exception{
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void afterOneEnqueue_isNotEmptyNotFull() throws Exception{
        queue.enqueue(0);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void afterThreeEnqueue_isFull() throws Exception{
        queue.enqueue(99);
        queue.enqueue(88);
        queue.enqueue(77);
        Assert.assertTrue(queue.isFull());
    }

    @Test
    public void afterEnqueueXAndY_willDequeueXThenY() throws Exception{
        queue.enqueue(15);
        queue.enqueue(30);
        Assert.assertEquals(15, queue.dequeue());
        Assert.assertEquals(30, queue.dequeue());
    }

    @Test(expected = Overflow.class)
    public void enqueueToFilled_throwsOverflow() throws Exception{
        queue.enqueue(15);
        queue.enqueue(30);
        queue.enqueue(30);

        queue.enqueue(40);
    }

    @Test
    public void peekAfterEnqueueXAndY_returnX() throws Exception{
        queue.enqueue(15);
        queue.enqueue(30);

        Assert.assertEquals(15, queue.peek());
    }

    @Test(expected = Underflow.class)
    public void peekEmptyQueue_throwsUnderflow() throws Exception{
        queue.peek();
    }

    @Test(expected = Underflow.class)
    public void dequeueToEmpty_throwsOverflow() throws Exception{
        queue.dequeue();
    }
}
