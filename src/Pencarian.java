import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pencarian extends JFrame {
    public Pencarian() {
        // JFrame Pencarian 
        setTitle("Halaman Pencarian");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);

        // Panel 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 35, 0, 0));

        // Input NIK 
        panel.add(new JLabel("Input NIK"));
        JTextField nik = new JTextField();
        panel.add(nik);

        JButton buttonNik = new JButton("Cari");
        panel.add(buttonNik);        
        
        buttonNik.addActionListener(e -> {
            String nikInput = nik.getText().trim();
            if (nikInput.isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIK tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Menggunakan controller untuk mencari user berdasarkan NIK
            Controller controller = new Controller();
            User user = controller.getUserByNik(nikInput);

            if (user != null) {
                // Jika user ditemukan, tampilkan di OutputKtpFrame
                OutputKtpFrame outputFrame = new OutputKtpFrame(
                        user.getNik(),
                        user.getNama(),
                        user.getTempatLahir(),
                        user.getTanggalLahir(),
                        user.getJenisKelamin(),
                        user.getGolonganDarah(),
                        user.getAlamat(),
                        user.getRtRw(),
                        user.getKelDesa(),
                        user.getKecamatan(),
                        user.getAgama(),
                        user.getStatusPerkawinan(),
                        user.getPekerjaan(),
                        user.getKewarganegaraan(),
                        user.getBerlakuHingga(),
                        user.getKotaPembuatan(),
                        user.getTanggalPembuatan(),
                        new ImageIcon(user.getFoto()), // Asumsi foto disimpan sebagai path
                        new ImageIcon(user.getTandaTangan()) // Asumsi tanda tangan disimpan sebagai path
                );
                outputFrame.setVisible(true);
                setVisible(false); // Menyembunyikan frame pencarian
            } else {
                JOptionPane.showMessageDialog(this, "User  tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }
}