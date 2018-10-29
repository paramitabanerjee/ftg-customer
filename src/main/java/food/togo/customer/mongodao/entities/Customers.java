package food.togo.customer.mongodao.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customers {

    private String firstname;
    private String lastname;

    private String email;
    @Id
    private ObjectId _id;

    /*@Field("email")
    @Indexed(unique = true)
    private EmailAddress emailAddress;
    private Set<Address> addresses = new HashSet<Address>();*/

    /**
     * Creates a new {@link Customers} from the given firstname and lastname.
     *
     * @param firstname must not be {@literal null} or empty.
     * @param lastname must not be {@literal null} or empty.
     */
    public Customers(String firstname, String lastname) {

        this.firstname = firstname;
        this.lastname = lastname;
    }

    protected Customers() {

    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }


    /**
     * Returns the firstname of the {@link Customers}.
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Returns the lastname of the {@link Customers}.
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the {@link Customers}.
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
