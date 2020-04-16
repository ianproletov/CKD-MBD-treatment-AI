package ru.proletov.ckdmbd.models;

public class State {
    private boolean state;
    private Recommendation recommendation;

    public State(final boolean state, final Recommendation recommendation) {
        this.state = state;
        this.recommendation = recommendation;
    }

    public boolean getState() {
        return state;
    }

    public Recommendation getResult() {
        return recommendation;
    }

}