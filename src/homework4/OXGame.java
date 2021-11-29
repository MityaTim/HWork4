package homework4;

import java.util.Random;
import java.util.Scanner;

public class OXGame {

    static final int SIZE = 5;
    static final int WIN_LENGTH = 5;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char [][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void initMAP() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMAP(){
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d",i+1);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2c", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("input X, Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x){
        if ((y < 0) || (x < 0) || (y >= SIZE) || (x >= SIZE)) {
            return false;
        }
        return (map[y][x] == DOT_EMPTY);
    }

    public static void aiTurn(){
        int horizonCount;
        int verticalCount;
        int lrdiagonalCount;
        int rldiagonalCount;
        boolean ai_put_data = false;
        int k = 1;
        if (ai_put_data == false){
            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }
                horizonCount = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_X){
                        horizonCount++;
                    }
                    else{
                        horizonCount = 0;
                    }
                    if (horizonCount == WIN_LENGTH-1){
                        if (isCellValid(i,j+1) == true) {
                            map[i][j+1] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                        else if (isCellValid(i,j-horizonCount) == true) {
                            map[i][j-horizonCount] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                    }
                }
            }
        }

        if (ai_put_data == false){

            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }
                verticalCount = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] == DOT_X){
                        verticalCount++;
                    }
                    else{
                        verticalCount = 0;
                    }
                    if (verticalCount == WIN_LENGTH-1){
                        if (isCellValid(j+1,i) == true) {
                            map[j+1][i] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                        else if (isCellValid(j-verticalCount,i) == true) {
                            map[j-verticalCount][i] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                    }
                }
            }
        }

        if (ai_put_data == false){
            rldiagonalCount = 0;
            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }

                if (map[SIZE-1-i][i] == DOT_X){
                    rldiagonalCount++;
                }
                else{
                    rldiagonalCount = 0;
                }

                if (rldiagonalCount == WIN_LENGTH-1){
                    if (isCellValid(SIZE-1-(i+1),i+1) == true) {
                        map[SIZE-1-(i+1)][i+1] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                    else if (isCellValid(SIZE-1-(i-rldiagonalCount),(i-rldiagonalCount)) == true) {
                        map[SIZE-1-(i-rldiagonalCount)][i-rldiagonalCount] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                }
            }
        }

        if (ai_put_data == false){

            lrdiagonalCount = 0;
            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }

                if (map[i][i] == DOT_X){
                    lrdiagonalCount++;
                }
                else{
                    lrdiagonalCount = 0;
                }

                if (lrdiagonalCount == WIN_LENGTH-1){
                    if (isCellValid(i+1,i+1) == true) {
                        map[i+1][i+1] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                    else if (isCellValid((i-lrdiagonalCount),(i-lrdiagonalCount)) == true) {
                        map[(i-lrdiagonalCount)][i-lrdiagonalCount] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                }
            }
        }

        if (ai_put_data == false){

            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }
                horizonCount = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_X){
                        horizonCount++;
                    }
                    else{
                        horizonCount = 0;
                    }
                    if (horizonCount >= WIN_LENGTH-2){
                        if (isCellValid(i,j+1) == true) {
                            map[i][j+1] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                        else if (isCellValid(i,j-horizonCount) == true) {
                            map[i][j-horizonCount] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                    }
                }
            }
        }

        if (ai_put_data == false){

            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }
                verticalCount = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] == DOT_X){
                        verticalCount++;
                    }
                    else{
                        verticalCount = 0;
                    }
                    if (verticalCount >= WIN_LENGTH-2){
                        if (isCellValid(j+1,i) == true) {
                            map[j+1][i] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                        else if (isCellValid(j-verticalCount,i) == true) {
                            map[j-verticalCount][i] = DOT_O;
                            ai_put_data = true;
                            break;
                        }
                    }
                }
            }
        }

        if (ai_put_data == false){
            rldiagonalCount = 0;
            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }

                if (map[SIZE-1-i][i] == DOT_X){
                    rldiagonalCount++;
                }
                else{
                    rldiagonalCount = 0;
                }

                if (rldiagonalCount == WIN_LENGTH-2){
                    if (isCellValid(SIZE-1-(i+1),i+1) == true) {
                        map[SIZE-1-(i+1)][i+1] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                    else if (isCellValid(SIZE-1-(i-rldiagonalCount),(i-rldiagonalCount)) == true) {
                        map[SIZE-1-(i-rldiagonalCount)][i-rldiagonalCount] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                }
            }
        }

        if (ai_put_data == false){

            lrdiagonalCount = 0;
            for (int i = 0; i < SIZE; i++) {
                if (ai_put_data == true){
                    break;
                }

                if (map[i][i] == DOT_X){
                    lrdiagonalCount++;
                }
                else{
                    lrdiagonalCount = 0;
                }

                if (lrdiagonalCount == WIN_LENGTH-2){
                    if (isCellValid(i+1,i+1) == true) {
                        map[i+1][i+1] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                    else if (isCellValid((i-lrdiagonalCount),(i-lrdiagonalCount)) == true) {
                        map[(i-lrdiagonalCount)][i-lrdiagonalCount] = DOT_O;
                        ai_put_data = true;
                        break;
                    }
                }
            }
        }

        if (ai_put_data == false){
            int x, y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;
        }
    };

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWin(char c){
        int isWinCount;

        for (int i = 0; i < SIZE; i++) {
            isWinCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c){
                    isWinCount++;
                }
                else {
                    isWinCount = 0;
                }
                if (isWinCount == WIN_LENGTH){
                    return true;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            isWinCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == c){
                    isWinCount++;
                }
                else {
                    isWinCount = 0;
                }
                if (isWinCount == WIN_LENGTH){
                    return true;
                }
            }
        }

        isWinCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == c) && (i == j)){
                    isWinCount++;
                }
                else if (i == j) {
                    isWinCount = 0;
                }
                if (isWinCount == WIN_LENGTH){
                    return true;
                }
            }
        }

        isWinCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == c) && (i == SIZE - 1 - j)){
                    isWinCount++;
                }
                else if (i == SIZE - 1 - j){
                    isWinCount = 0;
                }
                if (isWinCount == WIN_LENGTH){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Hello!");
        initMAP();
        printMAP();

        do {
            humanTurn();
            printMAP();
            if (isWin(DOT_X) == true) {
                System.out.println("Ты выиграл!");
                break;
            }
            if (isFull()){
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMAP();
            if (isWin(DOT_O) == true) {
                System.out.println("Компьютер выиграл!");
                break;
            }

        } while (!isFull());

    }
}
