//
// Paul Hayter, Assignment 8B
//
// CS1A, Anand Venkataraman, Fall 2016

/**
 * Class tests the DateProfile class and includes nicely formatted output.
 * @author Paul Hayter
 */
public class Foothill
{
   public static final int CONSOLE_WIDTH = 80;
   
   /**
    * Method contains tests for DateProfile class.
    * @param args
    */
   public static void main(String[] args)
   {
      DateProfile applicant1 = new DateProfile('F','M',9,6,"Bridget Bardot");
      DateProfile applicant2 = new DateProfile('M','F',4,8,"Clint Eastwood");
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
            + "\nGender='F', Search Gender='M', Romance=9, Finance=6, "
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
      if (applicant2.fitValue(applicant4) != 0.0)
         System.out.println("INCORRECTLY made a bad fit based on gender");
      else
         System.out.println("Correctly identified a bad fit based on gender");

      System.out.println("applicant2 gender is: " + applicant2.getGender()
            + " applicant3 search gender is: " + applicant3.getSearchGender());
      if (applicant2.fitValue(applicant3) == 0.0)
         System.out.println("INCORRECTLY identified a bad fit based on gender");
      else
         System.out.println("Correctly identified a good fit based on gender");
   }
   
   /**
    * Displays two DateProfile objects along with their fit in a format width
    * specified by CONSOLE_WIDTH.
    * @param profile1 class DateProfile object, one of two profiles to be 
    * displayed together with fit value.
    * @param profile2 class DateProfile object, one of two profiles to be 
    * displayed together with fit value. 
    */
   static void displayTwoProfiles(DateProfile profile1, DateProfile profile2)
   {
      String outputStr = String.format("The Foothill Dating App has determined "
            +"that: " + profile1.toString() + ", and " + profile2.toString() 
            + ", have a compatibility fit of %.2f.\n",
            profile1.fitValue(profile2));
      System.out.println(formatForConsole(outputStr));
   }
   
   /**
    * Returns a formatted String which fits the console width specified by 
    * CONSOLE_WIDTH. Line breaks are between words. There is no hyphenation.
    * @param inputStr String input to be formatted.
    * @return specified String.
    */
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
      
      if (rtnStr.length() - begin >= Foothill.CONSOLE_WIDTH 
            && lastSpacePlus1 != 0)
         rtnStr.setCharAt(lastSpacePlus1 - 1, '\n');
      
      return rtnStr.toString();
   }
} // end class Foothill

