//
// Paul Hayter, Assignment 8B
//
// CS1A, Anand Venkataraman, Fall 2016

public class Foothill
{
   public static final int CONSOLE_WIDTH = 80;
   
   public static void main(String[] args)
   {
      DateProfile applicant1 = new DateProfile('F','M',9,5,"Bridget Bardot");
      DateProfile applicant2 = new DateProfile('M','F',5,8,"Clint Eastwood");
      DateProfile applicant3 = new DateProfile('F','M',10,10,"Lady Gaga");
      DateProfile applicant4 = new DateProfile('M','F',1,4,"Vladimir Putin");
      
      // Display all 16 combinations of fits
      System.out.println("Display all fits");
      displayTwoProfiles(applicant1, applicant1);
      displayTwoProfiles(applicant1, applicant2);
      displayTwoProfiles(applicant1, applicant3);
      displayTwoProfiles(applicant1, applicant4);

      displayTwoProfiles(applicant2, applicant1);
      displayTwoProfiles(applicant2, applicant2);
      displayTwoProfiles(applicant2, applicant3);
      displayTwoProfiles(applicant2, applicant4);

      displayTwoProfiles(applicant3, applicant1);
      displayTwoProfiles(applicant3, applicant2);
      displayTwoProfiles(applicant3, applicant3);
      displayTwoProfiles(applicant3, applicant4);

      displayTwoProfiles(applicant4, applicant1);
      displayTwoProfiles(applicant4, applicant2);
      displayTwoProfiles(applicant4, applicant3);
      displayTwoProfiles(applicant4, applicant4);
      
      // Test constructors and accessors
      System.out.println("Test accessors while testing constructors");
      System.out.println("Test default constructor; expect all default values");
      System.out.println("Default constructor also tests setDefaults()");
      DateProfile defaultApp = new DateProfile();
      System.out.println("Default gender is: " + defaultApp.getGender()
            + " with expected value being " + DateProfile.DEFAULT_GEND);
      System.out.println("Default search gender is: " 
            + defaultApp.getSearchGender() + " with expected value being " 
            + DateProfile.DEFAULT_SEARCH_GEND);
      System.out.println("Default romance is: " + defaultApp.getRomance()
            + " with expected value being " + DateProfile.DEFAULT_ROMANCE);
      System.out.println("Default finance is: " + defaultApp.getFinance()
            + " with expected value being " + DateProfile.DEFAULT_FINANCE);
      System.out.println("Default name is: " + defaultApp.getName()
            + " with expected value being " + DateProfile.DEFAULT_NAME);
      
      System.out.println("\nTest parameterized constructor; expect values of:"
            + "\nGender='F', Search Gender='M', Romance=9, Finance=5, "
            + "name: Bridget Bardot");
      System.out.println("Parameterized constructor also tests setAll()");
      System.out.println("applicant1 gender is: " + applicant1.getGender());
      System.out.println("applicant1 search gender is: " 
            + applicant1.getSearchGender());
      System.out.println("applicant1 romance is: " + applicant1.getRomance());
      System.out.println("applicant1 finance is: " + applicant1.getFinance());
      System.out.println("applicant1 name is: " + applicant1.getName());
      
      // Test mutators
      System.out.println("\nTesting mutators and validators");
      if (defaultApp.setFinance(0))
         System.out.println("INCORRECTLY accepted a bad finance value");
      else
         System.out.println("Correctly rejected a bad finance value");
      if (defaultApp.setFinance(6))
         System.out.println("Correctly accepted a good finance value");
      else
         System.out.println("INCORRECTLY rejected a good finance value");

      if (defaultApp.setRomance(11))
         System.out.println("INCORRECTLY accepted a bad romance value");
      else
         System.out.println("Correctly rejected a bad romance value");
      if (defaultApp.setRomance(6))
         System.out.println("Correctly accepted a good romance value");
      else
         System.out.println("INCORRECTLY rejected a good romance value");

      if (defaultApp.setGender('X'))
         System.out.println("INCORRECTLY accepted a bad gender value");
      else
         System.out.println("Correctly rejected a bad gender value");
      if (defaultApp.setGender('f'))
         System.out.println("Correctly accepted a good gender value");
      else
         System.out.println("INCORRECTLY rejected a good gender value");

      if (defaultApp.setSearchGender('x'))
         System.out.println("INCORRECTLY accepted a bad search gender value");
      else
         System.out.println("Correctly rejected a bad search gender value");
      if (defaultApp.setSearchGender('m'))
         System.out.println("Correctly accepted a good search gender value");
      else
         System.out.println("INCORRECTLY rejected a good search gender value");

      if (defaultApp.setName(""))
         System.out.println("INCORRECTLY accepted a bad name");
      else
         System.out.println("Correctly rejected a bad name");
      if (defaultApp.setName("Theresa May"))
         System.out.println("Correctly accepted a good name");
      else
         System.out.println("INCORRECTLY rejected a good name");
      
      // Test fitValue()
      System.out.println("\nTest fitValue()");
      System.out.println("applicant2 gender is: " + applicant2.getGender()
            + " applicant4 search gender is: " + applicant4.getSearchGender());
      if (applicant2.fitValue(applicant4) != DateProfile.NO_FIT)
         System.out.println("INCORRECTLY made a bad fit based on gender");
      else
         System.out.println("Correctly identified a bad fit based on gender");

      System.out.println("applicant2 gender is: " + applicant2.getGender()
            + " applicant3 search gender is: " + applicant3.getSearchGender());
      if (applicant2.fitValue(applicant3) == DateProfile.NO_FIT)
         System.out.println("INCORRECTLY identified a bad fit based on gender");
      else
         System.out.println("Correctly identified a good fit based on gender");
   }
   
