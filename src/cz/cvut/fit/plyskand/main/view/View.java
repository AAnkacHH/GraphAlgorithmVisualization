package cz.cvut.fit.plyskand.main.view;

public interface View {

    void print() throws InterruptedException;

    void setSignOnPosition(Pos position, char sign);
}
