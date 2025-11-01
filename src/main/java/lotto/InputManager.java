package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private int parseInt(String text) {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 숫자로 변환할 수 없습니다. 숫자만 입력해 주세요.");
        }
        return number;
    }

    public int inspectPrice(String text) {
        int price = parseInt(text);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 1000원 단위로 입력해 주세요.");
        }
        return price;
    }

    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String text = Console.readLine();
        return inspectPrice(text);
    }

    public List<Integer> inspectWinningNumbers(String text) {
        String[] parts = text.split(",");
        List<Integer> numbers = new ArrayList<Integer>();
        for (String part : parts) {
            numbers.add(parseInt(part));
        }
        return numbers;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String text = Console.readLine();
        return inspectWinningNumbers(text);
    }

    public int inspectBonusNumber(String text) {
        return parseInt(text);
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String text = Console.readLine();
        return inspectBonusNumber(text);
    }
}
