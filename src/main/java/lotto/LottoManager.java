package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoManager {
    private int price = 0;
    private int nofLotto = 0; // number of lotto
    private ArrayList<Lotto> lottos = new ArrayList<Lotto>();
    private Map<LottoRank, Integer> winningStat = new HashMap<LottoRank, Integer>();

    public LottoManager(int price) {
        this.price = price;
        nofLotto = (int) (price / 1000);
        createLottos();
    }

    // 테스트용 생성자
    public LottoManager() {

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

    public String getLottoInfos() {
        String lottoInfos = nofLotto + "개를 구매했습니다.\n";
        for (Lotto lotto : lottos) {
            lottoInfos += lotto.toString() + "\n";
        }
        return lottoInfos;
    }

    public void compare(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.compare(winningNumbers, bonusNumber);
            Integer count = Objects.requireNonNullElse(winningStat.get(rank), 0);
            if (count == null) {
                winningStat.put(rank, 1);
                continue;
            }
            winningStat.put(rank, count + 1);
        }
    }

    private double getRateOfReturn() {
        double totalReturn = 0;

        for (LottoRank rank : winningStat.keySet()) {
            totalReturn += rank.getPrize() * Objects.requireNonNullElse(winningStat.get(rank), 0);
        }
        return totalReturn / price * 100;
    }

    public String getLottoResult() {
        String stat = "";

        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS) {
                continue;
            }
            String line = rank.getMatchCount() + "개 일치";
            if (rank.hasBonus()) {
                line += ", 보너스 볼 일치";
            }
            line += " (" + String.format("%,d", rank.getPrize()) + "원) - " + Objects.requireNonNullElse(
                    winningStat.get(rank), 0) + "개\n";
            stat += line;
        }
        stat += "총 수익률은 " + getRateOfReturn() + "%입니다.";

        return stat;
    }
}
