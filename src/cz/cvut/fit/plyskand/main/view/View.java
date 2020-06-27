package cz.cvut.fit.plyskand.main.view;

public interface View {

    /** This method prints all area. */
    void print() throws InterruptedException;

    /** Set specific sign to area on concrete position. */
    void setSignOnPosition(Pos position, char sign);
}
