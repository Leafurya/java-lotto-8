package lotto;

public class Application {
    private static final InputManager inputManager = new InputManager();
    private static LottoManager lottoManager;
    private static Lotto winningNumbers;
    private static int bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getPrice();
        getWinningNumbers();
        getBonusNumber();

        lottoManager.compare(winningNumbers.getNumbers(), bonusNumber);
        System.out.println(lottoManager.getLottoResult());
    }

    private static void getPrice() {
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
    }

    private static void getWinningNumbers() {
        while (true) {
            try {
                winningNumbers = inputManager.getWinningNumbers();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getBonusNumber() {
        while (true) {
            try {
                bonusNumber = inputManager.getBonusNumber();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
