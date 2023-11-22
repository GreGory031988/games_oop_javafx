package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;

class BishopBlackTest {
    @Test
    void whenCheckPositionIsValid() {
        BishopBlack bishopBlack = new BishopBlack(C8);
        assertThat(bishopBlack.position()).isEqualTo(C8);
    }

    @Test
    void whenCheckCopyIsValid() {
        BishopBlack bishopBlack = new BishopBlack(C8);
        var rsl = bishopBlack.copy(D7).position();
        assertThat(rsl).isEqualTo(D7);
    }

    @Test
    void whenCheckWayIsValid() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        var rsl = bishopBlack.way(G5);
        assertThat(rsl).isEqualTo(new Cell[] {D2, E3, F4, G5});
    }

    @Test
    void whenCheckWayIsNotValid() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(B1));
        assertThat(exception.getMessage()).
                isEqualTo("Could not way by diagonal from %s to %s", C1, B1);
    }
}