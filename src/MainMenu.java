import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

public class MainMenu extends JFrame{

    public MainMenu(){        
        // JFrame Main Menu 
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        
        // JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 35, 0, 0));

        JButton menu1 = new JButton("Perekaman");
        JButton menu2 = new JButton("Pencarian");
        JButton menu3 = new JButton("Exit");
        panel.add(menu1);
        panel.add(menu2);
        panel.add(menu3);

        // Menu 1 : Perekaman
        menu1.addActionListener(e -> {
            new FormInputFrame().setVisible(true);
            setVisible(false);
        });

        // Menu 2 : Pencarian
        menu2.addActionListener(e -> {
            
        });

        // Menu 3 : Exit
        menu3.addActionListener(e -> {
            System.exit(0);
        });


        add(panel);
    }
}
