package com.example.lab8;

public class Mood {
    private String currentMood;
    private String suggestedActivity;
    private String activityURL;


    public String getMood() {
        return currentMood;
    }

    public String getSuggestedActivity() {
        return suggestedActivity;
    }

    public String getActivityURL() {
        return activityURL;
    }

    public void setMood(String mood) {
        currentMood = mood;
        switch (currentMood) {
            case "Happy":
                suggestedActivity = "singing";
                activityURL = "https://takelessons.com/blog/top-karaoke-songs-z02";
                break;
            case "Sad":
                suggestedActivity = "calling a friend";
                activityURL = "https://depression.org.nz/get-better/self-help/";
                break;
            case "Stressed":
                suggestedActivity = "exercising";
                activityURL = "https://www.acefitness.org/education-and-resources/lifestyle/blog/6593/top-25-at-home-exercises";
                break;
            case "Motivated":
                suggestedActivity = "working";
                activityURL = "https://www.inc.com/larry-kim/these-24-productivity-tips-will-help-you-start-off-2018-right.html";
                break;
            case "Content":
                suggestedActivity = "meditating";
                activityURL = "https://www.mindful.org/how-to-meditate/";
                break;
        }
    }
}
