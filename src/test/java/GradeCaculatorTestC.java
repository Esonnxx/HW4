/**
 * ClassName: GradeCaculatorTestC
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Esonnxx
 * @Create 2024/1/3 下午 04:15
 * @Version 1.0
 */

import org.junit.Test;

import java.io.*;

import com.essonnxx.GradeCalculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GradeCaculatorTestC {

    @Test
    public void testLetterGradeA() {
        assertEquals('A', GradeCalculator.letterGrade(95));
        assertEquals('A', GradeCalculator.letterGrade(100));
    }

    @Test
    public void testLetterGradeB() {
        assertEquals('B', GradeCalculator.letterGrade(85));
        assertEquals('B', GradeCalculator.letterGrade(89));
    }

    @Test
    public void testLetterGradeC() {
        assertEquals('C', GradeCalculator.letterGrade(75));
        assertEquals('C', GradeCalculator.letterGrade(79));
    }

    @Test
    public void testLetterGradeD() {
        assertEquals('D', GradeCalculator.letterGrade(65));
        assertEquals('D', GradeCalculator.letterGrade(69));
    }

    @Test
    public void testLetterGradeF() {
        assertEquals('F', GradeCalculator.letterGrade(0));
        assertEquals('F', GradeCalculator.letterGrade(59));
    }

    @Test
    public void testLetterGradeOutOfRange() {
        assertEquals('X', GradeCalculator.letterGrade(-5));
        assertEquals('X', GradeCalculator.letterGrade(105));
    }

    @Test
    public void testMainMethod() throws IOException {
        // 準備模擬的輸入
        ByteArrayInputStream mockInput = new ByteArrayInputStream("95".getBytes());
        System.setIn(mockInput);

        // 準備捕獲 System.out 的輸出
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));

        // 呼叫 main 方法
        GradeCalculator.main(new String[]{});

        // 恢復標準輸入和輸出
        System.setIn(System.in);
        System.setOut(System.out);

        // 斷言捕獲的輸出是否符合預期
        String expectedOutput = "The grade of 95 is A";
        assertTrue(capturedOutput.toString().contains(expectedOutput));
    }

    @Test
    public void testMainMethodIOException() throws IOException {
        // 準備模擬的輸入
        InputStream mockInput = new InputStream() {
            @Override
            public int read() throws IOException {
                throw new IOException("Test IOException");
            }
        };
        System.setIn(mockInput);

        ByteArrayOutputStream capturedError = new ByteArrayOutputStream();
        System.setErr(new PrintStream(capturedError));

        // 呼叫 main 方法
        GradeCalculator.main(new String[]{});

        // 恢復標準輸入和輸出
        System.setIn(System.in);
        System.setErr(System.err);

        // 測的錯誤輸出是否符合預期
        String expectedErrorOutput = "Test IOException";
        assertTrue(capturedError.toString().contains(expectedErrorOutput));
    }

    @Test
    public void testMainMethodNumberFormatException() {
        // 準備模擬的輸入
        ByteArrayInputStream mockInput = new ByteArrayInputStream("abc".getBytes());
        System.setIn(mockInput);

        // get System.out 的輸出
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));

        // 呼叫 main 方法
        GradeCalculator.main(new String[]{});

        // 恢復標準輸入和輸出
        System.setIn(System.in);
        System.setOut(System.out);

        // 捕獲的輸出是否符合預期
        String expectedOutput = "Not an integer!";
        assertTrue(capturedOutput.toString().contains(expectedOutput));
    }
}
