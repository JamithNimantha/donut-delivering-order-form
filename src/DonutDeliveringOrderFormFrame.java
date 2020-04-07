import javax.swing.*;
import java.awt.*;

/**
 * @author Jamith Nimantha
 */
public class DonutDeliveringOrderFormFrame extends JFrame {

    // Customer Details Components
    private JLabel lblCustomerHead = new JLabel("Customer Details");
    private JLabel lblFirstName = new JLabel("First Name");
    private JTextField txtFirstName = new JTextField(30);
    private JLabel lblLastName = new JLabel("Last Name");
    private JTextField txtLastName = new JTextField(30);
    private JLabel lblDateOfBirth = new JLabel("Date of Birth");
    private JTextField txtDateOfBirth = new JTextField(30);
    private JLabel lblAddress = new JLabel("Address");
    private JTextField txtAddress = new JTextField(30);
    private JLabel lblContact = new JLabel("Contact");
    private JTextField txtContact = new JTextField(30);
    private JLabel lblEmail = new JLabel("Email");
    private JTextField txtEmail = new JTextField(30);

    // Donut Order Components
    private JLabel lblDonutHead = new JLabel("Donut Order");
    private JLabel lblQuantity = new JLabel("How many donuts would you want ?");
    private ButtonGroup btnGrpQty = new ButtonGroup();
    private JCheckBox chkSingle = new JCheckBox("Single Donut");
    private JCheckBox chkHalfDozen = new JCheckBox("1/2 Dozen");
    private JCheckBox chkDozen = new JCheckBox("Dozen");
    private JCheckBox chkBoxOf20 = new JCheckBox("Box of 20");
    private JLabel lblDonutType = new JLabel("Select your Donut : ");
    private JComboBox<String> cmbDonutType;
    private JLabel lblCoating = new JLabel("Coating : ");
    private JRadioButton rBtnYes = new JRadioButton("Yes");
    private JRadioButton rBtnNo = new JRadioButton("No");
    private JCheckBox chkChocolate = new JCheckBox("Chocolate Sprinkles");
    private JCheckBox chkRainBow = new JCheckBox("Rainbow");
    private JCheckBox chkPeanut = new JCheckBox("Peanuts");
    private JLabel lblInstruction = new JLabel("Special Delivery Instructions (Optional)  : ");
    private JTextField txtInstruction = new JTextField(30);
    private JButton btnDone = new JButton("Done");
    private String[] donutList = {"Chocolate Frosted", "Strawberry Frosted", "Croissant Donut", "Butter Milk", "Coconut", "Cinnamon", "Cream Filled"};

    // Result Area Components
    private JLabel lblResult = new JLabel("Results : ");
    private JTextArea txtResult = new JTextArea(5, 80);

    DonutDeliveringOrderFormFrame() {
        createMenu();
        setCustomerPanel();
        setDonutOrderPanel();
        setResultArea();
    }

    /**
     * This method creates the Scrollable Result Text Area that contains the description of the content
     */
    private void setResultArea() {
        JPanel pnlResult = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtResult.setEditable(false);
        pnlResult.add(lblResult);
        pnlResult.add(txtResult);
        JScrollPane pnlScrollable = new JScrollPane(pnlResult);
        add("South", pnlScrollable);

    }

