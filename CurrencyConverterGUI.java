import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends JFrame {
    private JTextField txtAmount;
    private JLabel lblResult;
    private JComboBox<String> cmbCurrencies;
    private JButton btnConvert;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JLabel lblAmount = new JLabel("Enter amount (PKR):");
        txtAmount = new JTextField(10);
        lblResult = new JLabel("Converted Amount: ");

        String[] currencies = {"USD", "EUR", "GBP"};
        cmbCurrencies = new JComboBox<>(currencies);

        btnConvert = new JButton("Convert");

        // Action listener for the Convert button
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        setLayout(new java.awt.FlowLayout());
        add(lblAmount);
        add(txtAmount);
        add(cmbCurrencies);
        add(btnConvert);
        add(lblResult);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            String selectedCurrency = cmbCurrencies.getSelectedItem().toString();
            double convertedAmount = 0;

            switch (selectedCurrency) {
                case "USD":
                    convertedAmount = amount * 0.0033;
                    break;
                case "EUR":
                    convertedAmount = amount * 0.0030;
                    break;
                case "GBP":
                    convertedAmount = amount * 0.0027;
                    break;
            }

            lblResult.setText("Converted Amount: " + convertedAmount);
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid amount entered");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CurrencyConverterGUI().setVisible(true);
        });
    }
}