/**
 * Class contains 5 member fields which characterize a person's dating profile.
 * Class includes methods for mutating, accessing, displaying and determining 
 * fit.
 * @author Paul Hayter
 */
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
   // other class constants
   public static final char MALE_CHAR = 'M';
   public static final char FEMALE_CHAR = 'F';
   
   // constructors
   /**
    * Default constructor.
    */
   DateProfile()
   {
      setDefaults();
   }
   
   /**
    * Parameterized constructor.
    * @param gdr char to specify gender of profile holder.
    * @param srchGdr char to specify gender profile holder is seeking.
    * @param rom int to specify romance level of person being sought.
    * @param fin int to specify finance level of person being sought.
    * @param nam name of profile holder.
    */
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
   /**
    * Returns boolean true if gender char is a permitted value or false
    * otherwise.
    * @param gdr char representing gender of profile holder.
    * @return specified boolean.
    */
   static boolean genderOK(char gdr)
   {
      char upperCaseGdr = Character.toUpperCase(gdr);
      if (upperCaseGdr == DateProfile.MALE_CHAR 
            || upperCaseGdr == DateProfile.FEMALE_CHAR)
         return true;
      return false;
   }
   
   /**
    * Returns boolean true if romance value is a permitted value or false
    * otherwise.
    * @param romance int representing romance level of person being sought.
    * @return specified boolean.
    */
   static boolean romanceOK(int romance)
   {
      if (romance >= DateProfile.MIN_ROMANCE 
            && romance <= DateProfile.MAX_ROMANCE)
         return true;
      return false;
   }

   /**
    * Returns boolean true if romance value is a permitted value or false
    * otherwise.
    * @param finance int representing finance level of person being sought.
    * @return specified boolean.
    */
   static boolean financeOK(int finance)
   {
      if (finance >= DateProfile.MIN_FINANCE 
            && finance <= DateProfile.MAX_FINANCE)
         return true;
      return false;
   }
   
   /**
    * Returns boolean true if name is of the correct length or false otherwise.
    * @param name String containing name of profile holder.
    * @return specified boolean.
    */
   static boolean nameOK(String name)
   {
      if (name.length() >= DateProfile.MIN_NAME_LEN 
            && name.length() <= DateProfile.MAX_NAME_LEN)
         return true;
      return false;
   }
   
   // mutators
   /**
    * Returns true if input gender is an acceptable value and member field is 
    * changed to it; otherwise returns false.
    * @param gdr char representing gender of profile holder.
    * @return specified boolean.
    */
   boolean setGender(char gdr)
   {
      if (!genderOK(gdr))
         return false;
      gender =  Character.toUpperCase(gdr);
      return true;
   }
   
   /**
    * Returns true if input gender is an acceptable value and member field is
    * changed to it; otherwise returns false.
    * @param gdr char representing gender profile holder is seeking in a match.
    * @return specified boolean.
    */
   boolean setSearchGender(char gdr)
   {
      if (!genderOK(gdr))
         return false;
      searchGender =  Character.toUpperCase(gdr);
      return true;
   }
   
   /**
    * Returns true if input romance level is in the acceptable range and member
    * field is changed to it; otherwise returns false.
    * @param romance int representing romance level being sought.
    * @return specified boolean.
    */
   boolean setRomance(int romance)
   {
      if (!romanceOK(romance))
         return false;
      this.romance =  romance;
      return true;
   }
   
   /**
    * Returns true if input finance level is in the acceptable range and member
    * field is changed to it; otherwise returns false.
    * @param finance int representing finance level being sought.
    * @return specified boolean.
    */
   boolean setFinance(int finance)
   {
      if (!financeOK(finance))
         return false;
      this.finance =  finance;
      return true;
   }
   
   /**
    * Returns true if input name is in the acceptable size and member field is 
    * changed to it; otherwise returns false.
    * @param name String contain name of profile holder.
    * @return specified boolean.
    */
   boolean setName(String name)
   {
      if (!nameOK(name))
         return false;
      this.name =  name;
      return true;
   }
   
   // supporting methods
   /**
    * Sets all member fields with parameters passed. If parameters are not legal
    * then default values are used to set member fields.
    * @param gdr char representing gender of profile holder.
    * @param srchGdr char representing gender of person being sought.
    * @param rom int representing romance level of person being sought.
    * @param fin int representing finance level of person being sought.
    * @param name String contain name of profile holder.
    */
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
   
   /**
    * Sets all member fields to default values.
    */
   public void setDefaults() 
   {
      gender = DateProfile.DEFAULT_GEND;
      searchGender = DateProfile.DEFAULT_SEARCH_GEND;
      romance = DateProfile.DEFAULT_ROMANCE;
      finance = DateProfile.DEFAULT_FINANCE;
      name = DateProfile.DEFAULT_NAME;
   }
   
   /**
    * Computes fit based on data in this profile and partner profile. A 0.0
    * is returned if there is no mutual match between the genders being sought
    * by both profiles. With a mutual match the returned values range [0.1,1].    *  
    * @param partner DateProfile for fit comparison.
    * @return double value as specified.
    */
   public double fitValue(DateProfile partner)
   {
      if (this.determineGenderFit(partner) == 0.0) // should this be magic???
         return 0.0;
      return (this.determineRomanceFit(partner) 
            + this.determineFinanceFit(partner))/2;
   }
   
   /**
    * Returns 1.0 if there is a mutual match in search genders; otherwise 
    * returns 0.0.
    * @param partner DateProfile for search gender confirmation.
    * @return specified double.
    */
   private double determineGenderFit(DateProfile partner)
   {
      if (this.gender == partner.searchGender
            && this.searchGender == partner.gender)
         return 1.0;
      return 0.0;
   }
   
   /**
    * Returns a calculated double value based on romance fit. Value ranges 
    * from [0.1,1.0].
    * @param partner DateProfile for romance fit calculation.
    * @return specified double.
    */
   private double determineRomanceFit(DateProfile partner)
   {
      return calculateFit(this.romance, partner.romance);
   }
   
   /**
    * Returns a calculated double value based on finance fit. Value ranges
    * from [0.1,1.0].
    * @param partner DateProfile for finance fit calculation.
    * @return specified double.
    */
   private double determineFinanceFit(DateProfile partner)
   {
      return calculateFit(this.finance, partner.finance);
   }
   
   /**
    * Helper method for calculating fit. Inputs are expected to be between 1 and
    * 10, inclusive. Double value returned ranges [0.1,1.0].
    * @param person1Attr int attribute for fit calculation.
    * @param person2Attr int attribute for fit calculation.
    * @return specified double.
    */
   private static double calculateFit(int person1Attr, int person2Attr)
   {
      return 1.0 - Math.abs(person1Attr - person2Attr) / 10.0;
   }
   
   @Override
   /**
    * Returns formatted string containing class fields.
    */
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