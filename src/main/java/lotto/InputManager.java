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
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없습니다. 숫자만 입력해 주세요.");
        }
        return number;
    }

    private void inspectNumberRange(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void inspectNumberUnit(int n) {
        if (n % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    public int parsePrice(String text) {
        int price = parseInt(text);
        inspectNumberUnit(price);
        return price;
    }

    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String text = Console.readLine();
        return parsePrice(text);
    }

    public Lotto parseWinningNumbers(String text) {
        String[] parts = text.split(",");
        List<Integer> numbers = new ArrayList<Integer>();
        for (String part : parts) {
            int n = parseInt(part);
            inspectNumberRange(n);
            numbers.add(n);
        }

        return new Lotto(numbers);
    }

    public Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String text = Console.readLine();
        return parseWinningNumbers(text);
    }

    public int parseBonusNumber(String text) {
        int n = parseInt(text);
        inspectNumberRange(n);
        return n;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String text = Console.readLine();
        return parseBonusNumber(text);
    }
}
