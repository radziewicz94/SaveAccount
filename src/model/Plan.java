package model;

public class Plan {
    private String plan;
    private double goal;

    public Plan(String plan, double goal) {
        this.plan = plan;
        this.goal = goal;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Cel " + plan + ", do uzbierania " + goal;
    }
}
