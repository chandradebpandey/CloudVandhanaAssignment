package SurveyForm;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {

    JTextField nameTextField,lnameTextField,professionTextField,emailTextField,mobTextField;
    JButton submit,reset;
    JDateChooser dateChooser;
    JRadioButton male,female,other;
    String[] country_list = {"Select","Afghanistan","Australia","Belarus","Brazil","Bangladesh","Cambodia","China","Colombia","Denmark","Egypt","France","Germany","HongKong","Iceland","India","Japan","Laos","Malaysia","Mexico","Others"};
    JComboBox<String> dropdown = new JComboBox(country_list);
    ButtonGroup gendergroup;

    Form(){
        setTitle("Survey Form");

        setLayout(null);


        JLabel text = new JLabel("Survey Form");
        text.setFont(new Font("Osward",Font.CENTER_BASELINE,38));
        text.setBounds(280,25,300,50);
        add(text);

        JLabel name = new JLabel("First Name :");
        name.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        name.setBounds(70,100,250,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.HANGING_BASELINE,15));
        nameTextField.setBounds(250,100,350,30);
        add(nameTextField);

        JLabel lname = new JLabel("Last Name :");
        lname.setFont(new Font("Osward",Font.HANGING_BASELINE,25));
        lname.setBounds(70,150,280,50);
        add(lname);

        lnameTextField = new JTextField();
        lnameTextField.setFont(new Font("Raleway",Font.HANGING_BASELINE,15));
        lnameTextField.setBounds(250,160,350,30);
        add(lnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        dob.setBounds(70,200,310,70);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(250,220,350,30);
        add(dateChooser);

        JLabel country = new JLabel("Country :");
        country.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        country.setBounds(70,250,340,90);
        add(country);

        dropdown.setBounds(250,280,350,30);
        add(dropdown);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        gender.setBounds(70,300,370,120);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,340,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,340,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel profession = new JLabel("Profession :");
        profession.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        profession.setBounds(70,340,350,150);
        add(profession);

        professionTextField = new JTextField();
        professionTextField.setFont(new Font("Raleway",Font.HANGING_BASELINE,15));
        professionTextField.setBounds(250,400,350,30);
        add(professionTextField);

        JLabel email = new JLabel("Email Id :");
        email.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        email.setBounds(70,400,430,180);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.HANGING_BASELINE,15));
        emailTextField.setBounds(250,470,350,30);
        add(emailTextField);

        JLabel mob = new JLabel("Mobile No. :");
        mob.setFont(new Font("Raleway",Font.HANGING_BASELINE,25));
        mob.setBounds(70,460,510,210);
        add(mob);

        mobTextField = new JTextField();
        mobTextField.setFont(new Font("Raleway",Font.HANGING_BASELINE,15));
        mobTextField.setBounds(250,540,350,30);
        add(mobTextField);


        reset = new JButton("Reset");
        reset.setBounds(350,630,100,30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(500,630,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);





        setSize(800,800);
        setVisible(true);
        setLocation(80,80);



    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == reset)
        {
            nameTextField.setText("");
            lnameTextField.setText("");
            dropdown.setSelectedIndex(0);
            dateChooser.setDate(null);
            gendergroup.clearSelection();
            professionTextField.setText("");
            emailTextField.setText("");
            mobTextField.setText("");


        }
        else if(ae.getSource() == submit)
        {
            String fname = nameTextField.getText();
            String lastname = lnameTextField.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String selectedcountry = (String) dropdown.getSelectedItem();
            String gender = null;
            if(male.isSelected()) {
                gender = "Male";
            }else if(female.isSelected()){
                gender = "female";
            }

            String profession = professionTextField.getText();
            String email = emailTextField.getText();
            String mob = mobTextField.getText();

            String message = "First Name: " + fname + "\n" +
                    "Last Name: " + lastname + "\n" +
                    "Date of Birth: " + dob + "\n" +
                    "Country: " + selectedcountry+ "\n" +
                    "Gender: " + gender + "\n" +
                    "Profession: " + profession + "\n" +
                    "Email: " + email + "\n" +
                    "Mobile Number: " + mob ;

            try{
                if(fname.equals("") || lastname.equals("") || dob.equals("") || selectedcountry.equals("") || gender.equals("") || profession.equals("") || email.equals("") || mob.equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this,message,"Survey Submitted", JOptionPane.INFORMATION_MESSAGE);

                    resetForm();

                }
            }catch(Exception e)
            {
                System.out.println(e);
            }

        }

    }

    private void resetForm() {
        nameTextField.setText("");
        lnameTextField.setText("");
        dropdown.setSelectedIndex(0);
        dateChooser.setDate(null);
        gendergroup.clearSelection();
        professionTextField.setText("");
        emailTextField.setText("");
        mobTextField.setText("");
    }
}
