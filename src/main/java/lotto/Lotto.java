package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void sort() {
//        numbers.sort(null);
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }

    public LottoRank compare(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> sharedNumbers = new HashSet<>(numbers);
        sharedNumbers.retainAll(winningNumbers);

        return LottoRank.valueOf(sharedNumbers.size(), numbers.contains(bonusNumber));
    }
}
