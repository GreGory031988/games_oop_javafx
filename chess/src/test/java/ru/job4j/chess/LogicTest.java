package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KnightBlack;
import static ru.job4j.chess.firuges.Cell.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(
                FigureNotFoundException.class,
                () -> logic.move(C1, H6));
        assertThat(exception.getMessage()).
                isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new BishopBlack(B3));
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> logic.move(C1, A4));
        assertThat(exception.getMessage())
                .isEqualTo("Could not way by diagonal from %s to %s", C1, A4);
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new KnightBlack(E3));
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> logic.move(C1, F4));
        assertThat(exception.getMessage())
                .isEqualTo("The cell is occupied", E3);
    }
}