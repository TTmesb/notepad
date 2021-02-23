import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

public class guidesign {
    public guidesign() {
        JMenu menu = new JMenu("Arkiv");
        menubar = new JMenuBar();
        JMenuItem spara = new JMenuItem("Spara din text bror som");
        JMenuItem ny = new JMenuItem("Ny Textfil");
        JMenuItem open = new JMenuItem("Öppna ");
        donate = new JMenuItem("Donera");

        menubar.add(menu);
        menu.add(ny);
        menu.add(open);
        menu.add(spara);
        menu.add(donate);

        clearButton.addActionListener(e -> skrivyta.setText(""));
        ny.addActionListener(e -> skrivyta.setText(""));

        copyTextButton.addActionListener(e -> {
            Clipboard kopiera = Toolkit.getDefaultToolkit().getSystemClipboard();
            kopiera.setContents(new StringSelection(skrivyta.getText()), null);

        });
        donate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.barncancerfonden.se/").toURI());
                } catch (Exception e) {}
            }
        });
        spara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            /* String filnamn = JOptionPane.showInputDialog("Vad ska filen heta?");

            String string = skrivyta.getText();
             try {
                BufferedWriter writer = new BufferedWriter( new FileWriter(filnamn +".txt"));
                writer.write(string);
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }*/ //Fungerande filsparning i src, me valfritt namn

                    JFileChooser chooser = new JFileChooser();
                    chooser.setSelectedFile(new File("c:/Temp2/Filename.txt"));
                    chooser.showSaveDialog(null);

                String string = skrivyta.getText();
                try {
                    BufferedWriter writer = new BufferedWriter( new FileWriter("exempel.txt"));
                    writer.write(string);
                    writer.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
                }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filename;
                if (result == JFileChooser.APPROVE_OPTION) {
                    filename = fc.getSelectedFile().getAbsolutePath();
                } else {
                    filename = null;
                }

                FileReader fr = null;
                try {
                    fr = new FileReader(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader inFile = new BufferedReader(fr);
                String line;
                try {
                    while ((line = inFile.readLine()) != null) {
                        skrivyta.append(line+"\n");
                    }
                    inFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad 2.0++");
        guidesign gui = new guidesign();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        frame.setJMenuBar(gui.menubar);
        frame.setPreferredSize(new Dimension(800,400));

    }
    private JPanel panel1;
    private JTextArea skrivyta;
    private JButton clearButton;
    private JButton copyTextButton;
    private JTextArea textArea1;
    private JMenuItem donate;
    private JMenuBar menubar;
}
