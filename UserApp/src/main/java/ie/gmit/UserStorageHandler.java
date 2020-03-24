/*
* Cian Joyce
* 23/03/2020
* g00350885@gmit.ie
* A class that handles the user storage format and methods.
* */
package ie.gmit;

public class UserStorageHandler
{
    //Store used by controller
    private Store store = new Store();

    public void storeUser(User user)
    {
        store.store(user);
    }
}
