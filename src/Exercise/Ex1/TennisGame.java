package Exercise.Ex1;

public class TennisGame {
    public static String getScore(int player1Score, int player2Score) {
        String score = "";

        if (player1Score == player2Score) {
            score = handleEqualScores(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getWinner(player1Score, player2Score);
        } else {
            score = getCurrentScore(player1Score, player2Score);
        }

        return score;
    }

    private static String handleEqualScores(int player1Score) {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String getCurrentScore(int player1Score, int player2Score) {
        String score = "";
        for (int i = 1; i <= 2; i++) {
            int tempScore = (i == 1) ? player1Score : player2Score;

            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }

            if (i == 1) {
                score += "-"; // Add dash after the first player's score
            }
        }

        return score;
    }

    private static String getWinner(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;

        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}