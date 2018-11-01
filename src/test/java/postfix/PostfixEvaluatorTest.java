package postfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

	@Test
	public void test1() throws MalformedExpressionException {
	    assertEquals(7, new PostfixEvaluator("5 2 +").eval(), 0);
	}

    @Test
    public void test2() throws MalformedExpressionException {
        assertEquals(8, new PostfixEvaluator("5 2 + 7 - 8 +").eval(), 0);
    }

    @Test
    public void test3() throws MalformedExpressionException {
        assertEquals(-40, new PostfixEvaluator("5 2 + 7 - 8 + 0 5 - *").eval(), 0);
    }

    @Test(expected = MalformedExpressionException.class)
    public void test4() throws MalformedExpressionException {
        assertEquals(-40, new PostfixEvaluator("5 2 + 7 - 8 + 0 5 - * +").eval(), 0);
    }

    @Test(expected = MalformedExpressionException.class)
    public void test5() throws MalformedExpressionException {
        new PostfixEvaluator("+").eval();
    }

    @Test
    public void test6() throws MalformedExpressionException {
        assertEquals(3, new PostfixEvaluator("6 2 /").eval(), 0);
    }

    @Test
    public void test7() throws MalformedExpressionException {
        assertEquals(5, new PostfixEvaluator("15 7 1 1 + - / 3 * 2 1 1 + + -").eval(), 0);
    }

}
