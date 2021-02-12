import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guidesign {
    public guidesign() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skrivyta.setText("");
            }
        });
        copyTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clipboard kopiera = Toolkit.getDefaultToolkit().getSystemClipboard();
                kopiera.setContents((Transferable) skrivyta, null);

            }
        });
    }

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
    private JButton clearButton;
    private JButton copyTextButton;

}