   static void displayTwoProfiles(DateProfile profile1, DateProfile profile2)
   {
      String outputStr = String.format("The Foothill Dating App has determined "
            +"that: " + profile1.toString() + ", and " + profile2.toString() 
            + ", have a compatibility fit of %.2f.\n",
            profile1.fitValue(profile2));
      System.out.println(formatForConsole(outputStr));
   }
   
   static String formatForConsole(String inputStr)
   {
      final int NOT_FOUND = -1;
      int begin = 0, lastSpacePlus1 = 0, nextSpace = 0;
      StringBuilder rtnStr = new StringBuilder(inputStr);
      
      while ((nextSpace = rtnStr.indexOf(" ",lastSpacePlus1)) != NOT_FOUND)
      {
         if (nextSpace - begin < Foothill.CONSOLE_WIDTH)
         {
            lastSpacePlus1 = nextSpace + 1; // not at console width so continue
            continue;
         }
         rtnStr.setCharAt(lastSpacePlus1 - 1, '\n');
         begin = lastSpacePlus1;
      }
      
      if (rtnStr.length() - begin >=Foothill.CONSOLE_WIDTH)
         rtnStr.setCharAt(lastSpacePlus1 - 1, 'n');
      
      return rtnStr.toString();
   }
} // end class Foothill

class DateProfile
{
   private char gender;
   private char searchGender;
   private int romance;
   private int finance;
   private String name;
   
   // range limits
   public static final int MIN_ROMANCE = 1;
   public static final int MAX_ROMANCE = 10;
   public static final int MIN_FINANCE = 1;
   public static final int MAX_FINANCE = 10;
   public static final int MIN_NAME_LEN = 1;
   public static final int MAX_NAME_LEN = 50;
   // defaults
   public static final char DEFAULT_GEND = 'M';
   public static final char DEFAULT_SEARCH_GEND = 'F';
   public static final String DEFAULT_NAME = " (no name) ";
   public static final int DEFAULT_ROMANCE = 5;
   public static final int DEFAULT_FINANCE = 5;
   // other constants
   public static final double GENDER_MATCH = 1.0;
   public static final double GENDER_MISMATCH = 0.0;
   public static final double NO_FIT = 0.0;
   public static final char MALE_CHAR = 'M';
   public static final char FEMALE_CHAR = 'F';
   
   // constructors
   DateProfile()
   {
      setDefaults();
   }
   
   DateProfile(char gdr, char srchGdr, int rom, int fin, String nam)
   {
      setAll(gdr, srchGdr, rom, fin, nam);
   }
   