    /**
     * This method create Donut Order Form
     */
    private void setDonutOrderPanel() {
        JPanel pnlDonut = new JPanel(new BorderLayout());
        pnlDonut.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f))); // set the border width

        // Donut Order Form Header
        JPanel pnlHead = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlHead.add(lblDonutHead);
        pnlDonut.add(pnlHead, BorderLayout.NORTH);

        // Content of the Donut Order form
        JPanel pnlDonutContent = new JPanel(new GridLayout(4, 1));
        // Component Quantity
        JPanel pnlQuantity = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chkSingle.setActionCommand("Single Donut");
        chkHalfDozen.setActionCommand("1/2 Dozen");
        chkDozen.setActionCommand("Dozen");
        chkBoxOf20.setActionCommand("Box of 20");
        chkSingle.setSelected(true); // set as the Default
        btnGrpQty.add(chkSingle);
        btnGrpQty.add(chkHalfDozen);
        btnGrpQty.add(chkDozen);
        btnGrpQty.add(chkBoxOf20);
        // Quantity Checkbox Group
        JPanel pnlQtyCheckbox = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlQtyCheckbox.add(chkSingle);
        pnlQtyCheckbox.add(chkHalfDozen);
        pnlQtyCheckbox.add(chkDozen);
        pnlQtyCheckbox.add(chkBoxOf20);
        pnlQuantity.add(lblQuantity);
        pnlQuantity.add(pnlQtyCheckbox);

        // Component Donut Type
        JPanel pnlDonutType = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cmbDonutType = new JComboBox<>(donutList);
        pnlDonutType.add(lblDonutType);
        pnlDonutType.add(cmbDonutType);

        //Component Coating
        JPanel pnlCoat = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pnlCoating = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Set the Radio Button Group
        ButtonGroup btnGroupCoating = new ButtonGroup();
        btnGroupCoating.add(rBtnYes);
        btnGroupCoating.add(rBtnNo);
        pnlCoating.add(lblCoating);
        pnlCoating.add(rBtnYes);
        pnlCoating.add(rBtnNo);
        pnlCoat.add(pnlCoating);
        // Coating Checkbox Group
        JPanel pnlCoatingTypes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chkChocolate.setActionCommand("Chocolate Sprinkles");
        chkRainBow.setActionCommand("Rainbow");
        chkPeanut.setActionCommand("Peanuts");
        pnlCoatingTypes.add(chkChocolate);
        pnlCoatingTypes.add(chkRainBow);
        pnlCoatingTypes.add(chkPeanut);
        pnlCoat.add(pnlCoatingTypes);

        // Component Special Delivery Instructions
        JPanel pnlInstruction = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlInstruction.add(lblInstruction);
        pnlInstruction.add(txtInstruction);

        // Add the Components into the Donut Content Panel
        pnlDonutContent.add(pnlQuantity);
        pnlDonutContent.add(pnlDonutType);
        pnlDonutContent.add(pnlCoat);
        pnlDonutContent.add(pnlInstruction);

        // Component Done Button
        JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Triggers the setResult method
        btnDone.addActionListener(e -> setResult());
        pnlButton.add(btnDone);
        pnlDonut.add(pnlButton, BorderLayout.SOUTH);

        // add the Panel Donut Content to Panel Donut
        pnlDonut.add(pnlDonutContent, BorderLayout.CENTER);

        //set Panel Donut to JFrame
        add("East", pnlDonut);
    }

    /**
     * Set the Result Text Area with the descriptions of the Customer Details and Donut Order Form
     */
    private void setResult() {
        String customer = "Customer Details – First Name:" + txtFirstName.getText() + ", Last Name:" + txtLastName.getText() + ", Date of Birth:" + txtDateOfBirth.getText() + ", Address:" + txtAddress.getText() + ", Contact:" + txtContact.getText() + ", Email:" + txtEmail.getText() + "\n";
        String donut = "Donut Order – Quantity:" + btnGrpQty.getSelection().getActionCommand() + ", Type:" + cmbDonutType.getSelectedItem() + ", Coating:" + getCoating() + ", Instructions:" + txtInstruction.getText() + "\n";
        txtResult.setText(txtResult.getText().concat(customer + donut));
    }

    /**
     * Get the selected coatings of the donut if customer requested
     */
    private String getCoating() {
        String coating = "";
        if (rBtnYes.isSelected()) {
            coating = coating.concat(chkChocolate.isSelected() ? chkChocolate.getActionCommand().concat(",") : "");
            coating = coating.concat(chkRainBow.isSelected() ? chkRainBow.getActionCommand().concat(",") : "");
            coating = coating.concat(chkPeanut.isSelected() ? chkPeanut.getActionCommand() : "");
        }
        return coating;
    }

    /**
     * This method Creates Customer Detail Panel
     */
    private void setCustomerPanel() {

        // Create Panel Customer
        JPanel pnlCustomer = new JPanel(new BorderLayout());
        pnlCustomer.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f))); // set border width

        // Panel Header
        JPanel pnlHead = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlHead.add(lblCustomerHead);
        pnlCustomer.add(pnlHead, BorderLayout.NORTH);

        // Panel Customer Detail Content
        JPanel pnlCustomerDetailsContent = new JPanel(new GridLayout(6, 1));
        // Component First Name
        JPanel pnlFirstName = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlFirstName.add(lblFirstName);
        pnlFirstName.add(txtFirstName);
        //Component Last Name
        JPanel pnlLastName = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLastName.add(lblLastName);
        pnlLastName.add(txtLastName);
        //Component Date of Birth
        JPanel pnlDateOfBirth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlDateOfBirth.add(lblDateOfBirth);
        pnlDateOfBirth.add(txtDateOfBirth);
        //Component Address
        JPanel pnlAddress = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlAddress.add(lblAddress);
        pnlAddress.add(txtAddress);
        //Component Contact
        JPanel pnlContact = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlContact.add(lblContact);
        pnlContact.add(txtContact);
        // Component Email
        JPanel pblEmail = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pblEmail.add(lblEmail);
        pblEmail.add(txtEmail);

        // add components to Panel Customer Details Content
        pnlCustomerDetailsContent.add(pnlFirstName);
        pnlCustomerDetailsContent.add(pnlLastName);
        pnlCustomerDetailsContent.add(pnlDateOfBirth);
        pnlCustomerDetailsContent.add(pnlAddress);
        pnlCustomerDetailsContent.add(pnlContact);
        pnlCustomerDetailsContent.add(pblEmail);

        // set Panel Customer Details Content to Panel Customer
        pnlCustomer.add(pnlCustomerDetailsContent, BorderLayout.CENTER);

        //add Panel Customer to JFrame
        add("West", pnlCustomer);
    }

    /**
     * This method create Menu Item "Exit" that use to end the program
     */
    private void createMenu() {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setToolTipText("Exit Application");
        // Triggers
        exitMenuItem.addActionListener(e -> System.exit(0));
        JMenu appMenu = new JMenu("Application");
        appMenu.add(exitMenuItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(appMenu);
        setJMenuBar(menuBar);
    }

}
