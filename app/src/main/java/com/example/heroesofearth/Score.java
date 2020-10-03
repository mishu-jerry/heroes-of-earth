package com.example.heroesofearth;

import com.example.heroesofearth.pojos.Challenge;

import java.util.ArrayList;

public class Score {

    public static int getCompletionRate(ArrayList<Object> list) {
        double nChallenges = 0;
        double nCompletedChallenges = 0;

        for (Object object : list) {
            if (object instanceof Challenge) {
                nChallenges++;
                if (((Challenge) object).isCompleted()) nCompletedChallenges++;
            }
        }

        double rate = nCompletedChallenges / nChallenges * 100.00;
        return (int) rate;
    }

    public static int getExperienceLevel() {
        return 1;
    }

    public static ArrayList<Challenge> getIncompleteChallenges(ArrayList<Object> list) {
        ArrayList<Challenge> incompleteChallenges = new ArrayList<>();

        for (Object object : list) {
            if (object instanceof Challenge) {
                Challenge challenge = ((Challenge) object);

                if (!challenge.isCompleted()) {
                    incompleteChallenges.add(challenge);
                }
            }
        }

        return incompleteChallenges;
    }

    public static void resetChallengeCompletions(ArrayList<Object> list) {
        if (list != null) {
            for (Object object : list) {
                if (object instanceof Challenge) {
                    Challenge challenge = ((Challenge) object);
                    challenge.setCompleted(false);
                }
            }
        }
    }

}
