import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guidesign {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad 2.0++");

        frame.setContentPane(new guidesign().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JMenu menu = new JMenu("Arkiv");
        JMenuBar menubar = new JMenuBar();
        JMenuItem spara = new JMenuItem("Spara din text bror");
        JMenuItem ny = new JMenuItem("Ny Textfil");
        menu.add(ny);
        menu.add(spara);
        menubar.add(menu);
        frame.setJMenuBar(menubar);


    }
    private JPanel panel1;
    private JTextArea skrivyta;
    private JButton saveButton;
    private JButton button2;
    private JButton copyTextButton;

}
