/**
 *
 * @author Jules Gammad
 */


public class Bank {
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    public Account[] accounts;
    public int numAccounts;//number of active accounts

    public Bank(String name, int maxNumberAccounts) {
        //assign values to instance variable from @param
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
        toString();
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the numAccounts
     */
    public int getNumAccounts() {
        return this.numAccounts;
    }

    //return the reference of the accounts array
    public Account[] getAccounts() {
        return this.accounts;
    }

    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber
     * @return
     */
    public boolean hasAccountNumber(int accountNumber) { 
      //variable to carry the boolean value outside of the for-each loop
      boolean checkFunc = false; 
      //for each the runs through each object in the array list
      for (Account account : accounts) {      
          //if the object is not null run code inside
          if (account != null) {
              //if the object's account number is equal to the passed account number
              //set checkFunc to be true and break the loop
              if (account.getNumber() == accountNumber) {
                  checkFunc = true;
                  break;  
              }
          }
         //the account is null and therfore has no accountNumber
         //break the loop and set checkFunc to false
         else {
              checkFunc = false;
              break;
          } 
      }
      //return the value of checkFunc
      return checkFunc;
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) {
        //checks to see if the max account is reached or if there is an account with the same number
        if (numAccounts >= accounts.length || hasAccountNumber(account.getNumber())) {
            return false;
        }
        //if not run code inside
        else {
            //for loop that runs through every object of the array list
            for (int i = 0; i < accounts.length; i++) {
                //if the account is null, assign that account to be the account added
                //add numAccounts by 1 and break the loop 
                if (accounts[i] == null) {
                    accounts[i] = account;
                    numAccounts++;
                    break;
                }
            }
            //return true after the addition of the account
            return true;
        }      
    }
    
    
    //converts the values to string in the constructor method
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}