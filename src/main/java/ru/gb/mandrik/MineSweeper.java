package ru.gb.mandrik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper extends JFrame {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static int WIDTH = 1;
    public static int HEIGHT = 1;
    public static int MINE_COUNT = 1;

    public static final int MINE = 1000;
    public static final int EMPTY = 0;
    public static final int CELL_OPEN = 1;
    public static final int CELL_CLOSE = 0;
    public static final int CELL_FLAG = -1;

    public MineSweeper() {
        setTitle("Mine Sweeper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 350, 350);
        setLayout(new BorderLayout());

        ActionListener levelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                switch (button.getText()) {
                    case "1":
                        HEIGHT = 10;
                        WIDTH = 10;
                        MINE_COUNT = 10;
                        break;
                    case "2":
                        HEIGHT = 15;
                        WIDTH = 15;
                        MINE_COUNT = 40;
                        break;
                    case "3":
                        HEIGHT = 20;
                        WIDTH = 20;
                        MINE_COUNT = 80;
                        break;
                    default:
                        System.out.println("Неправильно введен уровень сложности!");
                        break;
                }
            }
        };

        JPanel levelPanel = new JPanel();
        GridLayout levelLayout = new GridLayout(1, 3, 10, 10);
        levelPanel.setLayout(levelLayout);

        for (int i = 1; i < 4; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(levelListener);
            levelPanel.add(button);
        }

        JLabel levelLabel = new JLabel("Введите уровень сложности:");
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(levelLabel, BorderLayout.CENTER);
        add(levelPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MineSweeper();
//        if (userWin) {
//            System.out.println("Поздравляем!");
//        } else {
//            System.out.println("БАБАХ!");
//        }
    }

    public static boolean play() {
        boolean win = true;
        boolean isPassMove;
        int[][] board = generateBoard();
        int[][] moves = new int[HEIGHT][WIDTH];
        do {
            isPassMove = move(board, moves);
            win = isWin(moves);
        } while (isPassMove && !win);
        return isPassMove;
    }

    public static boolean isWin(int[][] moves) {
        int openCell = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (moves[i][j] == CELL_OPEN) {
                    openCell++;
                }
            }
        }
        return openCell + MINE_COUNT == HEIGHT * WIDTH;
    }

    public static boolean move(int[][] board, int[][] moves) {
        Scanner scanner = new Scanner(System.in);
        printBoard(board, moves);
        int row, line;
        while (true) {
            System.out.print("Ваш ход (стобец, строка (например A1)): ");
            String move = scanner.nextLine();
            row = move.charAt(0) - 'A';
            line = Integer.parseInt(move.substring(1));
            if (row < WIDTH && row >= 0 && line < HEIGHT && line >= 0) {
                break;
            }
            System.out.println("Введите координаты внутри игрового поля!");
        }
        if (board[line][row] != MINE) {
            moves[line][row] = CELL_OPEN;
            return true;
        }
        finalBoard(board);
        return false;
    }

    public static int[][] generateBoard() {
        int[][] board = new int[HEIGHT][WIDTH];
        Random random = new Random();
        int mines = MINE_COUNT;
        if (MINE_COUNT > HEIGHT * WIDTH) {
            System.out.print("Игровое поле не заполнено минами.\nКолличество мин превышает колличество пустых клеток.\nВведите другое колличество мин.\n");
        } else {
            while (mines > 0) {
                int x, y;
                do {
                    x = random.nextInt(HEIGHT);
                    y = random.nextInt(WIDTH);
                } while (board[x][y] == 1000);
                board[x][y] = 1000;
                mines--;
            }
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE) {
                    continue;
                }
                int mCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || k >= HEIGHT || l < 0 || l >= WIDTH) {
                            continue;
                        }
                        if (board[k][l] == MINE) {
                            mCount++;
                        }
                    }
                }
                board[i][j] = mCount;
            }
        }
        return board;
    }

    public static void printBoard(int[][] board, int[][] moves) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {
                if (moves[i][j] == CELL_CLOSE) {
                    System.out.print("[]");
                    continue;
                }
                if (moves[i][j] == CELL_FLAG) {
                    System.out.print(" P");
                    continue;
                }
                String code = getColorCode(board[i][j]);
                System.out.print(code);
                if (board[i][j] == EMPTY) {
                    System.out.print(" .");
                } else if (board[i][j] == MINE) {
                    System.out.print(" *");
                } else {
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }

    public static String getColorCode(int i) {
        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }
    }

    public static void finalBoard(int[][] board) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {
                String code = getColorCode(board[i][j]);
                System.out.print(code);
                if (board[i][j] == EMPTY) {
                    System.out.print(" .");
                } else if (board[i][j] == MINE) {
                    System.out.print(" *");
                } else {
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }
}

