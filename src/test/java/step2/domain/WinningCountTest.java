package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.WinningCount.findWinningCount;

class WinningCountTest {

    @ParameterizedTest
    @CsvSource(value = {"3, 3", "4, 4", "5, 5", "6, 6"})
    void 맞춘_숫자와_매칭_되는_WinningCount_matchingCount_테스트(long input, int expected) {
        assertThat(findWinningCount(input).getMatchingCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 5000", "4, 50000", "5, 1500000", "6, 2000000000"})
    void 맞춘_숫자와_매칭_되는_WinningCount_winningAmount_테스트(long input, int expected) {
        assertThat(findWinningCount(input).getWinningAmount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"7", "2"})
    void 맞춘_숫자와_매칭_되는_WinningCount_matchingCount_테스트_오류(long input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> findWinningCount(input));
    }
}