package lotto.step3.view;

import lotto.step3.domain.BonusNumber;
import lotto.step3.domain.LottoCount;
import lotto.step3.domain.WinningNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_TEXT_BUY = "구입금액을 입력해 주세요.";
    public static final String TEXT_BUY_LIST = "개를 구매했습니다.";
    public static final String TEXT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String NUMBER_DELIMITER = ",";
    public static final String TEXT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public LottoCount lottoCount;

    public LottoCount inputInitData() {
        System.out.println(INPUT_TEXT_BUY);
        int price = SCANNER.nextInt();
        lottoCount = new LottoCount(price);
        System.out.println(lottoCount.getLottoCount() + TEXT_BUY_LIST);

        return lottoCount;
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println();
        System.out.println(TEXT_WINNING_NUMBERS);
        String[] numbers = SCANNER.next().split(NUMBER_DELIMITER);
        Set<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println(TEXT_BONUS_NUMBER);
        int bonusNumber = SCANNER.nextInt();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
