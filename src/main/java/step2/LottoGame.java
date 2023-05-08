package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import step2.domain.LotteryWin;
import step2.domain.LottoFactory;
import step2.domain.PurchasedLotto;
import step2.domain.WinningNumbers;
import step2.service.LottoService;
import step2.view.InputView;
import step2.view.LottoView;
import step2.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        int money = getMoney(scanner, inputView);
        int manualLottoCount = getManualLottoCount(scanner, inputView);

        PurchaseInfomationDto dto = new PurchaseInfomationDto(money, manualLottoCount);

        inputView.inputManualLottoNumber();
        List<String> manualLottoList = getManualLottoList(scanner, manualLottoCount);

        PurchasedLotto unrankedPurchasedLottoList = LottoFactory.of(dto, manualLottoList);

        LottoService lottoService = new LottoService(unrankedPurchasedLottoList);

        LottoView lottoView = new LottoView(unrankedPurchasedLottoList);
        lottoView.printLotto();

        ResultView resultView = new ResultView();
        String numbers = getWinningNumbers(scanner, resultView);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        int bonusNumber = getBonusNumber(scanner, resultView);

        PurchasedLotto rankedLottoList = lottoService.matchResult(
            new LotteryWin(winningNumbers, bonusNumber)
        );

        resultView.printStatics(rankedLottoList);
        resultView.printProfit(money, rankedLottoList);
    }

    private static List<String> getManualLottoList(Scanner scanner, int manualLottoCount) {
        List<String> store = new ArrayList<>(manualLottoCount);

        for (int i = 0; i < manualLottoCount; i++) {
            store.add(scanner.next());
        }
        return store;
    }

    private static int getManualLottoCount(Scanner scanner, InputView inputView) {
        inputView.inputManualLottoCount();
        return scanner.nextInt();
    }

    private static int getBonusNumber(Scanner scanner, ResultView resultView) {
        resultView.bonusNumberComment();
        return scanner.nextInt();
    }

    private static String getWinningNumbers(Scanner scanner, ResultView resultView) {
        resultView.winningNumberComment();
        return scanner.next();
    }

    private static int getMoney(Scanner scanner, InputView inputView) {
        inputView.inputMoneyComment();
        return scanner.nextInt();
    }
}
