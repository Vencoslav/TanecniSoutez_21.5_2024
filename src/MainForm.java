import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainForm extends  JFrame{
    private JPanel panelMain;
    private JTable table1;
    private JTextField tfParyCelkem;
    private JCheckBox checkBox1;
    private File selectedFile;
    private List<SoutezniPar> seznam = new ArrayList<>();


    public MainForm(){
        setContentPane(panelMain);
        setTitle("Taneční soutěž Doležal Václav");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,500);

        initMenu();


    }

    public void initMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu soutez = new JMenu("Soutěž");
        menuBar.add(soutez);

        JMenuItem nacit = new JMenuItem("Načti");
        soutez.add(nacit);
        nacit.addActionListener(e->{vyberSoubor();});

        JMenuItem ukonci = new JMenuItem("Ukonči");
        soutez.add(ukonci);
        ukonci.addActionListener(e->{});

        JMenuItem statistiky = new JMenuItem("Statistiky");
        soutez.add(statistiky);
        statistiky.addActionListener(e->{vytvorStatistiku();});
    }

    public void vyberSoubor(){
        JFileChooser fc = new JFileChooser(".");
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            selectedFile = fc.getSelectedFile();
            nactiSoubor(selectedFile);
        }
    }

    public void nactiSoubor(File selectedFile){
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(selectedFile)))){
            while (sc.hasNextLine()){
                String radek = sc.nextLine();
                String[] rozdelovac = radek.split(":");
                Integer startovniCislo = Integer.parseInt(rozdelovac[0]);
                String jmena = rozdelovac[1];
                BigDecimal startovne = BigDecimal.valueOf(Long.parseLong(rozdelovac[2]));
                LocalDate datum = LocalDate.parse(rozdelovac[3]);
                Boolean divokaKarta  = Boolean.parseBoolean(rozdelovac[4]);

                if (divokaKarta.equals("x")){
                    divokaKarta = true;
                } else {
                    divokaKarta = false;
                }

                SoutezniPar par =  new SoutezniPar(startovniCislo,jmena,startovne,datum,divokaKarta);
                seznam.add(par);

                TableModel model = new TableModel(seznam);
                table1.setModel(model);

                display();
            }

        } catch (FileNotFoundException e){
            throw  new RuntimeException("Soubor: " + selectedFile + "nebyl nalezen " + e.getLocalizedMessage());
        }
    }

    public void display(){
        Soutez soutez = new Soutez("Nazev",seznam);
        tfParyCelkem.setText(String.valueOf(seznam.size()));
        checkBox1.setSelected(soutez.getDokonceno());
    }

    public void vytvorStatistiku(){
        Soutez soutezStartovne = new Soutez("Nazev",seznam);
        Soutez soutezKarty = new Soutez("Nazev",seznam);
        JOptionPane.showMessageDialog(this,"Startovné celkem: " + soutezStartovne.startvneCelkem() + "\n" + " Počet divokých karet: " + soutezKarty.pocetDivokychKaret(seznam));
    }
}

