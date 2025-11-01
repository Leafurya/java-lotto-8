package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_테스트() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(list);

        LottoRank rank = lotto.compare(List.of(1, 7, 8, 9, 10, 11), 12);
        assertThat(rank.toString()).isEqualTo("공통:0 보너스여부:false 상금:0");

        rank = lotto.compare(List.of(1, 2, 8, 9, 10, 11), 12);
        assertThat(rank.toString()).isEqualTo("공통:0 보너스여부:false 상금:0");

        rank = lotto.compare(List.of(1, 2, 3, 9, 10, 11), 12);
        assertThat(rank.toString()).isEqualTo("공통:3 보너스여부:false 상금:5000");

        rank = lotto.compare(List.of(1, 2, 3, 4, 10, 11), 12);
        assertThat(rank.toString()).isEqualTo("공통:4 보너스여부:false 상금:50000");

        rank = lotto.compare(List.of(1, 2, 3, 4, 5, 11), 12);
        assertThat(rank.toString()).isEqualTo("공통:5 보너스여부:false 상금:1500000");

        rank = lotto.compare(List.of(1, 2, 3, 4, 5, 11), 6);
        assertThat(rank.toString()).isEqualTo("공통:5 보너스여부:true 상금:30000000");

        rank = lotto.compare(List.of(1, 2, 3, 4, 5, 6), 12);
        assertThat(rank.toString()).isEqualTo("공통:6 보너스여부:false 상금:2000000000");
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