   // accessors
   char getGender() { return gender; }
   char getSearchGender() { return searchGender; }
   int getRomance() { return romance; }
   int getFinance() { return finance; }
   String getName() { return name; }
   
   // validators
   static boolean genderOK(char gdr)
   {
      char upperCaseGdr = Character.toUpperCase(gdr);
      if (upperCaseGdr == DateProfile.MALE_CHAR 
            || upperCaseGdr == DateProfile.FEMALE_CHAR)
         return true;
      return false;
   }
   
   static boolean romanceOK(int romance)
   {
      if (romance >= DateProfile.MIN_ROMANCE 
            && romance <= DateProfile.MAX_ROMANCE)
         return true;
      return false;
   }

   static boolean financeOK(int finance)
   {
      if (finance >= DateProfile.MIN_FINANCE 
            && finance <= DateProfile.MAX_FINANCE)
         return true;
      return false;
   }
   
   static boolean nameOK(String name)
   {
      if (name.length() >= DateProfile.MIN_NAME_LEN 
            && name.length() <= DateProfile.MAX_NAME_LEN)
         return true;
      return false;
   }
   
   // mutators
   boolean setGender(char gdr)
   {
      if (!genderOK(gdr))
         return false;
      gender =  Character.toUpperCase(gdr);
      return true;
   }
   
   boolean setSearchGender(char gdr)
   {
      if (!genderOK(gdr))
         return false;
      searchGender =  Character.toUpperCase(gdr);
      return true;
   }
   
   boolean setRomance(int romance)
   {
      if (!romanceOK(romance))
         return false;
      this.romance =  romance;
      return true;
   }
   
   boolean setFinance(int finance)
   {
      if (!financeOK(finance))
         return false;
      this.finance =  finance;
      return true;
   }
   
   boolean setName(String name)
   {
      if (!nameOK(name))
         return false;
      this.name =  name;
      return true;
   }
   
   // supporting methods
   public void setAll(char gdr, char srchGdr, int rom, int fin, String name)
   {
      if (!setGender(gdr))
         gender = DateProfile.DEFAULT_GEND;
      if (!setSearchGender(srchGdr))
         searchGender = DateProfile.DEFAULT_SEARCH_GEND;
      if (!setRomance(rom))
         romance = DateProfile.DEFAULT_ROMANCE;
      if (!setFinance(fin))
         finance = DateProfile.DEFAULT_FINANCE;
      if (!setName(name))
         name = DateProfile.DEFAULT_NAME;
   }
   
   public void setDefaults() 
   {
      gender = DateProfile.DEFAULT_GEND;
      searchGender = DateProfile.DEFAULT_SEARCH_GEND;
      romance = DateProfile.DEFAULT_ROMANCE;
      finance = DateProfile.DEFAULT_FINANCE;
      name = DateProfile.DEFAULT_NAME;
   }
   
   public double fitValue(DateProfile partner)
   {
      if (this.determineGenderFit(partner) == DateProfile.GENDER_MISMATCH)
         return DateProfile.NO_FIT;
      return (this.determineRomanceFit(partner) 
            + this.determineFinanceFit(partner))/2;
   }
   
   private double determineGenderFit(DateProfile partner)
   {
      if (this.gender == partner.searchGender
            && this.searchGender == partner.gender)
         return DateProfile.GENDER_MATCH;
      return DateProfile.GENDER_MISMATCH;
   }
   
   private double determineRomanceFit(DateProfile partner)
   {
      return calculateFit(this.romance, partner.romance);
   }
   
   private double determineFinanceFit(DateProfile partner)
   {
      return calculateFit(this.finance, partner.finance);
   }
   
   private static double calculateFit(int person1Attr, int person2Attr)
   {
      return 1.0 - Math.abs(person1Attr - person2Attr) / 10.0;
   }
   
   @Override
   public String toString()
   {
      return "Client " + name + ", who is seeking a "
            + (searchGender == 'M' ? "Man" : "Woman") 
            + " with a romance level of " + romance
            + " and a finance level of " + finance;
   }
} // end class DateProfile

/********************************* RUN *****************************************
*******************************************************************************/