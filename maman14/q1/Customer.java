
/**
 *  class Customer is an example to an object class that can be inserted to the queue
 * 
 * @author Matan Sharon
 * @version 13.5.2020
 */
public class Customer
{
    //instance variables
    private String _name,_message;
    private int _id;

    /**
     * Customer Constructor
     *
     * @param id and int parameter
     * @param n for the name parameter
     * @param m for the message parameter
     */
    public Customer(int id,String n,String m)
    {
        _id=id;
        _name=n;
        _message=m;
    }

    /**
     * Customer Constructor copy constructor
     *
     * @param c another Customer parameter
     */
    public Customer(Customer c)
    {
        _id=c.getId();
        _name=c.getName();
        _message=c.getMessage();
    }

    /**
     * Method getName return the name of the customer
     *
     * @return a String represntion of the customer name
     */
    public String getName(){return _name;}

    /**
     * Method getMessage return the message of the customer
     *
     * @return a String represntion of the customer message
     */
    public String getMessage(){return _message;}

    /**
     * Method getId return the id of the customer
     *
     * @return the id as an int
     */
    public int getId(){return _id;}

    /**
     * Method setName recive a String and change the customer name to that String
     *
     * @param n a String parameter
     */
    public void setName(String n){_name=n;}

    /**
     * Method setMessage recive a String and change the customer message
     *
     * @param n a String parameter
     */
    public void setMessage(String n){_message=n;}

    /**
     * Method setId recive an int and change the customer id
     *
     * @param d an int parameter
     */
    public void setId(int d){_id=d;}

    /**
     * Method equals checks if another Customer id and message is equle to this Customer
     * the metohd first checks if the Object parameter is instance of Customer, 
     * and if the answer is true is compare the id and message for both Customers
     * @param o an Object parameter
     * @return true if the 2 Cutomers are the same id and message and false otherwise
     */
    public boolean equals(Object o)
    {
        if(o instanceof Customer)
        {
            if(this._id==((Customer)o).getId()&&this._message==((Customer)o).getMessage())return true;
        }
        return false;
    }

    /**
     * Method toString override the Object toString and return the name of the customer
     *
     * @return the customer name as a String
     */
    public String toString()
    {
        return this._name;
    }
}
