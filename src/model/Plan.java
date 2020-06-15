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
    public void printGoal(){
        System.out.println("Zbieram na " + plan + ", muszę uzbierać " + goal + ", miesięcznie odkładam " + saveMoney);
        double months = goal / saveMoney;

        System.out.println("Będziesz zbierał: " + months);
    }

}
