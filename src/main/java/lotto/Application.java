package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        LottoManager lottoManager;
        Lotto winningNumbers;
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

        lottoManager.compare(winningNumbers.getNumbers(), bonusNumber);
        System.out.println(lottoManager.getLottoResult());
    }
}
