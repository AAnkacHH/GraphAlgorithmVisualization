package cz.cvut.fit.plyskand.main.view;

public class ConsoleView implements View {

    private Area area;

    private MyConsole console;

    public ConsoleView(Area area, MyConsole console) {
        this.area = area;
        this.console = console;
    }

    @Override
    public void print() throws InterruptedException {
        Thread.sleep(100);
        console.addText(area.toString());
    }

    @Override
    public void setSignOnPosition(Pos position, char sign) {
        this.area.setChar(position, sign);
    }
}
