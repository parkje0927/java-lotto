package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(LottoStrategy lottoStrategy, LottoCount lottCount) {
        this.lottos = createLottos(lottoStrategy, lottCount);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(LottoStrategy lottoStrategy, LottoCount lottCount) {
        return lottCount.play(lottoStrategy);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
