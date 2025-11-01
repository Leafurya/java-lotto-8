package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputParsingTest {
    @Test
    void 가격_파싱_테스트() {
        InputManager im = new InputManager();

        assertThat(im.parsePrice("1000")).isEqualTo(1000);
        assertThatThrownBy(() -> im.parsePrice("1100")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_파싱_테스트() {
        InputManager im = new InputManager();

        Lotto winningNumber = im.parseWinningNumbers("1,2,3,4,5,6");
        assertThat(winningNumber.getNumbers()).contains(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> im.parseWinningNumbers("1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");

        assertThatThrownBy(() -> im.parseWinningNumbers("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 숫자를 입력해 주세요.");

        assertThatThrownBy(() -> im.parseWinningNumbers("1,2,3,4,5,a5")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 변환할 수 없습니다.");

        assertThatThrownBy(() -> im.parseWinningNumbers("1,2,3,4,5,55")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호_파싱_테스트() {
        InputManager im = new InputManager();

        assertThat(im.parseBonusNumber("20")).isEqualTo(20);
        assertThatThrownBy(() -> im.parseBonusNumber("a5")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 변환할 수 없습니다.");
        assertThatThrownBy(() -> im.parseBonusNumber("55")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
