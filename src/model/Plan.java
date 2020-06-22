package model;

public class Plan {
    private String plan;
    private double goal;
    private double saveMoney;

    public Plan(String plan, double goal, double saveMoney) {
        this.plan = plan;
        this.goal = goal;
        this.saveMoney = saveMoney;
    }

    public String toString(){
        double months = goal / saveMoney;

        return  "Zbieram na " + plan + ", muszę uzbierać " + goal + ", miesięcznie odkładam " + saveMoney +"\n"
                + "Będziesz zbierał: " + Math.round(months) + " miesięcy";
    }
}
