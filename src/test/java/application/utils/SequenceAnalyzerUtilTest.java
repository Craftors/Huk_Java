package application.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SequenceAnalyzerUtilTest {
    @Test
    void shouldReturnValidForCorrectSequence() {
        SequenceAnalyzerUtil.Result result = SequenceAnalyzerUtil.analyze("[(()())]");

        assertTrue(result.isValid());
        assertEquals("Correct", result.getMessage());
        assertEquals(-1, result.getPosition());
    }

    @Test
    void shouldDetectExtraClosingBracket() {
        SequenceAnalyzerUtil.Result result = SequenceAnalyzerUtil.analyze("())");

        assertFalse(result.isValid());
        assertEquals("Extra closing bracket ')'", result.getMessage());
        assertEquals(3, result.getPosition());
    }

    @Test
    void shouldDetectMismatchedBracket() {
        SequenceAnalyzerUtil.Result result = SequenceAnalyzerUtil.analyze("[)");

        assertFalse(result.isValid());
        assertEquals("Mismatched bracket ')'", result.getMessage());
        assertEquals(2, result.getPosition());
    }

    @Test
    void shouldDetectMissingClosingBracket() {
        SequenceAnalyzerUtil.Result result = SequenceAnalyzerUtil.analyze("(((");

        assertFalse(result.isValid());
        assertEquals("Missing closing bracket(s)", result.getMessage());
        assertEquals(3, result.getPosition());
    }
}