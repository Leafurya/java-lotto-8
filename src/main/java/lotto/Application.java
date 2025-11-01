package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        LottoManager lottoManager;
        List<Integer> winningNumbers;
        int bonusNumber;

        while (true) {
            try {
                int price = inputManager.getPrice();
                lottoManager = new LottoManager(price);
                System.out.println("\n" + lottoManager.getLottoInfos());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                winningNumbers = inputManager.getWinningNumbers();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumber = inputManager.getBonusNumber();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoManager.compare(winningNumbers, bonusNumber);
        System.out.println(lottoManager.getLottoResult());
    }
}
