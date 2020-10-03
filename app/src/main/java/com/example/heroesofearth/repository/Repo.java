
/**
 * NOTE:
 * This is a DEMO implementation, NOT for production.
 * Data is not persistent if the app session is destroyed.
 */

package com.example.heroesofearth.repository;

import com.example.heroesofearth.pojos.Challenge;

import java.util.ArrayList;

public class Repo {

    public static ArrayList<Object> dailyChallengesList;
    public static ArrayList<Object> carbonFootprintChallengesList;

    public static void init() {

        initCarbonFootprintChallenges();
        initDailyChallenges();
    }

    private static void initDailyChallenges() {
        dailyChallengesList = new ArrayList<>();

        dailyChallengesList.add("Household energy uses");
        dailyChallengesList.add(new Challenge("Switch lights off"));
        dailyChallengesList.add(new Challenge("Use energy efficient lights"));

        dailyChallengesList.add("Eating habits");
        dailyChallengesList.add(new Challenge("Eat less meat"));
        dailyChallengesList.add(new Challenge("Don't waste food"));
        dailyChallengesList.add(new Challenge("Eat organic and local foods"));

        dailyChallengesList.add("Transportation");
        dailyChallengesList.add(new Challenge("Drive less"));
        dailyChallengesList.add(new Challenge("Use a public transport"));
        dailyChallengesList.add(new Challenge("Avoid flights"));

        dailyChallengesList.add("Recycle and Reuse");
        dailyChallengesList.add(new Challenge("Reuse plastic bottles"));
        dailyChallengesList.add(new Challenge("Use reusable bags"));
        dailyChallengesList.add(new Challenge("Wear vintage or recycled cloths"));

        dailyChallengesList.add("Personal habits");
        dailyChallengesList.add(new Challenge("Complete shower within 5 minutes"));
    }

    private static void initCarbonFootprintChallenges() {
        carbonFootprintChallengesList = new ArrayList<>();

        carbonFootprintChallengesList.add("Mark the items those match with your average daily usage. " +
                "If you are not sure about an item, you may keep it unchecked");

        carbonFootprintChallengesList.add(new Challenge("Electricity: More than 2000 watts per month"));
        carbonFootprintChallengesList.add(new Challenge("Natural Gas: More than $115 per month"));
        carbonFootprintChallengesList.add(new Challenge("Heating Oil: More than 115 gallons"));
        carbonFootprintChallengesList.add(new Challenge("Coal: More than 41 pounds a day"));
        carbonFootprintChallengesList.add(new Challenge("LPG: More than 10 cylinders a year"));
        carbonFootprintChallengesList.add(new Challenge("I Use Propane"));
        carbonFootprintChallengesList.add(new Challenge("Burn fire woods: All the day"));
        carbonFootprintChallengesList.add(new Challenge("Flights: I fly too often"));
        carbonFootprintChallengesList.add(new Challenge("Ride Cars: More than 9 hours a day"));
        carbonFootprintChallengesList.add(new Challenge("Ride Motor Bikes: More than 200 kilometers a day"));
    }
}
