package com.example.chess.Models;

import com.example.chess.Controllers.PlayFieldController;
import com.example.chess.MainApp;
import com.example.chess.Models.Figures.Bishop;
import com.example.chess.Models.Figures.Pawn;
import com.example.chess.Models.Figures.King;
import com.example.chess.Models.Figures.Queen;
import com.example.chess.Models.Figures.Rook;
import com.example.chess.Models.Figures.Knight;
import javafx.css.SizeUnits;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract public class PlayField {

    static public final String checkStateMassage = "Still check";

    static public ArrayList<ArrayList<Figure>> field = new ArrayList<ArrayList<Figure>>();

    static public ArrayList<Figure> playingFigures = new ArrayList<>();

    static public ArrayList<Figure> killedBlackFigures = new ArrayList<>();

    static public ArrayList<Figure> killedWhiteFigures = new ArrayList<>();

    static public Player whitePlayer;

    static public Player blackPlayer;

    static public Figure.Color whoseMove = null;

    static public Figure chosenFigure = null;

    static public boolean checkState = false;

    static public void initGame(Player firstPlayer, Player secondPlayer, PlayFieldController playFieldController) {
        // Заполнение контейнера фигур основными фигурами
        Collections.addAll(playingFigures,
                new Rook(playFieldController.black_rook_1, Figure.Color.BLACK, 0, 0, field),
                new Knight(playFieldController.black_knight_1, Figure.Color.BLACK, 0, 1, field),
                new Bishop(playFieldController.black_bishop_1, Figure.Color.BLACK, 0, 2, field),
                new King(playFieldController.black_king, Figure.Color.BLACK, 0, 3, field),
                new Queen(playFieldController.black_queen, Figure.Color.BLACK, 0, 4, field),
                new Bishop(playFieldController.black_bishop_2, Figure.Color.BLACK, 0, 5, field),
                new Knight(playFieldController.black_knight_2, Figure.Color.BLACK, 0, 6, field),
                new Rook(playFieldController.black_rook_2, Figure.Color.BLACK, 0, 7, field),

                new Rook(playFieldController.white_rook_1, Figure.Color.WHITE, 7, 0, field),
                new Knight(playFieldController.white_knight_1, Figure.Color.WHITE, 7, 1, field),
                new Bishop(playFieldController.white_bishop_1, Figure.Color.WHITE, 7, 2, field),
                new King(playFieldController.white_king, Figure.Color.WHITE, 7, 3, field),
                new Queen(playFieldController.white_queen, Figure.Color.WHITE, 7, 4, field),
                new Bishop(playFieldController.white_bishop_2, Figure.Color.WHITE, 7, 5, field),
                new Knight(playFieldController.white_knight_2, Figure.Color.WHITE, 7, 6, field),
                new Rook(playFieldController.white_rook_2, Figure.Color.WHITE, 7, 7, field));

        // Инициализация пешек
        playingFigures.add(new Pawn(playFieldController.black_pawn_1, Figure.Color.BLACK, 1, 0, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_2, Figure.Color.BLACK, 1, 1, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_3, Figure.Color.BLACK, 1, 2, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_4, Figure.Color.BLACK, 1, 3, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_5, Figure.Color.BLACK, 1, 4, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_6, Figure.Color.BLACK, 1, 5, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_7, Figure.Color.BLACK, 1, 6, field));
        playingFigures.add(new Pawn(playFieldController.black_pawn_8, Figure.Color.BLACK, 1, 7, field));

        playingFigures.add(new Pawn(playFieldController.white_pawn_1, Figure.Color.WHITE, 6, 0, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_2, Figure.Color.WHITE, 6, 1, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_3, Figure.Color.WHITE, 6, 2, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_4, Figure.Color.WHITE, 6, 3, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_5, Figure.Color.WHITE, 6, 4, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_6, Figure.Color.WHITE, 6, 5, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_7, Figure.Color.WHITE, 6, 6, field));
        playingFigures.add(new Pawn(playFieldController.white_pawn_8, Figure.Color.WHITE, 6, 7, field));

        // Заполнение игрового поля
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        field.add(new ArrayList<Figure>());
        for (int figureIndex = 0; figureIndex < playingFigures.size() / 4; ++figureIndex) {
            field.get(2).add(null);
            field.get(3).add(null);
            field.get(4).add(null);
            field.get(5).add(null);
            field.get(0).add(playingFigures.get(figureIndex));
            field.get(1).add(playingFigures.get(figureIndex + 16));
            field.get(6).add(playingFigures.get(figureIndex + 24));
            field.get(7).add(playingFigures.get(figureIndex + 8));
        }

    }

    static public void endGame() {

    }

    static public boolean isCheckMate() {
        return false;
    }

    // Вызывается при нажатии на фигуру
    static public boolean figureInFocus(String newFigureId) {
        Figure newFigure = findFigureById(newFigureId);

        // Если фигура не выбрана и не выбран первый ходящий игрок
        if (chosenFigure == null && whoseMove == null) {
            chosenFigure = newFigure;
            whoseMove = newFigure.getColor();
            return true;
        }

        // Если пытаешься взять в фокус фигуру не своего цвета
        if (chosenFigure == null && newFigure.getColor() != whoseMove) {
            return false;
        }

        // Если выбираешь фигуру своего цвета
        if (whoseMove == newFigure.getColor()) {
            chosenFigure = newFigure;
            return true;
        }

        // Если пытаешься убить фигуру
        if (whoseMove != newFigure.getColor()) {
            // В этом блоке обработка возможного убийства
            Pair<Integer, Integer> coordinates = getCellCoordinates(newFigure.getFigureModel());

            if (chosenFigure.canMakeMove(coordinates.getKey(), coordinates.getValue())) {
                StackPane parentNode = (StackPane) (newFigure.getFigureModel().getParent());

                String resultOfMove = moveTo((ImageView) parentNode.getChildren().get(0));
                kill(newFigure);

                if (checkState && resultOfMove.equals(checkStateMassage)) {
                    undoKill(newFigure);
                } else {
                    parentNode.getChildren().remove(newFigure.getFigureModel());
                }

            }
        }

        return false;

    }

    // Главный регулирующий метод хода. Вызывает метод проверки возможности хода для каждой фигуры и меняет UI.
    static public String moveTo(ImageView clickedCell) {

        if (chosenFigure != null && chosenFigure.getColor() == whoseMove) {

            Pair<Integer, Integer> coordinates = getCellCoordinates(clickedCell);

            if (chosenFigure.canMakeMove(coordinates.getKey(), coordinates.getValue())) {

                // Проверяем, допустим ли ход, если уже есть шах
                if (checkState && isStillCheckAfterMove(coordinates.getKey(), coordinates.getValue())) {
                    return checkStateMassage;
                } else {
                    checkState = false;
                }

                updateField(chosenFigure.getCoordinates().getKey(),
                        chosenFigure.getCoordinates().getValue(), coordinates.getKey(), coordinates.getValue());

                chosenFigure.makeMove(coordinates.getKey(), coordinates.getValue());

                // Пермещение фигуры в новый StackPane
                ((StackPane) clickedCell.getParent()).getChildren().add(chosenFigure.getFigureModel());

                // Изменение переменной хода (если ходили белые - ходят черные, и наоборот)
                whoseMove = chosenFigure.getColor() == Figure.Color.WHITE ? Figure.Color.BLACK : Figure.Color.WHITE;

                // Отладночная функция печати поля в консоль
                printField();

                chosenFigure = null;

                // Если после хода - шах - как-то об этом заявляем
                if (isCheck()) {
                    checkState = true;
                    return "Шах - " + whoseMove;
                }
            }
        }
        return null;
    }

    static private void kill(Figure figureToKill) {
        playingFigures.removeIf(figure -> figure == figureToKill);
        if (figureToKill.getColor() == Figure.Color.WHITE) {
            killedWhiteFigures.add(figureToKill);
        } else {
            killedBlackFigures.add(figureToKill);
        }
    }

    static private void undoKill(Figure figureToRestore) {
        field.get(figureToRestore.getCoordinates().getKey()).set(figureToRestore.getCoordinates().getValue(),
                figureToRestore);
        if (figureToRestore.getColor() == Figure.Color.WHITE) {
            killedWhiteFigures.removeIf(figure -> figure == figureToRestore);
        } else {
            killedBlackFigures.removeIf(figure -> figure == figureToRestore);
        }
    }

    // Метод для получения координат кликнутой клетки
    static private Pair<Integer, Integer> getCellCoordinates(ImageView clickedCell) {
//        System.out.println(GridPane.getRowIndex(clickedCell.getParent()));
//        System.out.println(GridPane.getColumnIndex(clickedCell.getParent()));
        return new Pair<>(GridPane.getRowIndex(clickedCell.getParent()),
                GridPane.getColumnIndex(clickedCell.getParent()));

    }

    static private void updateField(int previousRow, int previousColumn, int newRow, int newColumn) {
        field.get(newRow).set(newColumn, field.get(previousRow).get(previousColumn));

        field.get(previousRow).set(previousColumn, null);
    }

    // Метод для нахождения объекта фигуры из списка по id из верстки
    static private Figure findFigureById(String newFigureId) {
        for (Figure figure : playingFigures) {
            if (figure.getFigureModel().idProperty().getValueSafe().equals(newFigureId)) {
                return figure;
            }
        }
        return null;
    }

    static private boolean isCheck() {

        // Ищем короля цвета текущего хода
        Figure king = null;
        for (Figure figure : playingFigures) {
            if (figure.getColor() == whoseMove && figure.getClass() == King.class) {
                king = figure;
                break;
            }
        }

        // Проверяем, под боем ли он
        for (Figure figure : playingFigures) {
            if (figure.getColor() != whoseMove && figure.canMakeMove(king.getCoordinates().getKey(),
                    king.getCoordinates().getValue())) {
                System.out.println(figure);
                System.out.println(playingFigures);
                return true;
            }
        }

        return false;
    }

    static private boolean isStillCheckAfterMove(int row, int column) {
        // Моделируем ход
        Pair<Integer, Integer> oldCoordinates = chosenFigure.getCoordinates();

        chosenFigure.makeMove(row, column);

        Figure figureToDelete = field.get(row).get(column) != null ? field.get(row).get(column) : null;

        playingFigures.removeIf(figure -> figure == figureToDelete);

        updateField(oldCoordinates.getKey(), oldCoordinates.getValue(), row, column);
        // Проверяем на шах
        if (isCheck()) {
            updateField(row, column, oldCoordinates.getKey(), oldCoordinates.getValue());
            if (figureToDelete != null) {
                playingFigures.add(figureToDelete);
            }
            updateField(row, column, oldCoordinates.getKey(), oldCoordinates.getValue());
            if (figureToDelete != null) {
                playingFigures.add(figureToDelete);
            }

            chosenFigure.makeMove(oldCoordinates.getKey(), oldCoordinates.getKey());
            return true;
        }

        chosenFigure.makeMove(oldCoordinates.getKey(), oldCoordinates.getKey());
        return false;
    }

    static private void printField() {
        for (ArrayList<Figure> row : field) {
            for (Figure figure : row) {
                System.out.print(figure != null ? figure.getColor() + " " : "null ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
