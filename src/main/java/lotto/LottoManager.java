package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private int nofLotto = 0; // number of lotto
    private ArrayList<Lotto> lottos = new ArrayList<Lotto>();
    private Map<LottoRank, Integer> winningRate;

    public LottoManager(int price) {
        nofLotto = (int) (price / 1000);
        createLottos();
    }

    public int getNofLotto() {
        return nofLotto;
    }

    private void createLottos() {
        for (int i = 0; i < nofLotto; i++) {
            createLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void createLotto(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

    public void compare(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.compare(winningNumbers, bonusNumber);
            Integer count = winningRate.get(rank);
            if (count == null) {
                winningRate.put(rank, 1);
                continue;
            }
            winningRate.put(rank, count + 1);
        }
    }

    public Map<LottoRank, Integer> getWinningRate() {
        return winningRate;
    }
}
