package lotto;

public enum LottoRank {
    MISS(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    LottoRank(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    // 당첨 개수와 보너스 여부로 등수 찾기
    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && !rank.hasBonus) {
                return rank;
            }
        }
        return MISS;
    }

    public String toString() {
        return "공통:" + matchCount + " 보너스여부:" + hasBonus + " 상금:" + prize;
    }
}
