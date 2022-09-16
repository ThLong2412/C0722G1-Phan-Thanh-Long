package ss8_clean_code_and_refactoring.exersice;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String result = "";
        boolean isDraw = player1Score == player2Score;
        if (isDraw) {
            result = scoreObtained(player1Score);
        } else {
            boolean moreThan4Score = player1Score >= 4 || player2Score >= 4;
            if (moreThan4Score) {
                result = winner(player1Score, player2Score);
            } else {
                result = scoreObtained2(player1Score, player2Score, result);
            }
        }
        return result;
    }

    public static String scoreObtained(int player1Score) {
        String result;
        final int ZERO = 0;
        final int A_POINT = 1;
        final int TWO_POINT = 2;
        final int THREE_POINT = 3;
        switch (player1Score) {
            case ZERO:
                result = "Love-All";
                break;
            case A_POINT:
                result = "Fifteen-All";
                break;
            case TWO_POINT:
                result = "Thirty-All";
                break;
            case THREE_POINT:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }

    public static String winner(int player1Score, int player2Score) {
        String result;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) result = "Advantage player1";
        else if (minusResult == -1) result = "Advantage player2";
        else if (minusResult >= 2) result = "Win for player1";
        else result = "Win for player2";
        return result;
    }

    public static String scoreObtained2(int player1Score, int player2Score, String result) {
        int tempScore;
        final int ZERO = 0;
        final int A_POINT = 1;
        final int TWO_POINT = 2;
        final int THREE_POINT = 3;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                result += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case ZERO:
                    result += "Love";
                    break;
                case A_POINT:
                    result += "Fifteen";
                    break;
                case TWO_POINT:
                    result += "Thirty";
                    break;
                case THREE_POINT:
                    result += "Forty";
                    break;
            }
        }
        return result;
    }
}

