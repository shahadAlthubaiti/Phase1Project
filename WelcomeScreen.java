
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {

    private String welcomeText = "Welcome to LookeMe.com where we keep your files safe :)";
    private String developerText = "Developed By computer science student : Shahad abduallah ";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. list Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("____________________________________________");
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ScService.setCurrentScreen(ScService.FileOptionsScreen);
                ScService.getCurrentScreen().Show();
                ScService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

    	System.out.println(" here is the Files in LockedMe.com Directory :");
        
        File f = new File("C:\\Users\\SUNFLOWER\\eclipse-workspace\\LockedMe.comProjectphase1");

        String[] pathnames = f.list();

        for (String pathname : pathnames) {
            System.out.println(pathname);

        		} System.out.println("_______________ ");

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
