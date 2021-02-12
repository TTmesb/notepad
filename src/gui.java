import javax.swing.*;

public class gui {
    public static void main(String[] args) {
        JFrame fönster = new JFrame("Anteckningar");
        JPanel panel = new JPanel();
        JTextArea skrivyta = new JTextArea(15,15);

        fönster.add(panel);
        panel.add(skrivyta);

        fönster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fönster.setVisible(true);
    }
}